package generalPackage.service.impl;

import generalPackage.data.dao.TagDAO;
import generalPackage.data.entity.Tag;
import generalPackage.exception.ApplicationRuntimeException;
import generalPackage.service.interfaces.TagService;
import generalPackage.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDAO tagDAO;

    @Autowired
    private UserService userService;

    @Override
    public Tag createTag(Tag tag) {
        return tagDAO.save(tag);
    }

    @Override
    public Tag updateTag(Tag tag, Integer tagId) {
        if (tag.getId().equals(tagId)) {
            return tagDAO.save(tag);
        } else {
            throw new ApplicationRuntimeException("You can't change id");
        }
    }

    @Override
    public Tag readTagById(Integer id) {
        if (!tagDAO.exists(id)) {
            throw new ApplicationRuntimeException("Tag with id: " + id + "doesn't exist");
        }
        return tagDAO.getOne(id);
    }

    @Override
    public void deleteTag(Tag tag) {
        if (!tagDAO.exists(tag.getId())) {
            throw new ApplicationRuntimeException("Tag with id: " + tag.getId() + "doesn't exist");
        }
        tagDAO.delete(tag);
    }
}
