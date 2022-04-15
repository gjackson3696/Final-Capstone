BEGIN TRANSACTION;

DROP TABLE IF EXISTS class_members;
DROP TABLE IF EXISTS profile;
DROP TABLE IF EXISTS goals;
DROP TABLE IF EXISTS workouts;
DROP TABLE IF EXISTS logged_workouts;
DROP TABLE IF EXISTS members;
DROP TABLE IF EXISTS classes;
DROP TABLE IF EXISTS users;

DROP SEQUENCE IF EXISTS seq_user_id;
DROP SEQUENCE IF EXISTS seq_member_id;
DROP SEQUENCE IF EXISTS seq_class_id;
DROP SEQUENCE IF EXISTS seq_profile_id;
DROP SEQUENCE IF EXISTS seq_goals_id;
DROP SEQUENCE IF EXISTS seq_workout_id;
DROP SEQUENCE IF EXISTS seq_logged_workout_id;

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

CREATE SEQUENCE seq_profile_id
  INCREMENT BY 1
  START WITH 3001
  NO MAXVALUE
  CACHE 1;

CREATE SEQUENCE seq_goals_id
  INCREMENT BY 1
  START WITH 4001
  NO MAXVALUE
  CACHE 1;

CREATE SEQUENCE seq_workout_id
  INCREMENT BY 1
  START WITH 5001
  NO MAXVALUE
  CACHE 1;

CREATE SEQUENCE seq_logged_workout_id
  INCREMENT BY 1
  START WITH 6001
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
	CONSTRAINT FK_member_user_id FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE profile (
	profile_id int DEFAULT nextval('seq_profile_id'::regclass) NOT NULL,
	member_id int NOT NULL,
	back_squat varchar(15) NOT NULL,
	front_squat varchar(15) NOT NULL,
	zercher_squat varchar(15) NOT NULL,
	overhead_squat varchar(15) NOT NULL,
	bulgarian_split_squat varchar(15) NOT NULL,
	conventional_deadlift varchar(15) NOT NULL,
	sumo_deadlift varchar(15) NOT NULL,
	overhead_press varchar(15) NOT NULL,
	military_press varchar(15) NOT NULL,
	push_press varchar(15) NOT NULL,
	squat_clean varchar(15) NOT NULL,
	power_clean varchar(15) NOT NULL,
	split_jerk varchar(15) NOT NULL,
	push_jerk varchar(15) NOT NULL,
	squat_jerk varchar(15) NOT NULL,
	squat_snatch varchar(15) NOT NULL,
	power_snatch varchar(15) NOT NULL,
	snatch_balance varchar(15) NOT NULL,
	CONSTRAINT PK_profile PRIMARY KEY (profile_id),
	CONSTRAINT FK_profile_member_id FOREIGN KEY (member_id) REFERENCES members (member_id)
);

CREATE TABLE goals (
	goals_id int DEFAULT nextval('seq_goals_id'::regclass) NOT NULL,
	member_id int NOT NULL,
	back_squat varchar(15) NOT NULL,
	front_squat varchar(15) NOT NULL,
	zercher_squat varchar(15) NOT NULL,
	overhead_squat varchar(15) NOT NULL,
	bulgarian_split_squat varchar(15) NOT NULL,
	conventional_deadlift varchar(15) NOT NULL,
	sumo_deadlift varchar(15) NOT NULL,
	overhead_press varchar(15) NOT NULL,
	military_press varchar(15) NOT NULL,
	push_press varchar(15) NOT NULL,
	squat_clean varchar(15) NOT NULL,
	power_clean varchar(15) NOT NULL,
	split_jerk varchar(15) NOT NULL,
	push_jerk varchar(15) NOT NULL,
	squat_jerk varchar(15) NOT NULL,
	squat_snatch varchar(15) NOT NULL,
	power_snatch varchar(15) NOT NULL,
	snatch_balance varchar(15) NOT NULL,
	CONSTRAINT PK_goals PRIMARY KEY (goals_id),
	CONSTRAINT FK_goals_member_id FOREIGN KEY (member_id) REFERENCES members (member_id)
);

CREATE TABLE workouts (
	workout_id int DEFAULT nextval('seq_workout_id'::regclass) NOT NULL,
	member_id int NOT NULL,
	name varchar(50) NOT NULL,
	domain varchar(50) NOT NULL,
	structure varchar(200) NOT NULL,
	weights varchar(50),
	workoutTime varchar(25),
	rounds varchar(10),
	completed boolean DEFAULT false,
	CONSTRAINT PK_workouts PRIMARY KEY (workout_id),
	CONSTRAINT FK_workouts_member_id FOREIGN KEY (member_id) REFERENCES members (member_id)
);

