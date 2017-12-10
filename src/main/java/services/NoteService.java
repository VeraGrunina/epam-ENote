package services;

import model.Note;

import java.util.List;

public interface NoteService {
    Note createNote(Note note);
    Note updateNote(Note note);
    Note readNoteById(Long id);
    void deleteNote(Long id);
    List<Note> list();
}
