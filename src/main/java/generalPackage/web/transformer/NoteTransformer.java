package generalPackage.web.transformer;

import generalPackage.data.entity.Note;
import generalPackage.data.entity.Tag;
import generalPackage.service.interfaces.NoteService;
import generalPackage.service.interfaces.TagService;
import generalPackage.web.model.NoteWebModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class NoteTransformer implements Transformer<Note, NoteWebModel> {

    @Autowired
    private NoteService noteService;

    @Autowired
    private TagService tagService;

    @Override
    public NoteWebModel unbind(Note source) {
        NoteWebModel noteWebModel = new NoteWebModel();

        noteWebModel.setId(source.getId());
        noteWebModel.setName(source.getName());
        noteWebModel.setText(source.getText());

        noteWebModel.setTagIds(source.getTags().stream().map(Tag::getId).collect(Collectors.toList()));
        noteWebModel.setTagNames(source.getTags().stream().map(Tag::getName).collect(Collectors.toList()));

        return noteWebModel;
    }

    @Override
    public Note bind(NoteWebModel source) {
        Note note = noteService.readNoteById(source.getId());

        if (note == null) {
            note = new Note();
        }

        note.setId(source.getId());
        note.setName(source.getName());
        note.setText(source.getText());

        note.setTags(source.getTagIds().stream().map(id -> tagService.readTagById(id)).collect(Collectors.toSet()));
        return note;
    }
}

//CREATE TABLE note (
//    id           BIGINT       AUTO_INCREMENT,
//    notebook_id  BIGINT       NOT NULL,
//    name         VARCHAR(45)  NOT NULL,
//    text         VARCHAR      NOT NULL,
//
//    CONSTRAINT note_pk PRIMARY KEY (id),
//    CONSTRAINT note__notebook_id_fk FOREIGN KEY (notebook_id) REFERENCES notebook (id) ON DELETE CASCADE ON UPDATE CASCADE
//);
