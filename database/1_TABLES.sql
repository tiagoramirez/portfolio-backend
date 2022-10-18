CREATE TABLE `user`(
    id INT NOT NULL,
    username VARCHAR(15) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    full_name VARCHAR(50) NOT NULL,
    birthday DATE NOT NULL,
    mail VARCHAR(100) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);
CREATE TABLE `role`(
    id INT NOT NULL,
    role_name VARCHAR(50) NOT NULL,
    PRIMARY KEY(id)
);
CREATE TABLE `skill` (
    id INT NOT NULL,
    name VARCHAR(50) NOT NULL,
    type VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE `social_media` (
    id INT NOT NULL,
    name VARCHAR(20) NOT NULL,
    icon_class VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE `user_roles`(
    user_id INT NOT NULL,
    role_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (role_id) REFERENCES role(id)
);
CREATE TABLE `photo`(
    id INT NOT NULL,
    id_user INT NOT NULL UNIQUE,
    photo LONGBLOB NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_user) REFERENCES user(id)
);
CREATE TABLE `banner`(
    id INT NOT NULL,
    id_user INT NOT NULL UNIQUE,
    banner LONGBLOB NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_user) REFERENCES user(id)
);
CREATE TABLE `user_social_media`(
    id INT NOT NULL,
    id_user INT NOT NULL,
    id_social_media INT NOT NULL,
    link VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_user) REFERENCES user(id),
    FOREIGN KEY (id_social_media) REFERENCES social_media(id)
);
CREATE TABLE `user_skills`(
    id INT NOT NULL,
    id_user INT NOT NULL,
    id_skill INT NOT NULL,
    percentage INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY(id_user) REFERENCES user(id),
    FOREIGN KEY(id_skill) REFERENCES skill(id)
);
CREATE TABLE `profile`(
    id INT NOT NULL,
    id_user INT NOT NULL,
    description VARCHAR(100) NOT NULL,
    phone VARCHAR(16) NULL,
    location_state VARCHAR(50) NULL,
    location_country VARCHAR(50) NULL,
    PRIMARY KEY (id),
    FOREIGN KEY(id_user) REFERENCES user(id)
);
CREATE TABLE `about_me` (
    id INT NOT NULL,
    id_profile INT NOT NULL UNIQUE,
    about_me VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_profile) REFERENCES profile(id)
);
CREATE TABLE `configuration` (
    id INT NOT NULL,
    id_profile INT NOT NULL UNIQUE,
    show_photo BOOLEAN NOT NULL,
    show_banner BOOLEAN NOT NULL,
    show_location BOOLEAN NOT NULL,
    show_phone BOOLEAN NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_profile) REFERENCES profile(id)
);
CREATE TABLE `project` (
    id INT NOT NULL,
    id_user INT NOT NULL,
    name VARCHAR(50) NOT NULL,
    link VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY(id_user) REFERENCES user(id)
);
CREATE TABLE `experience`(
    id INT NOT NULL,
    id_user INT NOT NULL,
    position VARCHAR(100) NOT NULL,
    type VARCHAR(20) NOT NULL,
    company_name VARCHAR(50) NOT NULL,
    location varchar(100) NULL,
    is_actual BOOLEAN NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NULL,
    PRIMARY KEY (id),
    FOREIGN KEY(id_user) REFERENCES user(id)
);
CREATE TABLE `education` (
    id INT NOT NULL,
    id_user INT NOT NULL,
    type VARCHAR(20) NOT NULL,
    institute_name VARCHAR(50) NOT NULL,
    title_name VARCHAR(50) NOT NULL,
    is_actual BOOLEAN NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NULL,
    PRIMARY KEY (id),
    FOREIGN KEY(id_user) REFERENCES user(id)
);
CREATE TABLE `description`(
    id INT NOT NULL,
    id_profile INT NOT NULL,
    id_project INT NULL,
    id_education INT NULL,
    id_experience INT NULL,
    description VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_profile) REFERENCES profile(id),
    FOREIGN KEY (id_project) REFERENCES project(id),
    FOREIGN KEY (id_education) REFERENCES education(id),
    FOREIGN KEY (id_experience) REFERENCES experience(id)
);
CREATE TABLE `hibernate_sequence`(next_val BIGINT);
INSERT INTO `hibernate_sequence` (next_val)
VALUES (26);