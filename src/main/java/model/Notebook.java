package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Notebook {
    @Id
    @GeneratedValue
    private int notebookId;
    private List<Note> noteList = new ArrayList<>();
}
