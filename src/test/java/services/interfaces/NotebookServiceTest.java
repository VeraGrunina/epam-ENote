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
import static org.mockito.Mockito.when;

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
    notebookServiceImplMock.createNotebook(notebookMock, 10L);
    verify(notebookRepositoryMock).save(notebookMock);
  }

  @Test
  public void updateNotebook() throws Exception {
    when(notebookMock.getId()).thenReturn(2L);
    notebookServiceImplMock.updateNotebook(notebookMock, 2L);
    verify(notebookRepositoryMock).save(notebookMock);
  }

  @Test
  public void readNotebookById() throws Exception {
    when(notebookRepositoryMock.exists(51L)).thenReturn(true);
    notebookServiceImplMock.readNotebookById(51L);
    verify(notebookRepositoryMock).getOne(51L);
  }

  @Test
  public void deleteNotebook() throws Exception {
    when(notebookRepositoryMock.exists(9L)).thenReturn(true);
    notebookServiceImplMock.deleteNotebook(9L);
    verify(notebookRepositoryMock).delete(9L);
  }

  @Test
  public void list() throws Exception {
    notebookServiceImplMock.list(8L);
    verify(notebookRepositoryMock).findAll();
  }

}