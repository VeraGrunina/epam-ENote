package services;

import generalPackage.data.entity.NotebookWebModel;
import generalPackage.data.dao.NotebookDAO;
import generalPackage.service.impl.NotebookServiceImpl;
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
    private NotebookDAO notebookDAOMock;

    @Mock
    private NotebookWebModel notebookMock;

    @Test
    public void createNotebook() throws Exception {
        notebookServiceImplMock.createNotebook(notebookMock, 10L);
        verify(notebookDAOMock).save(notebookMock);
    }

    @Test
    public void updateNotebook() throws Exception {
        when(notebookMock.getId()).thenReturn(2L);
        notebookServiceImplMock.updateNotebook(notebookMock, 2L);
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
        when(notebookDAOMock.exists(9L)).thenReturn(true);
        notebookServiceImplMock.deleteNotebook(9L);
        verify(notebookDAOMock).delete(9L);
    }

    @Test
    public void list() throws Exception {
        notebookServiceImplMock.list(8L);
        verify(notebookDAOMock).findAll();
    }
}
