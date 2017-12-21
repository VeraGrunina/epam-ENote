package generalPackage.config.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "notebook")
public class Notebook {

    @Id
    private Long id;

    private String name;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private Long userId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "notebook")
    private Set<Note> noteSet = new HashSet<>();

    public void addNote(Note note) {
        noteSet.add(note);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Note> getNoteSet() {
        return noteSet;
    }

    public void setNoteSet(Set<Note> noteSet) {
        this.noteSet = noteSet;
    }
}

//CREATE TABLE notebook (
//    id           BIGINT       AUTO_INCREMENT,
//    name         VARCHAR(45)  NOT NULL,
//    user_id      BIGINT       NOT NULL,
//
//    CONSTRAINT notebook_pk PRIMARY KEY (id),
//    CONSTRAINT notebook__user_id_fk FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE ON UPDATE CASCADE
//);
