package services;

import generalPackage.data.entity.Note;
import generalPackage.web.model.NoteWebModel;
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
  private Note noteMock;

  @Mock
  private NoteDAO noteDAOMock;

  @Mock
  private NoteWebModel noteWebModelMock;

  @Test
  public void createNote() throws Exception {

    noteServiceImplMock.createNote(noteMock);
    verify(noteDAOMock).save(noteMock);
  }

  @Test
  public void updateNote() throws Exception {
    when(noteMock.getId()).thenReturn(13);
    noteServiceImplMock.updateNote(noteMock, 13);
    verify(noteDAOMock).save(noteMock);
  }

  @Test
  public void readNoteById() throws Exception {
    when(noteDAOMock.exists(4)).thenReturn(true);
    noteServiceImplMock.readNoteById(4);
    verify(noteDAOMock).getOne(4);
  }

  @Test
  public void deleteNote() throws Exception {
    when(noteDAOMock.exists(7)).thenReturn(true);
    noteServiceImplMock.deleteNote(noteMock);
    verify(noteDAOMock).delete(noteMock);
  }

}
