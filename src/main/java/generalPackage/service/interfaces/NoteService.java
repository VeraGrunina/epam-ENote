package generalPackage.service.interfaces;

import generalPackage.data.entity.Note;

public interface NoteService {

    Note createNote(Note note);

    Note readNoteById(Integer id);

    Note updateNote(Note note, Integer noteId);

    void deleteNote(Note note);
}
