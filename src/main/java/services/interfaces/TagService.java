package services.interfaces;

import java.util.Set;
import model.Tag;

import java.util.List;

public interface TagService {
    Tag createTag(Tag tag, Long userId);
    Tag updateTag(Tag tag, Long tagId);
    Tag readTagById(Long id);
    void deleteTag(Long id);
    Set<Tag> set(Long userId);
}