CREATE TABLE logged_workouts (
	logged_workout_id int DEFAULT nextval('seq_logged_workout_id'::regclass) NOT NULL,
	member_id int NOT NULL,
	name varchar(50) NOT NULL,
	domain varchar(50) NOT NULL,
	structure varchar(200) NOT NULL,
	weights varchar(50),
	workoutTime varchar(25),
	rounds varchar(10),
	completed boolean DEFAULT true,
	CONSTRAINT PK_logged_workouts PRIMARY KEY (logged_workout_id),
	CONSTRAINT FK_logged_workouts_member_id FOREIGN KEY (member_id) REFERENCES members (member_id)
);


CREATE TABLE classes (
	class_id int DEFAULT nextval('seq_class_id'::regclass) NOT NULL,
	class_name varchar(50) NOT NULL,
	instructor_name varchar(50) NOT NULL,
	start_date date NOT NULL,
	start_time time NOT NULL,
	length_minutes int NOT NULL,
	CONSTRAINT PK_class PRIMARY KEY (class_id)
);

CREATE TABLE class_members (
	class_id int NOT NULL,
	member_id int NOT NULL,
	CONSTRAINT PK_class_members PRIMARY KEY (class_id,member_id),
	CONSTRAINT FK_class_mambers_class_id FOREIGN KEY (class_id) REFERENCES classes (class_id),
	CONSTRAINT FK_class_members_member_id FOREIGN KEY (member_id) REFERENCES members (member_id)
);

------------------------------------------------------------------------------------------------------------

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO classes (class_name,instructor_name,start_date,start_time,length_minutes) VALUES ('High Intensity','Gary','2022-04-24','14:00:00',60);
INSERT INTO classes (class_name,instructor_name,start_date,start_time,length_minutes) VALUES ('Yoga','Alex','2022-04-26','08:00:00',60);
INSERT INTO classes (class_name,instructor_name,start_date,start_time,length_minutes) VALUES ('The Power Building','Semir','2022-04-28','17:00:00',90);
INSERT INTO classes (class_name,instructor_name,start_date,start_time,length_minutes) VALUES ('Show Me How To Run','Luke','2022-04-22','16:00:00',90);
INSERT INTO classes (class_name,instructor_name,start_date,start_time,length_minutes) VALUES ('Coding Core Workout','Matt','2022-04-23','14:00:00',60);
INSERT INTO classes (class_name,instructor_name,start_date,start_time,length_minutes) VALUES ('Sweat Day','Steve','2022-04-24','12:00:00',120);
INSERT INTO classes (class_name,instructor_name,start_date,start_time,length_minutes) VALUES ('Curls and Crunches','Matt','2022-04-25','13:00:00',120);
INSERT INTO classes (class_name,instructor_name,start_date,start_time,length_minutes) VALUES ('Flabs To Abs','Semir','2022-04-26','14:00:00',120);
INSERT INTO classes (class_name,instructor_name,start_date,start_time,length_minutes) VALUES ('Classic Chest Day','Gary','2022-04-27','15:00:00',120);
INSERT INTO classes (class_name,instructor_name,start_date,start_time,length_minutes) VALUES ('Cardio Lovers','Luke','2022-04-28','16:00:00',120);
INSERT INTO classes (class_name,instructor_name,start_date,start_time,length_minutes) VALUES ('Back Building','Alex','2022-04-29','12:00:00',120);
INSERT INTO classes (class_name,instructor_name,start_date,start_time,length_minutes) VALUES ('Aggresive Arm Training','Luke','2022-04-30','13:00:00',120);
INSERT INTO classes (class_name,instructor_name,start_date,start_time,length_minutes) VALUES ('Yoga','Semir','2022-05-01','14:00:00',120);
INSERT INTO classes (class_name,instructor_name,start_date,start_time,length_minutes) VALUES ('High Intensity','Steve','2022-05-02','15:00:00',120);
INSERT INTO classes (class_name,instructor_name,start_date,start_time,length_minutes) VALUES ('Conditioning','Alex','2022-05-03','16:00:00',120);
INSERT INTO classes (class_name,instructor_name,start_date,start_time,length_minutes) VALUES ('Full Body Training','Gary','2022-05-04','12:00:00',120);
INSERT INTO classes (class_name,instructor_name,start_date,start_time,length_minutes) VALUES ('Push Day','Matt','2022-05-05','13:00:00',120);
INSERT INTO classes (class_name,instructor_name,start_date,start_time,length_minutes) VALUES ('Pull Day','Gary','2022-05-06','14:00:00',120);
INSERT INTO classes (class_name,instructor_name,start_date,start_time,length_minutes) VALUES ('Lightning Leg Building','Luke','2022-05-07','15:00:00',120);

INSERT INTO members (user_id,first_name,last_name,email) VALUES (2,'Gary','Jackson','gjacksondev@gmail.com');


COMMIT TRANSACTION;
