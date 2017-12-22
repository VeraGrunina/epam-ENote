package generalPackage.web.transformer;

import generalPackage.data.entity.Note;
import generalPackage.data.entity.Tag;
import generalPackage.service.interfaces.NoteService;
import generalPackage.service.interfaces.TagService;
import generalPackage.web.model.TagWebModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TagTransformer implements Transformer<Tag, TagWebModel> {

    @Autowired
    private TagService tagService;

    @Autowired
    private NoteService noteService;

    @Override
    public TagWebModel unbind(Tag source) {
        TagWebModel tagWebModel = new TagWebModel();

        tagWebModel.setId(source.getId());
        tagWebModel.setName(source.getName());

        tagWebModel.setNoteIds(source.getNotes().stream().map(Note::getId).collect(Collectors.toList()));
        tagWebModel.setNoteNames(source.getNotes().stream().map(Note::getName).collect(Collectors.toList()));

        return tagWebModel;
    }

    @Override
    public Tag bind(TagWebModel source) {
        Tag tag = tagService.readTagById(source.getId());

        if (tag == null) {
            tag = new Tag();
        }

        tag.setId(source.getId());
        tag.setName(source.getName());

        tag.setNotes(source.getNoteIds().stream().map(id -> noteService.readNoteById(id)).collect(Collectors.toSet()));
        return tag;
    }
}

//CREATE TABLE tag (
//    id           BIGINT       AUTO_INCREMENT,
//    name         VARCHAR(45)  NOT NULL,
//
//    CONSTRAINT tag_pk PRIMARY KEY (id)
//);
