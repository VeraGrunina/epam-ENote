package generalPackage.service.impl;

import generalPackage.exception.ApplicationRuntimeException;
import generalPackage.data.entity.Note;
import generalPackage.data.entity.Notebook;
import generalPackage.data.dao.NoteDAO;
import generalPackage.service.interfaces.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import generalPackage.service.interfaces.NoteService;

import java.util.List;

public class NoteServiceImpl implements NoteService {

    private final NoteDAO noteDAO;
    private final NotebookService notebookService;

    @Autowired
    public NoteServiceImpl(NoteDAO noteDAO, NotebookService notebookService) {
        this.noteDAO = noteDAO;
        this.notebookService = notebookService;
    }

    @Override
    public Note createNote(Note note) {
        Notebook notebook = notebookService.readNotebookById(notebookId);
        note.setNotebook(notebook);
        notebook.addNote(note);
        notebookService.updateNotebook(notebook, notebookId);

        return noteDAO.save(note);
    }

    @Override
    public Note updateNote(Note note) {
        if (note.getId().equals(noteId)) {
            return noteDAO.save(note);
        } else {
            throw new ApplicationRuntimeException("You can't update this Node because it doesn't exist");
        }
    }

    @Override
    public Note readNoteById(Long id) {
        if (!noteDAO.exists(id)) {
            throw new ApplicationRuntimeException("Note with id: " + id + " doesn't exist");
        }

        return noteDAO.getOne(id);
    }

    @Override
    public void deleteNote(Long id) {
        if (!noteDAO.exists(id)) {
            throw new ApplicationRuntimeException("Note with id: " + id + " doesn't exist");
        }
        noteDAO.delete(id);
    }

    @Override
    public List<Note> list() {
        return noteDAO.findAll();
    }
}
