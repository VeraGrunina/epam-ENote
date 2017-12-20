package web.controller;

import model.Note;
import model.Notebook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import repositories.NoteRepository;
import services.interfaces.NoteService;

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
    public void update(@PathVariable Long noteId, @RequestBody Note note) {
        noteService.updateNote(note, noteId);
    }

    @GetMapping("/note/{noteId}")
    public Note findById(@PathVariable Long noteId) {
        return noteService.readNoteById(noteId);
    }

    @GetMapping("/notes")
    public List<Note> findAll() {
        return noteService.list();
    }


}
