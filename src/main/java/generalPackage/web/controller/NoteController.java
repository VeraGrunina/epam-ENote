package generalPackage.web.controller;

import generalPackage.data.entity.NoteWebModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import generalPackage.service.interfaces.NoteService;

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
    public void create(@RequestBody NoteWebModel noteWebModel, @PathVariable("notebookId") Long notebookId) {
        noteWebModel = noteService.createNote(noteWebModel);

        String url = "/" + noteWebModel.getId();

        //response.setHeader("Location", url);
    }

    @PutMapping("/note/{noteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateNote(@PathVariable Long noteId, @RequestBody NoteWebModel noteWebModel) {
        noteService.updateNote(noteWebModel);
    }

    @GetMapping("/note/{noteId}")
    public NoteWebModel findNoteById(@PathVariable Long noteId) {
        return noteService.readNoteById(noteId);
    }

    @GetMapping("/notes")
    public List<NoteWebModel> findAllNotes() {
        return noteService.list();
    }

    @DeleteMapping("/note/{noteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeNoteFromNotebook(@PathVariable Long noteId) {
        noteService.deleteNote(noteId);
    }


}
