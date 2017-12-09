package model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Tag {
    @Id
    @GeneratedValue
    private int tagId;

    private String name;
}
