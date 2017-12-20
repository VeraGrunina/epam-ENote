package web.controller;

import model.Notebook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import services.interfaces.NotebookService;

@RestController
@RequestMapping("/user/{userId}")
public class NotebookController {

  private final NotebookService notebookService;

  @Autowired
  public NotebookController(NotebookService notebookService) {
    this.notebookService = notebookService;
  }

  @PostMapping("/notebook")
  @ResponseStatus(HttpStatus.CREATED)
  public void create(@RequestBody Notebook notebook, @PathVariable("userId") Long userId) {
    notebook = notebookService.createNotebook(notebook);

    String url = "/" + notebook.getId();

    //response.setHeader("Location", url);
  }

  @PutMapping("/notebook/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void update(@PathVariable Long id, @RequestBody Notebook notebook) {
    notebookService.updateNotebook(notebook);
  }

  @GetMapping("notebook/{id}")
  public Notebook findById(@PathVariable Long id) {
    return notebookService.readNotebookById(id);
  }

}
