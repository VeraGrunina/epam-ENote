package services;

import generalPackage.data.dao.NotebookDAO;
import generalPackage.data.entity.Notebook;
import generalPackage.data.entity.User;
import generalPackage.service.impl.NotebookServiceImpl;
import generalPackage.web.model.NotebookWebModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NotebookServiceTest {

    @InjectMocks
    private NotebookServiceImpl notebookServiceImplMock;

    @Mock
    private Notebook notebookMock;

    @Mock
    private User userMock;

    @Mock
    private NotebookDAO notebookDAOMock;

    @Mock
    private NotebookWebModel notebookWebModelMock;

    @Test
    public void createNotebook() throws Exception {
        notebookServiceImplMock.createNotebook(notebookMock);
        verify(notebookDAOMock).save(notebookMock);
    }

    @Test
    public void updateNotebook() throws Exception {
        when(notebookMock.getId()).thenReturn(2L);
        notebookServiceImplMock.updateNotebook(notebookMock);
        verify(notebookDAOMock).save(notebookMock);
    }

    @Test
    public void readNotebookById() throws Exception {
        when(notebookDAOMock.exists(51L)).thenReturn(true);
        notebookServiceImplMock.readNotebookById(51L);
        verify(notebookDAOMock).getOne(51L);
    }

    @Test
    public void deleteNotebook() throws Exception {
        notebookServiceImplMock.deleteNotebook(notebookMock);
        verify(notebookDAOMock).delete(notebookMock);
    }

    @Test
    public void list() throws Exception {
        notebookServiceImplMock.list(userMock);
        verify(notebookDAOMock).findAll();
    }
}
