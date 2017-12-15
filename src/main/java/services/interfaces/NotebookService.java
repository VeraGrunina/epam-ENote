package services.interfaces;

import model.Notebook;

import java.util.List;

public interface NotebookService {
    Notebook createNotebook(Notebook note);
    Notebook updateNotebook(Notebook note);
    Notebook readNotebookById(Long id);
    void deleteNotebook(Long id);
    List<Notebook> list();
}
