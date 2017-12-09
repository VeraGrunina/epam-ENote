package model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    private int userId;
    private String name;
    private String email;
    private String password;
    private List<Notebook> notebookList = new ArrayList<>();



}
