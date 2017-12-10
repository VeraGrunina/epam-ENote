package model;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Tag {
    @Id
    @GeneratedValue
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "noteId")
    private Long tagId;

    private String name;
}
