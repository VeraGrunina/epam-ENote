package generalPackage.config.services.interfaces;

import generalPackage.config.model.Notebook;

import java.util.Set;

public interface NotebookService {
    Notebook createNotebook(Notebook notebook, Long userId);
    Notebook updateNotebook(Notebook notebook, Long notebookId);
    Notebook readNotebookById(Long id);
    void deleteNotebook(Long id);
    Set<Notebook> list(Long userId);
}
