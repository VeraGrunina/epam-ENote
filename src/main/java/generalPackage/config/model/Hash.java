package generalPackage.config.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "user_hash")
public class Hash {

    private String hash;

    @java.beans.ConstructorProperties({"hash", "user"})
    public Hash(String hash, User user) {
        this.hash = hash;
        this.user = user;
    }

    public Hash() {
    }

    public static HashBuilder builder() {
        return new HashBuilder();
    }

    public String getHash() {
        return hash;
    }

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public static class HashBuilder {

        private String hash;
        private User user;

        HashBuilder() {
        }

        public HashBuilder hash(String hash) {
            this.hash = hash;
            return this;
        }

        public HashBuilder user(User user) {
            this.user = user;
            return this;
        }

        public Hash build() {
            return new Hash(hash, user);
        }

        public String toString() {
            return "Hash.HashBuilder(hash=" + this.hash + ", user=" + this.user + ")";
        }
    }
}

//CREATE TABLE user_hash (
//    user_id      BIGINT       NOT NULL,
//    hash         VARCHAR(60)  NOT NULL,
//
//    CONSTRAINT user_hash__user_id_fk FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE ON UPDATE CASCADE
//);
