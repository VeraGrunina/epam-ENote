package services;

import generalPackage.data.entity.NoteWebModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import generalPackage.data.dao.NoteDAO;
import generalPackage.service.impl.NoteServiceImpl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NoteServiceTest {

  @InjectMocks
  private NoteServiceImpl noteServiceImplMock;

  @Mock
  private NoteDAO noteDAOMock;

  @Mock
  private NoteWebModel noteMock;

  @Test
  public void createNote() throws Exception {

    noteServiceImplMock.createNote(noteMock);
    verify(noteDAOMock).save(noteMock);
  }

  @Test
  public void updateNote() throws Exception {
    when(noteMock.getId()).thenReturn(13L);
    noteServiceImplMock.updateNote(noteMock);
    verify(noteDAOMock).save(noteMock);
  }

  @Test
  public void readNoteById() throws Exception {
    when(noteDAOMock.exists(4L)).thenReturn(true);
    noteServiceImplMock.readNoteById(4L);
    verify(noteDAOMock).getOne(4L);
  }

  @Test
  public void deleteNote() throws Exception {
    when(noteDAOMock.exists(7L)).thenReturn(true);
    noteServiceImplMock.deleteNote(7L);
    verify(noteDAOMock).delete(7L);
  }

  @Test
  public void list() throws Exception {
    noteServiceImplMock.list();
    verify(noteDAOMock).findAll();
  }

}
