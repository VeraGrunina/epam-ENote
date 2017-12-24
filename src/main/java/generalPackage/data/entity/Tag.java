package generalPackage.data.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Tag {

    @Id
    private Integer id;

    private String name;

    @JoinTable(
            name = "tag_note",
            joinColumns = {@JoinColumn(name = "tag_id")},
            inverseJoinColumns = {@JoinColumn(name = "note_id")}
    )
    @ManyToMany(cascade = {CascadeType.ALL})
    Set<Note> notes = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;
}

//CREATE TABLE tag (
//    id           INT          AUTO_INCREMENT,
//    user_id      INT          NOT NULL,
//    name         VARCHAR(45)  NOT NULL,
//
//    CONSTRAINT tag_pk PRIMARY KEY (id),
//    CONSTRAINT tag__user_id_fk FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE ON UPDATE CASCADE
//);
