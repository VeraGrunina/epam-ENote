package model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Note {

    @Id
    @GeneratedValue
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tagId")
    private Long noteId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "notebookId")
    private Long notebookId;

    private String name;

}
