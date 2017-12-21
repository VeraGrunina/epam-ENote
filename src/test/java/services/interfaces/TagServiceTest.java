package services.interfaces;

import model.Tag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import repositories.TagRepository;
import services.impl.TagServiceImpl;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TagServiceTest {

  @InjectMocks
  private TagServiceImpl tagServiceImplMock;

  @Mock
  private TagRepository tagRepositoryMock;

  @Mock
  private Tag tagMock;

  @Test
  public void createTag() throws Exception {
    tagServiceImplMock.createTag(tagMock, 1L);
    verify(tagRepositoryMock).save(tagMock);
  }

  @Test
  public void updateTag() throws Exception {
    tagServiceImplMock.updateTag(tagMock, 1L);
    verify(tagRepositoryMock).save(tagMock);
  }

  @Test
  public void readTagById() throws Exception {
    tagServiceImplMock.readTagById(8L);
    verify(tagRepositoryMock).getOne(8L);
  }

  @Test
  public void deleteTag() throws Exception {
    tagServiceImplMock.deleteTag(2L);
    verify(tagRepositoryMock).delete(2L);
  }

  @Test
  public void list() throws Exception {
    tagServiceImplMock.set(null);
    verify(tagRepositoryMock).findAll();
  }

}