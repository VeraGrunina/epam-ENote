package generalPackage.config.services.interfaces;

import java.util.Set;
import generalPackage.config.model.Tag;

public interface TagService {
    Tag createTag(Tag tag, Long userId);
    Tag updateTag(Tag tag, Long tagId);
    Tag readTagById(Long id);
    void deleteTag(Long id);
    Set<Tag> set(Long userId);
}
