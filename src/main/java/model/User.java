package model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class User {

    @Id
    private Long id;

//  @java.beans.ConstructorProperties({"id", "name", "login", "notebookSet", "hash", "tags"})
  User(Long id, String name, String login, Set<Notebook> notebookSet, Hash hash,
      Set<Tag> tags) {
    this.id = id;
    this.name = name;
    this.login = login;
    this.notebookSet = notebookSet;
    this.hash = hash;
    this.tags = tags;
  }

  public User() {
  }

  public static UserBuilder builder() {
    return new UserBuilder();
  }

  public Long getId() {
    return id;
  }

  private String name;

    private String login;

//    private String password;

    @OneToMany(mappedBy = "user")
    private Set<Notebook> notebookSet = new HashSet<>();

    @OneToOne(mappedBy = "user")
    private Hash hash;

    @OneToMany(mappedBy = "user")
    private Set<Tag> tags = new HashSet<>();

    public void addNotebook(Notebook notebook) {
        notebookSet.add(notebook);
    }

    public void addTag(Tag tag) {
        tags.add(tag);
    }

  public Set<Tag> getTags() {
    return tags;
  }

  public Set<Notebook> getNotebookSet() {
    return notebookSet;
  }

  public static class UserBuilder {

    private Long id;
    private String name;
    private String login;
    private Set<Notebook> notebookSet;
    private Hash hash;
    private Set<Tag> tags;

    UserBuilder() {
    }

    public UserBuilder id(Long id) {
      this.id = id;
      return this;
    }

    public UserBuilder name(String name) {
      this.name = name;
      return this;
    }

    public UserBuilder login(String login) {
      this.login = login;
      return this;
    }

    public UserBuilder notebookSet(Set<Notebook> notebookSet) {
      this.notebookSet = notebookSet;
      return this;
    }

    public UserBuilder hash(Hash hash) {
      this.hash = hash;
      return this;
    }

    public UserBuilder tags(Set<Tag> tags) {
      this.tags = tags;
      return this;
    }

    public User build() {
      return new User(id, name, login, notebookSet, hash, tags);
    }

    public String toString() {
      return "User.UserBuilder(id=" + this.id + ", name=" + this.name + ", login=" + this.login
          + ", notebookSet=" + this.notebookSet + ", hash=" + this.hash + ", tags=" + this.tags
          + ")";
    }
  }
}

//CREATE TABLE user (
//    id           BIGINT       AUTO_INCREMENT,
//    name         VARCHAR(45)  NOT NULL,
//    login        VARCHAR(45)  NOT NULL,
//    password     VARCHAR(45)  NOT NULL,
//
//    CONSTRAINT user_pk PRIMARY KEY (id)
//);
