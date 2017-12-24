package generalPackage.service.impl;

import generalPackage.data.dao.NotebookDAO;
import generalPackage.data.entity.Notebook;
import generalPackage.data.entity.User;
import generalPackage.service.interfaces.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class NotebookServiceImpl implements NotebookService {

    @Autowired
    private NotebookDAO notebookDAO;

    @Override
    public Notebook createNotebook(Notebook notebook) {
        return notebookDAO.save(notebook);
    }

    @Override
    public Notebook updateNotebook(Notebook notebook) {
        return notebookDAO.save(notebook);
    }

    @Override
    public Notebook readNotebookById(Integer id) {
        return notebookDAO.getOne(id);
    }

    @Override
    public void deleteNotebook(Notebook notebook) {
        notebookDAO.delete(notebook);
    }

    @Override
    public Set<Notebook> list(User user) {
        return user.getNotebooks();
    }
}
