package generalPackage.data.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class User {

    @Id
    private Long id;

    private String name;

    private String login;

    @OneToMany(mappedBy = "user")
    private Set<Notebook> notebooks = new HashSet<>();

    @OneToOne(mappedBy = "user")
    Hash hash;

    @OneToMany(mappedBy = "user")
    private Set<Tag> tags = new HashSet<>();
}

//CREATE TABLE user (
//    id           BIGINT       AUTO_INCREMENT,
//    name         VARCHAR(45)  NOT NULL,
//    login        VARCHAR(45)  NOT NULL,
//    password     VARCHAR(45)  NOT NULL,
//
//    CONSTRAINT user_pk PRIMARY KEY (id)
//);
