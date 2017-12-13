package model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "notebook")
public class Notebook {

    @Id
//    @GeneratedValue
//    @Column(name = "id")
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id")
    private Long id;

    private String name;

//    @Column(name = "user_id")
//    @ManyToOne
//    @JoinColumn(name = "user_id")

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;


    @OneToMany(mappedBy = "notebook")
    private Set<Note> noteSet = new HashSet<>();
}



//CREATE TABLE notebook (
//    id           BIGINT       AUTO_INCREMENT,
//    name         VARCHAR(45)  NOT NULL,
//    user_id      BIGINT       NOT NULL,
//
//    CONSTRAINT notebook_pk PRIMARY KEY (id),
//    CONSTRAINT notebook__user_id_fk FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE ON UPDATE CASCADE
//);
