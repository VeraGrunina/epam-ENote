package generalPackage.config.web.controller;

import generalPackage.config.model.Note;
import generalPackage.config.model.Notebook;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import generalPackage.config.services.interfaces.NoteService;

import java.util.List;

@RestController
@RequestMapping("/notebook/{notebookId}")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/note")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Note note, @PathVariable("notebookId") Long notebookId) {
        note = noteService.createNote(note, notebookId);

        String url = "/" + note.getId();

        //response.setHeader("Location", url);
    }

    @PutMapping("/note/{noteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateNote(@PathVariable Long noteId, @RequestBody Note note) {
        noteService.updateNote(note, noteId);
    }

    @GetMapping("/note/{noteId}")
    public Note findNoteById(@PathVariable Long noteId) {
        return noteService.readNoteById(noteId);
    }

    @GetMapping("/notes")
    public List<Note> findAllNotes() {
        return noteService.list();
    }

    @DeleteMapping("/note/{noteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeNoteFromNotebook(@PathVariable Long noteId) {
        noteService.deleteNote(noteId);
    }


}
