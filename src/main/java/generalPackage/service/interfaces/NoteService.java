package generalPackage.service.interfaces;

import generalPackage.data.entity.Note;

public interface NoteService {

    Note createNote(Note note);

    Note readNoteById(Long id);

    Note updateNote(Note note);

    void deleteNote(Note note);
}
