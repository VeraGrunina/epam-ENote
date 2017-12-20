package services.impl;

import exception.ApplicationRuntimeException;
import model.Notebook;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.NotebookRepository;
import services.interfaces.NotebookService;
import services.interfaces.UserService;

import java.util.List;
import java.util.Set;

public class NotebookServiceImpl implements NotebookService {
    private final NotebookRepository notebookRepository;
    private final UserService userService;

    @Autowired
    public NotebookServiceImpl(NotebookRepository notebookRepository, UserService userService) {
        this.notebookRepository = notebookRepository;
        this.userService = userService;
    }

    @Override
    public Notebook createNotebook(Notebook notebook, Long userId) {
        User user = userService.readUserById(userId);
        notebook.setUser(user);
        user.addNotebook(notebook);
        userService.updateUser(user);

        return notebookRepository.save(notebook);
    }

    @Override
    public Notebook updateNotebook(Notebook notebook, Long notebookId) {
        if (notebook.getId().equals(notebookId)) {
            return notebookRepository.save(notebook);
        } else {
            throw new ApplicationRuntimeException("You can't change Notebook id");
        }
    }

    @Override
    public Notebook readNotebookById(Long id) {
        if (!notebookRepository.exists(id)) {
            throw new ApplicationRuntimeException("Notebook with id: " + id + " doesn't exist");
        }
        return notebookRepository.getOne(id);
    }

    @Override
    public void deleteNotebook(Long id) {
        if (!notebookRepository.exists(id)) {
            throw new ApplicationRuntimeException("Notebook with id: " + id + " doesn't exist");
        }
        notebookRepository.delete(id);
    }

    @Override
    public Set<Notebook> list(Long userId) {
        User user = userService.readUserById(userId);
        return user.getNotebookSet();
    }
}
