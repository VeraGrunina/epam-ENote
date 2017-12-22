package generalPackage.service.interfaces;

import generalPackage.data.entity.Notebook;
import generalPackage.data.entity.User;

import java.util.Set;

public interface NotebookService {

    Notebook createNotebook(Notebook notebook);

    Notebook readNotebookById(Long id);

    Notebook updateNotebook(Notebook notebook);

    void deleteNotebook(Notebook notebook);

    Set<Notebook> list(User user);
}
