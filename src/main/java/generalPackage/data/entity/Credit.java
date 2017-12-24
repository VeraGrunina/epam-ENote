package generalPackage.data.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@Entity
public class Credit {

    private String hash;

    @OneToOne
    @JoinColumn(name = "user_id")
    User user;
}

//CREATE TABLE hash (
//    user_id      INT          NOT NULL,
//    hash         VARCHAR(60)  NOT NULL,
//
//    CONSTRAINT credit__user_id_fk FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE ON UPDATE CASCADE
//);
