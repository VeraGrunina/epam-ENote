package generalPackage.web.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TagWebModel {

    private Long id;

    private String name;

    private List<String> noteNames = new ArrayList<>();

    private List<Long> noteIds = new ArrayList<>();
}

//CREATE TABLE tag (
//    id           BIGINT       AUTO_INCREMENT,
//    name         VARCHAR(45)  NOT NULL,
//
//    CONSTRAINT tag_pk PRIMARY KEY (id)
//);
