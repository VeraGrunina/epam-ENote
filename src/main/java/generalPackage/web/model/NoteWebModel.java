package generalPackage.web.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class NoteWebModel {

    private Long id;

    private String name;

    private String text;

    private List<String> tagNames = new ArrayList<>();

    private List<Long> tagIds = new ArrayList<>();
}

//CREATE TABLE note (
//    id           BIGINT       AUTO_INCREMENT,
//    notebook_id  BIGINT       NOT NULL,
//    name         VARCHAR(45)  NOT NULL,
//    text         VARCHAR      NOT NULL,
//
//    CONSTRAINT note_pk PRIMARY KEY (id),
//    CONSTRAINT note__notebook_id_fk FOREIGN KEY (notebook_id) REFERENCES notebook (id) ON DELETE CASCADE ON UPDATE CASCADE
//);
