package generalPackage.web.transformer;

import generalPackage.data.entity.Notebook;
import generalPackage.data.entity.Tag;
import generalPackage.data.entity.User;
import generalPackage.service.interfaces.NotebookService;
import generalPackage.service.interfaces.TagService;
import generalPackage.service.interfaces.UserService;
import generalPackage.web.model.UserWebModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserTransformer implements Transformer<User, UserWebModel> {

    @Autowired
    private UserService userService;

    @Autowired
    private NotebookService notebookService;

    @Autowired
    private TagService tagService;

    @Override
    public UserWebModel unbind(User source) {
        UserWebModel userWebModel = new UserWebModel();

        userWebModel.setLogin(source.getLogin());
        userWebModel.setName(source.getName());

        userWebModel.setNotebookIds(source.getNotebooks().stream().map(Notebook::getId).collect(Collectors.toList()));
        userWebModel.setNotebookNames(source.getNotebooks().stream().map(Notebook::getName).collect(Collectors.toList()));

        userWebModel.setTagIds(source.getTags().stream().map(Tag::getId).collect(Collectors.toList()));
        userWebModel.setTagNames(source.getTags().stream().map(Tag::getName).collect(Collectors.toList()));

        return userWebModel;
    }

    @Override
    public User bind(UserWebModel source) {
        User user = userService.readUserByLogin(source.getLogin());
        if (user == null) {
            user = new User();
        }

        user.setLogin(source.getLogin());
        user.setName(source.getName());

        user.setNotebooks(source.getNotebookIds().stream().map(id -> notebookService.readNotebookById(id)).collect(Collectors.toSet()));
        user.setTags(source.getTagIds().stream().map(id -> tagService.readTagById(id)).collect(Collectors.toSet()));

        return user;
    }
}

//CREATE TABLE user (
//    id           INT          AUTO_INCREMENT,
//    name         VARCHAR(45)  NOT NULL,
//    check        VARCHAR(45)  NOT NULL,
//
//    CONSTRAINT user_pk PRIMARY KEY (id)
//);
