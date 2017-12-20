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
    noteServiceImplMock.createNote(noteMock);
    verify(noteRepositoryMock).save(noteMock);
  }

  @Test
  public void updateNote() throws Exception {
    noteServiceImplMock.updateNote(noteMock);
    verify(noteRepositoryMock).save(noteMock);
  }

  @Test
  public void readNoteById() throws Exception {
    noteServiceImplMock.readNoteById(4L);
    verify(noteRepositoryMock).getOne(4L);
  }

  @Test
  public void deleteNote() throws Exception {
    noteServiceImplMock.deleteNote(7L);
    verify(noteRepositoryMock).delete(7L);
  }

  @Test
  public void list() throws Exception {
    noteServiceImplMock.list();
    verify(noteRepositoryMock).findAll();
  }

}