package services.impl;

import model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.NoteRepository;
import services.interfaces.NoteService;

import java.util.List;

public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public Note updateNote(Note note) {
        return noteRepository.saveAndFlush(note);
    }

    @Override
    public Note readNoteById(Long id) {
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
