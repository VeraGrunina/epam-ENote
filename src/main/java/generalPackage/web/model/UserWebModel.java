package generalPackage.web.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserWebModel {

    private String name;

    private String login;

    private String password;

    private List<String> notebookNames = new ArrayList<>();

    private List<Integer> notebookIds = new ArrayList<>();

    private List<String> tagNames = new ArrayList<>();

    private List<Integer> tagIds = new ArrayList<>();
}

//CREATE TABLE user (
//    id           INT          AUTO_INCREMENT,
//    name         VARCHAR(45)  NOT NULL,
//    check        VARCHAR(45)  NOT NULL,
//
//    CONSTRAINT user_pk PRIMARY KEY (id)
//);
