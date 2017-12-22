package generalPackage.web.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserWebModel {

    private String name;

    private String login;

    private List<String> notebookNames = new ArrayList<>();

    private List<Long> notebookIds = new ArrayList<>();

    private List<String> tagNames = new ArrayList<>();

    private List<Long> tagIds = new ArrayList<>();
}

//CREATE TABLE user (
//    id           BIGINT       AUTO_INCREMENT,
//    name         VARCHAR(45)  NOT NULL,
//    login        VARCHAR(45)  NOT NULL,
//    password     VARCHAR(45)  NOT NULL,
//
//    CONSTRAINT user_pk PRIMARY KEY (id)
//);
