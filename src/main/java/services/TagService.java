package services;

import model.Tag;

import java.util.List;

public interface TagService {
    Tag createTag(Tag tag);
    Tag updateTag(Tag tag);
    Tag readTagById(Long id);
    void deleteTag(Tag id);
    List<Tag> list();
}
