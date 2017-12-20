package model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class User {

    @Id
    private Long id;

    private String name;

    private String login;

    private String password;

    @OneToMany(mappedBy = "user")
    private Set<Notebook> notebookSet = new HashSet<>();

    @OneToOne(mappedBy = "user")
    private Hash hash;
}

//CREATE TABLE user (
//    id           BIGINT       AUTO_INCREMENT,
//    name         VARCHAR(45)  NOT NULL,
//    login        VARCHAR(45)  NOT NULL,
//    password     VARCHAR(45)  NOT NULL,
//
//    CONSTRAINT user_pk PRIMARY KEY (id)
//);
