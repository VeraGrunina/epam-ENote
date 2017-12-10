package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    @Column(name = "userId")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private Long userId;

    @Column(name = "userName")
    private String name;

    @Column(name = "login")
    private String login;

    private String password;
    private List<Notebook> notebookList = new ArrayList<>();

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Notebook> getNotebookList() {
        return notebookList;
    }

    public void setNotebookList(List<Notebook> notebookList) {
        this.notebookList = notebookList;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
