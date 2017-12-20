package services.interfaces;

import static org.junit.Assert.*;

import model.Note;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import repositories.NoteRepository;
import services.impl.NoteServiceImpl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NoteServiceTest {

  @InjectMocks
  private NoteServiceImpl noteServiceImplMock;

  @Mock
  private NoteRepository noteRepositoryMock;

  @Mock
  private Note noteMock;

  @Test
  public void createNote() throws Exception {

    noteServiceImplMock.createNote(noteMock, 15L);
    verify(noteRepositoryMock).save(noteMock);
  }

  @Test
  public void updateNote() throws Exception {
    when(noteMock.getId()).thenReturn(13L);
    noteServiceImplMock.updateNote(noteMock, 13L);
    verify(noteRepositoryMock).save(noteMock);
  }

  @Test
  public void readNoteById() throws Exception {
    when(noteRepositoryMock.exists(4L)).thenReturn(true);
    noteServiceImplMock.readNoteById(4L);
    verify(noteRepositoryMock).getOne(4L);
  }

  @Test
  public void deleteNote() throws Exception {
    when(noteRepositoryMock.exists(7L)).thenReturn(true);
    noteServiceImplMock.deleteNote(7L);
    verify(noteRepositoryMock).delete(7L);
  }

  @Test
  public void list() throws Exception {
    noteServiceImplMock.list();
    verify(noteRepositoryMock).findAll();
  }

}