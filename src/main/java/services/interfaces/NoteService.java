package services.interfaces;

import model.Note;

import java.util.List;

public interface NoteService {
    Note createNote(Note note, Long notebookId);
    Note updateNote(Note note, Long noteId);
    Note readNoteById(Long id);
    void deleteNote(Long id);
    List<Note> list();
}
