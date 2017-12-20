CREATE TABLE user (
  id           BIGINT       AUTO_INCREMENT,
  name         VARCHAR(45)  NOT NULL,
  login        VARCHAR(45)  NOT NULL,
--   password     VARCHAR(45)  NOT NULL,

  CONSTRAINT user_pk PRIMARY KEY (id),
  CONSTRAINT user__login_unq UNIQUE (login)
);

CREATE TABLE notebook (
  id           BIGINT       AUTO_INCREMENT,
  name         VARCHAR(45)  NOT NULL,
  user_id      BIGINT       NOT NULL,

  CONSTRAINT notebook_pk PRIMARY KEY (id),
  CONSTRAINT notebook__user_id_fk FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE note (
  id           BIGINT       AUTO_INCREMENT,
  notebook_id  BIGINT       NOT NULL,
  name         VARCHAR(45)  NOT NULL,
  text         VARCHAR      NOT NULL,

  CONSTRAINT note_pk PRIMARY KEY (id),
  CONSTRAINT note__notebook_id_fk FOREIGN KEY (notebook_id) REFERENCES notebook (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE tag (
  id           BIGINT       AUTO_INCREMENT,
  name         VARCHAR(45)  NOT NULL,

  CONSTRAINT tag_pk PRIMARY KEY (id)
);

CREATE TABLE tag_note (
  note_id      BIGINT       NOT NULL,
  tag_id       BIGINT       NOT NULL,

  CONSTRAINT tag_note__note_id_tag_id_unq UNIQUE (note_id, tag_id),
  CONSTRAINT tag_note__tag_id_fk FOREIGN KEY (tag_id) REFERENCES tag (id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT tag_note__note_id_fk FOREIGN KEY (note_id) REFERENCES note (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE user_hash (
  user_id      BIGINT       NOT NULL,
  hash         VARCHAR(60)  NOT NULL,

  CONSTRAINT user_hash__user_id_fk FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE ON UPDATE CASCADE
);
