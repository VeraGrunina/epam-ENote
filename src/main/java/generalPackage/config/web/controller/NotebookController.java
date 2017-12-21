package generalPackage.config.web.controller;

import generalPackage.config.model.Note;
import generalPackage.config.model.Notebook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import generalPackage.config.services.interfaces.NotebookService;

import java.util.Set;
import generalPackage.config.web.utils.AuthService;

@RestController
public class NotebookController {

  private final NotebookService notebookService;
  private final AuthService authService;

  @Autowired
  public NotebookController(NotebookService notebookService, AuthService authService) {
    this.notebookService = notebookService;
    this.authService = authService;
  }

  @PostMapping("/notebook")
  @ResponseStatus(HttpStatus.CREATED)
  public void createNotebook(@RequestBody Notebook notebook) {
    notebook = notebookService.createNotebook(notebook, authService.getCurrentUserId());

    String url = "/" + notebook.getId();

    //response.setHeader("Location", url);
  }

  @PutMapping("/notebook/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateNotebook(@RequestBody Notebook notebook, @PathVariable Long id) {
    notebookService.updateNotebook(notebook, id);
  }

  @GetMapping("/notebook/{id}")
  public Notebook findNotebookById(@PathVariable Long id) {
    return notebookService.readNotebookById(id);
  }

  @GetMapping("/notebooks")
  public Set<Notebook> findAllNotebooks() {
    return notebookService.list(authService.getCurrentUserId());
  }

  @DeleteMapping("/notebook/{notebookId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void removeNotebookFromUser(@PathVariable Long notebookId) {
    notebookService.deleteNotebook(notebookId);
  }

}
