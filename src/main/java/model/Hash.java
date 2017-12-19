package model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "user_hash")
public class Hash {

    private String hash;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}

//CREATE TABLE user_hash (
//    user_id      BIGINT       NOT NULL,
//    hash         VARCHAR(60)  NOT NULL,
//
//    CONSTRAINT user_hash__user_id_fk FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE ON UPDATE CASCADE
//);
