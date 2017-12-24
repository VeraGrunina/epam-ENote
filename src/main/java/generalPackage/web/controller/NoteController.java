package generalPackage.web.controller;

import generalPackage.data.entity.Note;
import generalPackage.data.entity.Notebook;
import generalPackage.exception.ApplicationRuntimeException;
import generalPackage.service.interfaces.NoteService;
import generalPackage.service.interfaces.NotebookService;
import generalPackage.web.model.NoteWebModel;
import generalPackage.web.model.NotebookWebModel;
import generalPackage.web.transformer.NoteTransformer;
import generalPackage.web.transformer.NotebookTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notebook/{notebookId}")
public class NoteController {

    @Autowired
    private NoteService noteService;
    @Autowired
    private NotebookService notebookService;
    @Autowired
    private NoteTransformer noteTransformer;
    @Autowired
    private NotebookTransformer notebookTransformer;

    @PostMapping("/note")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody NoteWebModel noteWebModel, @PathVariable("notebookId") Integer notebookId) {

        Notebook notebook = notebookService.readNotebookById(notebookId);
        Note note = noteTransformer.bind(noteWebModel);
        note.setNotebook(notebook);

        noteService.createNote(note);

        String url = "/" + noteWebModel.getId();

        //response.setHeader("Location", url);
    }

    @PutMapping("/note/{noteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateNote(@PathVariable("noteId") Integer noteId, @RequestBody NoteWebModel noteWebModel) {
        Note note = noteTransformer.bind(noteWebModel);

        noteService.updateNote(note, noteId);
    }

    @GetMapping("/note/{noteId}")
    public NoteWebModel findNoteById(@PathVariable("noteId") Integer noteId,
                                     @PathVariable("notebookId") Integer notebookId) {

        Note note = noteService.readNoteById(noteId);

        if (!note.getNotebook().getId().equals(notebookId)) {
            throw new ApplicationRuntimeException("This notebook hasn't got this note with this id");
        }

        return noteTransformer.unbind(note);
    }

    @GetMapping("/notes")
    public NotebookWebModel findAllNotes(@PathVariable("notebookId") Integer notebookId) {
        Notebook notebook = notebookService.readNotebookById(notebookId);

        return notebookTransformer.unbind(notebook);
    }

    @DeleteMapping("/note/{noteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeNoteFromNotebook(@PathVariable Integer noteId,
                                       @PathVariable("notebookId") Integer notebookId) {
        Note note = noteService.readNoteById(noteId);

        if (!note.getNotebook().getId().equals(notebookId)) {
            throw new ApplicationRuntimeException("You can't delete this note, because this note in another notebook");
        }

        noteService.deleteNote(note);
    }


}
