package services.impl;

import exception.ApplicationRuntimeException;
import model.Note;
import model.Notebook;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.NoteRepository;
import services.interfaces.NoteService;
import services.interfaces.NotebookService;

import java.util.List;

public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;
    private final NotebookService notebookService;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository, NotebookService notebookService) {
        this.noteRepository = noteRepository;
        this.notebookService = notebookService;
    }

    @Override
    public Note createNote(Note note, Long notebookId) {
        Notebook notebook = notebookService.readNotebookById(notebookId);
        note.setNotebook(notebook);
        notebook.addNote(note);
        notebookService.updateNotebook(notebook);

        return noteRepository.save(note);
    }

    @Override
    public Note updateNote(Note note, Long noteId) {
        if (note.getId().equals(noteId)) {
            return noteRepository.save(note);
        } else {
            throw new ApplicationRuntimeException("You can't update this Node because it doesn't exist");
        }
    }

    @Override
    public Note readNoteById(Long id) {
        if (!noteRepository.exists(id)) {
            throw new ApplicationRuntimeException("Note with id: " + id + " doesn't exist");
        }

        return noteRepository.getOne(id);
    }

    @Override
    public void deleteNote(Long id) {
        noteRepository.delete(id);
    }

    @Override
    public List<Note> list() {
        return noteRepository.findAll();
    }
}
