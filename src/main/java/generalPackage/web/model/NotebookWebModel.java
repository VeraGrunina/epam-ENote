package generalPackage.web.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class NotebookWebModel {

    private Long id;

    private String name;

    private List<String> noteNames = new ArrayList<>();

    private List<Long> noteIds = new ArrayList<>();
}

//CREATE TABLE notebook (
//    id           BIGINT       AUTO_INCREMENT,
//    name         VARCHAR(45)  NOT NULL,
//    user_id      BIGINT       NOT NULL,
//
//    CONSTRAINT notebook_pk PRIMARY KEY (id),
//    CONSTRAINT notebook__user_id_fk FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE ON UPDATE CASCADE
//);
