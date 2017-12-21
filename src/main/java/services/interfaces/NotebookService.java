package services.interfaces;

import model.Notebook;

import java.util.List;
import java.util.Set;

public interface NotebookService {
    Notebook createNotebook(Notebook notebook, Long userId);
    Notebook updateNotebook(Notebook notebook, Long notebookId);
    Notebook readNotebookById(Long id);
    void deleteNotebook(Long id);
    Set<Notebook> list(Long userId);
}
