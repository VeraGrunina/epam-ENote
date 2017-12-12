package model;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue
    @Column(name = "tagId")
    private Long tagId;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "tag_note",
            joinColumns = { @JoinColumn(name = "tag_id") },
            inverseJoinColumns = { @JoinColumn(name = "note_id") }
    )
    Set<Note> notes = new HashSet<>();

    private String name;
}