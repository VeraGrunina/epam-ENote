package services;

import generalPackage.data.entity.TagWebModel;
import generalPackage.data.dao.TagDAO;
import generalPackage.service.impl.TagServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TagServiceTest {

    @InjectMocks
    private TagServiceImpl tagServiceImplMock;

    @Mock
    private TagDAO tagDAOMock;

    @Mock
    private TagWebModel tagMock;

    @Test
    public void createTag() throws Exception {
        tagServiceImplMock.createTag(tagMock, 1L);
        verify(tagDAOMock).save(tagMock);
    }

    @Test
    public void updateTag() throws Exception {
        tagServiceImplMock.updateTag(tagMock, 1L);
        verify(tagDAOMock).save(tagMock);
    }

    @Test
    public void readTagById() throws Exception {
        tagServiceImplMock.readTagById(8L);
        verify(tagDAOMock).getOne(8L);
    }

    @Test
    public void deleteTag() throws Exception {
        tagServiceImplMock.deleteTag(2L);
        verify(tagDAOMock).delete(2L);
    }

    @Test
    public void list() throws Exception {
        tagServiceImplMock.set(null);
        verify(tagDAOMock).findAll();
    }

}
