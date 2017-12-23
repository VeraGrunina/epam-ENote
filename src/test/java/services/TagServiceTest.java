package services;

import generalPackage.data.dao.TagDAO;
import generalPackage.data.entity.Tag;
import generalPackage.service.impl.TagServiceImpl;
import generalPackage.web.model.TagWebModel;
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
    private Tag tagMock;

    @Mock
    private TagDAO tagDAOMock;

    @Mock
    private TagWebModel tagWebModelMock;

    @Test
    public void createTag() throws Exception {
        tagServiceImplMock.createTag(tagMock);
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
        tagServiceImplMock.deleteTag(tagMock);
        verify(tagDAOMock).delete(tagMock);
    }


}
