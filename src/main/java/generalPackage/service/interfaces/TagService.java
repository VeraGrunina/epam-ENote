package generalPackage.service.interfaces;

import generalPackage.data.entity.Tag;

public interface TagService {

    Tag createTag(Tag tag);

    Tag readTagById(Long id);

    Tag updateTag(Tag tag);

    void deleteTag(Tag tag);
}
