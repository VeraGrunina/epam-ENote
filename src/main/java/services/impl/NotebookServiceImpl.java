package services.impl;

import model.Notebook;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.NotebookRepository;
import services.interfaces.NotebookService;

import java.util.List;

public class NotebookServiceImpl implements NotebookService {
    private final NotebookRepository notebookRepository;

    @Autowired
    public NotebookServiceImpl(NotebookRepository notebookRepository) {
        this.notebookRepository = notebookRepository;
    }

    @Override
    public Notebook createNotebook(Notebook note, Long userId) {
        note.setUserId(userId);
        return notebookRepository.save(note);
    }

    @Override
    public Notebook updateNotebook(Notebook note) {
        return notebookRepository.save(note);
    }

    @Override
    public Notebook readNotebookById(Long id) {
        return notebookRepository.getOne(id);
    }

    @Override
    public void deleteNotebook(Long id) {
        notebookRepository.delete(id);
    }

    @Override
    public List<Notebook> list() {
        return notebookRepository.findAll();
    }
}
