package model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "notebook")
public class Notebook {
    @Id
    @GeneratedValue
    @Column(name = "notebookId")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "notebookId")
    private Long notebookId;

    @Column(name = "userId")
    @ManyToOne
    @JoinColumn(name = "userId")
    private Long userId;
}