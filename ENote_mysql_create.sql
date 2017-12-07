CREATE TABLE `User` (
	`user_id` INT NOT NULL AUTO_INCREMENT,
	`user_name` VARCHAR(255) NOT NULL UNIQUE,
	`user_email` VARCHAR(255) NOT NULL UNIQUE,
	`user_password` VARCHAR(255) NOT NULL UNIQUE,
	PRIMARY KEY (`user_id`)
);

CREATE TABLE `Note` (
	`note_id` INT NOT NULL AUTO_INCREMENT,
	`notebook_id` INT NOT NULL,
	`note_name` VARCHAR(255) NOT NULL,
	PRIMARY KEY (`note_id`)
);

CREATE TABLE `Notebook` (
	`notebook_id` INT NOT NULL AUTO_INCREMENT,
	`user_id` INT NOT NULL,
	`notebook_name` VARCHAR(255) NOT NULL,
	PRIMARY KEY (`notebook_id`)
);

CREATE TABLE `Tag` (
	`tag_id` INT NOT NULL AUTO_INCREMENT,
	`tag_name` VARCHAR(255) NOT NULL,
	PRIMARY KEY (`tag_id`)
);

CREATE TABLE `TagWithNote` (
	`note_id` INT NOT NULL,
	`tag_id` INT NOT NULL
);

ALTER TABLE `Note` ADD CONSTRAINT `Note_fk0` FOREIGN KEY (`notebook_id`) REFERENCES `Notebook`(`notebook_id`);

ALTER TABLE `Notebook` ADD CONSTRAINT `Notebook_fk0` FOREIGN KEY (`user_id`) REFERENCES `User`(`user_id`);

ALTER TABLE `TagWithNote` ADD CONSTRAINT `TagWithNote_fk0` FOREIGN KEY (`note_id`) REFERENCES `Note`(`note_id`);

ALTER TABLE `TagWithNote` ADD CONSTRAINT `TagWithNote_fk1` FOREIGN KEY (`tag_id`) REFERENCES `Tag`(`tag_id`);

