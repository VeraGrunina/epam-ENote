package generalPackage.config.services.impl;

import generalPackage.config.exception.ApplicationRuntimeException;
import java.util.Set;
import generalPackage.config.model.Tag;
import generalPackage.config.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import generalPackage.config.repositories.TagRepository;
import generalPackage.config.services.interfaces.TagService;
import generalPackage.config.services.interfaces.UserService;


public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;
    private final UserService userService;

    @Autowired
    public TagServiceImpl(TagRepository tagRepository, UserService userService) {
        this.tagRepository = tagRepository;
        this.userService = userService;
    }

    @Override
    public Tag createTag(Tag tag, Long userId) {
        User user = userService.readUserById(userId);

        tag.setUser(user);
        user.addTag(tag);
        userService.updateUser(user);

        return tagRepository.save(tag);
    }

    @Override
    public Tag updateTag(Tag tag, Long tagId) {
        if (tag.getId().equals(tagId)) {
            return tagRepository.save(tag);
        } else {
            throw new ApplicationRuntimeException("You can't change id");
        }
    }

    @Override
    public Tag readTagById(Long id) {
        if (!tagRepository.exists(id)) {
            throw new ApplicationRuntimeException("Tag with id: " + id + "doesn't exist");
        }
        return tagRepository.getOne(id);
    }

    @Override
    public void deleteTag(Long id) {
        if (!tagRepository.exists(id)) {
            throw new ApplicationRuntimeException("Tag with id: " + id + "doesn't exist");
        }
        tagRepository.delete(id);
    }

    @Override
    public Set<Tag> set(Long userId) {
        User user = userService.readUserById(userId);
        return user.getTags();
    }
}
