package generalPackage.web.controller;

import generalPackage.data.entity.Notebook;
import generalPackage.data.entity.User;
import generalPackage.service.interfaces.AuthService;
import generalPackage.service.interfaces.NotebookService;
import generalPackage.service.interfaces.UserService;
import generalPackage.web.model.NotebookWebModel;
import generalPackage.web.model.UserWebModel;
import generalPackage.web.transformer.NotebookTransformer;
import generalPackage.web.transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.ValidationException;

@RestController
//@Api(value = "Hello World", description = "Hello World Controller")
public class NotebookController {

    @Autowired
    private NotebookService notebookService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserTransformer userTransformer;
    @Autowired
    private AuthService authService;
    @Autowired
    private NotebookTransformer notebookTransformer;

    @PostMapping("/notebook")
    public void createNotebook(@RequestBody @Valid NotebookWebModel notebookWebModel, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new ValidationException(String.format(
                    "NotebookWebModel has %s validation counts",
                    bindingResult.getFieldErrorCount()));
        }

        Integer currentUserId = authService.getCurrentUserId();

        if (currentUserId == null) {
            return; // redirect:/check
        }

        User user = userService.readUserById(currentUserId);
        Notebook notebook = notebookTransformer.bind(notebookWebModel);
        notebook.setUser(user);

        notebookService.createNotebook(notebook);
    }

    @PutMapping("/notebook/{id}")
    public void updateNotebook(@RequestBody NotebookWebModel notebookWebModel, @PathVariable Integer id) {
        Integer currentUserId = authService.getCurrentUserId();

        if (currentUserId == null) {
            return; // redirect:/check
        }

        User user = userService.readUserById(currentUserId);
        Notebook notebook = notebookTransformer.bind(notebookWebModel);
        notebook.setUser(user);

        notebookService.updateNotebook(notebook);
    }

    @GetMapping("/notebook/{id}")
    public NotebookWebModel findNotebookById(@PathVariable Integer id) {
        Integer currentUserId = authService.getCurrentUserId();

        if (currentUserId == null) {
            return null; // redirect:/check
        }

        Notebook notebook = notebookService.readNotebookById(id);

        if (!notebook.getUser().getId().equals(currentUserId))
            return null; // not allowed

        return notebookTransformer.unbind(notebook);
    }

    @GetMapping("/notebooks")
    public UserWebModel findAllNotebooks() {
        Integer currentUserId = authService.getCurrentUserId();

        if (currentUserId == null) {
            return null; // redirect:/login
        }

        User user = userService.readUserById(currentUserId);
        return userTransformer.unbind(user);
    }

    @DeleteMapping("/notebook/{id}")
    public void removeNotebookFromUser(@PathVariable Integer id) {
        Integer currentUserId = authService.getCurrentUserId();

        if (currentUserId == null) {
            return; // redirect:/check
        }

        Notebook notebook = notebookService.readNotebookById(id);

        if (!notebook.getUser().getId().equals(currentUserId))
            return; // not allowed

        notebookService.deleteNotebook(notebook);
    }
}
