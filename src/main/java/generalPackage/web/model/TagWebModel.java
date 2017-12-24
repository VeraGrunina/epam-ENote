package generalPackage.web.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TagWebModel {

    private Integer id;

    private String name;

    private List<String> noteNames = new ArrayList<>();

    private List<Integer> noteIds = new ArrayList<>();
}

//CREATE TABLE tag (
//    id           INT          AUTO_INCREMENT,
//    user_id      INT          NOT NULL,
//    name         VARCHAR(45)  NOT NULL,
//
//    CONSTRAINT tag_pk PRIMARY KEY (id),
//    CONSTRAINT tag__user_id_fk FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE ON UPDATE CASCADE
//);
