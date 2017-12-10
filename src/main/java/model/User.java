package model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    @Column(name = "userId")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private Long userId;

    @Column(name = "userName")
    private String name;

    @Column(name = "email")
    private String email;

    private String password;
    private List<Notebook> notebookList = new ArrayList<>();



}
