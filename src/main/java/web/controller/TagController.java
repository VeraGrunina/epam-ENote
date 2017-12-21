package web.controller;

import java.util.List;
import java.util.Set;
import model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import services.interfaces.TagService;

import web.utils.AuthService;

@RestController
public class TagController {

    private final TagService tagService;
    private final AuthService authService;

    @Autowired
    public TagController(TagService tagService, AuthService authService) {
        this.tagService = tagService;
        this.authService = authService;
    }

    @PostMapping("/tag")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTag(@RequestBody Tag tag) {
        tag = tagService.createTag(tag, authService.getCurrentUserId());
        String url = "/" + tag.getId();

        //response.setHeader("Location", url);
    }

    @PutMapping("/tag/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTag(@RequestBody Tag tag, @PathVariable Long tagId) {
        tagService.updateTag(tag, tagId);
    }

    @GetMapping("/tag/{id}")
    public Tag findTagById(@PathVariable Long id) {
        return tagService.readTagById(id);
    }

    @GetMapping("/tags")
    public Set<Tag> findAllTags() {
        return tagService.set(authService.getCurrentUserId());
    }

    @DeleteMapping("/tag/{tagId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeNotebookFromUser(@PathVariable Long tagId) {
        tagService.deleteTag(tagId);
    }

}
