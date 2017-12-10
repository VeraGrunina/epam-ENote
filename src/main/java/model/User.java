package model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    @NonNull
    private Long id;

    @Column(name = "userName")
    @NonNull
    private String name;

    @Column(name = "email")
    @NonNull
    private String email;

    @NonNull
    private String password;

    private List<Notebook> notebookList = new ArrayList<>();
}
