package model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "user")
public class User {

    @Id
//    @GeneratedValue
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    private int id;

    @Column(name = "name", nullable = false, insertable = true, updatable = true)
    private String name;

    @Column(name = "email", nullable = false, insertable = true, updatable = true)
    private String email;

    @Column(name = "password", nullable = false, insertable = true, updatable = true)
    private String password;

    private List<Notebook> notebookList = new ArrayList<>();
}
