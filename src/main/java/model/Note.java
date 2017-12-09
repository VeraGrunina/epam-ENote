package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Note {

    @Id
    @GeneratedValue
    private int noteId;
    private String name;

}
