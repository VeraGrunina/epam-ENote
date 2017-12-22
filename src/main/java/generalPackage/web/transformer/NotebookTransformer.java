package generalPackage.web.transformer;

import generalPackage.data.entity.Note;
import generalPackage.data.entity.Notebook;
import generalPackage.service.interfaces.NoteService;
import generalPackage.service.interfaces.NotebookService;
import generalPackage.web.model.NotebookWebModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class NotebookTransformer implements Transformer<Notebook, NotebookWebModel> {

    @Autowired
    private NotebookService notebookService;

    @Autowired
    private NoteService noteService;

    @Override
    public NotebookWebModel unbind(Notebook source) {
        NotebookWebModel notebookWebModel = new NotebookWebModel();

        notebookWebModel.setId(source.getId());
        notebookWebModel.setName(source.getName());

        notebookWebModel.setNoteIds(source.getNotes().stream().map(Note::getId).collect(Collectors.toList()));
        notebookWebModel.setNoteNames(source.getNotes().stream().map(Note::getName).collect(Collectors.toList()));

        return notebookWebModel;
    }

    @Override
    public Notebook bind(NotebookWebModel source) {
        Notebook notebook = notebookService.readNotebookById(source.getId());
        if (notebook == null) {
            notebook = new Notebook();
        }
        notebook.setId(source.getId());
        notebook.setName(source.getName());

        notebook.setNotes(source.getNoteIds().stream().map(id -> noteService.readNoteById(id)).collect(Collectors.toSet()));

        return notebook;
    }
}

//CREATE TABLE notebook (
//    id           BIGINT       AUTO_INCREMENT,
//    name         VARCHAR(45)  NOT NULL,
//    user_id      BIGINT       NOT NULL,
//
//    CONSTRAINT notebook_pk PRIMARY KEY (id),
//    CONSTRAINT notebook__user_id_fk FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE ON UPDATE CASCADE
//);
