package generalPackage.web.controller;

import generalPackage.data.entity.TagWebModel;
import generalPackage.service.interfaces.AuthService;
import generalPackage.service.interfaces.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class TagController {
    @Autowired
    private TagService tagService;
    @Autowired
    private AuthService authService;

    @PostMapping("/tag")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTag(@RequestBody TagWebModel tagWebModel) {
        tagWebModel = tagService.createTag(tagWebModel, authService.getCurrentUserId());
        String url = "/" + tagWebModel.getId();

        //response.setHeader("Location", url);
    }

    @PutMapping("/tag/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTag(@RequestBody TagWebModel tagWebModel, @PathVariable Long tagId) {
        tagService.updateTag(tagWebModel, tagId);
    }

    @GetMapping("/tag/{id}")
    public TagWebModel findTagById(@PathVariable Long id) {
        return tagService.readTagById(id);
    }

    @GetMapping("/tags")
    public Set<TagWebModel> findAllTags() {
        return tagService.set(authService.getCurrentUserId());
    }

    @DeleteMapping("/tag/{tagId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeNotebookFromUser(@PathVariable Long tagId) {
        tagService.deleteTag(tagId);
    }
}
