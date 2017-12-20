package services.interfaces;

import static org.junit.Assert.*;

import model.Notebook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import repositories.NotebookRepository;
import services.impl.NotebookServiceImpl;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class NotebookServiceTest {

  @InjectMocks
  private NotebookServiceImpl notebookServiceImplMock;

  @Mock
  private NotebookRepository notebookRepositoryMock;

  @Mock
  private Notebook notebookMock;

  @Test
  public void createNotebook() throws Exception {
    notebookServiceImplMock.createNotebook(notebookMock);
    verify(notebookRepositoryMock).save(notebookMock);
  }

  @Test
  public void updateNotebook() throws Exception {
    notebookServiceImplMock.updateNotebook(notebookMock);
    verify(notebookRepositoryMock).save(notebookMock);
  }

  @Test
  public void readNotebookById() throws Exception {
    notebookServiceImplMock.readNotebookById(51L);
    verify(notebookRepositoryMock).getOne(51L);
  }

  @Test
  public void deleteNotebook() throws Exception {
    notebookServiceImplMock.deleteNotebook(9L);
    verify(notebookRepositoryMock).delete(9L);
  }

  @Test
  public void list() throws Exception {
    notebookServiceImplMock.list();
    verify(notebookRepositoryMock).findAll();
  }

}