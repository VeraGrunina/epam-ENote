package generalPackage.service.interfaces;

import generalPackage.data.entity.Tag;

public interface TagService {

    Tag createTag(Tag tag);

    Tag readTagById(Integer id);

    Tag updateTag(Tag tag, Integer tagId);

    void deleteTag(Tag tag);
}
