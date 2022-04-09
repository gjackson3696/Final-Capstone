BEGIN TRANSACTION;

DROP TABLE IF EXISTS class_members;
DROP TABLE IF EXISTS members;
DROP TABLE IF EXISTS classes;
DROP TABLE IF EXISTS users;

DROP SEQUENCE IF EXISTS seq_user_id;
DROP SEQUENCE IF EXISTS seq_member_id;
DROP SEQUENCE IF EXISTS seq_class_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE SEQUENCE seq_member_id
  INCREMENT BY 1
  START WITH 1001
  NO MAXVALUE
  CACHE 1;

CREATE SEQUENCE seq_class_id
  INCREMENT BY 1
  START WITH 2001
  NO MAXVALUE
  CACHE 1;
------------------------------------------------------------------------------------------------------------
CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE members (
	member_id int DEFAULT nextval('seq_member_id'::regclass) NOT NULL,
	user_id int NOT NULL,
	first_name varchar(25) NOT NULL,
	last_name varchar(25) NOT NULL,
	email varchar(100) NOT NULL,
	CONSTRAINT PK_member PRIMARY KEY (member_id),
	CONSTRAINT FK_member_user FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE classes (
	class_id int DEFAULT nextval('seq_class_id'::regclass) NOT NULL,
	name varchar(50) NOT NULL,
	instructor_name varchar(50) NOT NULL,
	start_time timestamp NOT NULL,
	length_minutes int NOT NULL,
	CONSTRAINT PK_class PRIMARY KEY (class_id)
);

CREATE TABLE class_members (
	class_id int NOT NULL,
	member_id int NOT NULL,
	CONSTRAINT FK_class_mambers_class_id FOREIGN KEY (class_id) REFERENCES classes (class_id),
	CONSTRAINT FK_class_members_member_id FOREIGN KEY (member_id) REFERENCES members (member_id)
);
------------------------------------------------------------------------------------------------------------
INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


COMMIT TRANSACTION;
