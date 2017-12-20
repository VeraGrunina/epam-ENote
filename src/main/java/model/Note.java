package model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "note")
public class Note {

    @Id
    private Long id;
    private String name;
    private String text;

    @ManyToOne
    @JoinColumn(name = "notebook_id", nullable = false)
    private Notebook notebook;

    @ManyToMany(mappedBy = "notes")
    private Set<Tag> tags = new HashSet<>();
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
