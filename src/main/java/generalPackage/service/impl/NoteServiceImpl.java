package generalPackage.service.impl;

import generalPackage.data.dao.NoteDAO;
import generalPackage.data.entity.Note;
import generalPackage.service.interfaces.NoteService;
import generalPackage.service.interfaces.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;

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
        return noteDAO.save(note);
    }

    @Override
    public Note updateNote(Note note, Integer noteId) {
        return noteDAO.save(note);
    }

    @Override
    public Note readNoteById(Integer id) {
        return noteDAO.getOne(id);
    }

    @Override
    public void deleteNote(Note note) {
        noteDAO.delete(note);
    }
}
