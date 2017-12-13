package model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
//@RequiredArgsConstructor
@NoArgsConstructor
//@Table(name = "user")
public class User {

    // GenerationType.IDENTITY - означает AutoIncrement

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id")
//    @NonNull
    private Long id;

//    @Column(name = "userName")
//    @NonNull
    private String name;

//    @Column(name = "login")
//    @NonNull
    private String login;

//    @NonNull
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<Notebook> notebookSet = new HashSet<>();
}


//CREATE TABLE user (
//    id           BIGINT       AUTO_INCREMENT,
//    name         VARCHAR(45)  NOT NULL,
//    login        VARCHAR(45)  NOT NULL,
//    password     VARCHAR(45)  NOT NULL,
//
//    CONSTRAINT user_pk PRIMARY KEY (id)
//);
