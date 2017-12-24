package generalPackage.web.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class NotebookWebModel {

    private Integer id;

    private String name;

    private List<String> noteNames = new ArrayList<>();

    private List<Integer> noteIds = new ArrayList<>();
}

//CREATE TABLE notebook (
//    id           INT          AUTO_INCREMENT,
//    name         VARCHAR(45)  NOT NULL,
//    user_id      INT          NOT NULL,
//
//    CONSTRAINT notebook_pk PRIMARY KEY (id),
//    CONSTRAINT notebook__user_id_fk FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE ON UPDATE CASCADE
//);
