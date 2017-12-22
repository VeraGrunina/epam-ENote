package generalPackage.data.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Notebook {

    @Id
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    @OneToMany(mappedBy = "notebook")
    private Set<Note> notes = new HashSet<>();
}

//CREATE TABLE notebook (
//    id           BIGINT       AUTO_INCREMENT,
//    name         VARCHAR(45)  NOT NULL,
//    user_id      BIGINT       NOT NULL,
//
//    CONSTRAINT notebook_pk PRIMARY KEY (id),
//    CONSTRAINT notebook__user_id_fk FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE ON UPDATE CASCADE
//);
