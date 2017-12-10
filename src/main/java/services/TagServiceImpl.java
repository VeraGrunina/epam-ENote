package services;

import model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.TagRepository;

import java.util.List;


public class TagServiceImpl implements TagService{
    private final TagRepository tagRepository;

    @Autowired
    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Tag updateTag(Tag tag) {
        return tagRepository.saveAndFlush(tag);
    }

    @Override
    public Tag readTagById(Long id) {
        return tagRepository.getOne(id);
    }

    @Override
    public void deleteTag(Tag id) {
        tagRepository.delete(id);
    }

    @Override
    public List<Tag> list() {
        return tagRepository.findAll();
    }
}