package model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "note")
public class Note {

    @Id
    @GeneratedValue
    @Column(name = "noteId")
    private Long noteId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "notebookId")
    private Long notebookId;

    private String name;


    @ManyToMany(mappedBy = "notes")
    private Set<Tag> tagSet = new HashSet<>();

}