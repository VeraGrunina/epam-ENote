package generalPackage.web.controller;

import generalPackage.data.entity.Tag;
import generalPackage.data.entity.User;
import generalPackage.exception.ApplicationRuntimeException;
import generalPackage.service.interfaces.AuthService;
import generalPackage.service.interfaces.TagService;
import generalPackage.service.interfaces.UserService;
import generalPackage.web.model.TagWebModel;
import generalPackage.web.model.UserWebModel;
import generalPackage.web.transformer.TagTransformer;
import generalPackage.web.transformer.UserTransformer;
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
    @Autowired
    private UserService userService;
    @Autowired
    private TagTransformer tagTransformer;
    @Autowired
    private UserTransformer userTransformer;

    @PostMapping("/tag")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTag(@RequestBody TagWebModel tagWebModel) {
        Long currentUserId = authService.getCurrentUserId();

        if (currentUserId == null) {
            return; // redirect:/login
        }

        User user = userService.readUserById(currentUserId);
        Tag tag = tagTransformer.bind(tagWebModel);
        tag.setUser(user);

        tagService.createTag(tag);
        String url = "/" + tagWebModel.getId();

        //response.setHeader("Location", url);
    }

    @PutMapping("/tag/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTag(@RequestBody TagWebModel tagWebModel, @PathVariable Long tagId) {
        Long currentUserId = authService.getCurrentUserId();

        if (currentUserId == null) {
            return; // redirect:/login
        }

        User user = userService.readUserById(currentUserId);
        Tag tag = tagTransformer.bind(tagWebModel);

        if (!tag.getId().equals(tagId)) {
            throw new ApplicationRuntimeException("You can't change tag id");
        }

        tag.setUser(user);

        tagService.updateTag(tag);
    }

    @GetMapping("/tag/{id}")
    public TagWebModel findTagById(@PathVariable Long id) {
        Long currentUserId = authService.getCurrentUserId();

        if (currentUserId == null) {
            return null; // redirect:/login
        }

        Tag tag = tagService.readTagById(id);
        if (!tag.getUser().getId().equals(currentUserId)) {
            throw new ApplicationRuntimeException("It's not your tag");
        }

        return tagTransformer.unbind(tag);
    }

    @GetMapping("/tags")
    public UserWebModel findAllTags() {
        Long currentUserId = authService.getCurrentUserId();

        if (currentUserId == null) {
            return null; // redirect:/login
        }

        User user = userService.readUserById(currentUserId);
        return userTransformer.unbind(user);
    }

    @DeleteMapping("/tag/{tagId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeNotebookFromUser(@PathVariable Long tagId) {
        Long currentUserId = authService.getCurrentUserId();

        if (currentUserId == null) {
            return; // redirect:/login
        }

        Tag tag = tagService.readTagById(tagId);

        if(!tag.getUser().getId().equals(currentUserId)) {
            throw new ApplicationRuntimeException("You can't delete this tag, because it's not your tag");
        }

        tagService.deleteTag(tag);
    }
}
