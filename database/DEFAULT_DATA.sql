INSERT INTO `user` (
        id,
        username,
        password,
        full_name,
        birthday,
        mail
    )
VALUES (
        1,
        'tiagoramirez',
        '$2a$10$98zLjjDto9aXPtDd9zrD9exJl1wBeS41sYGn9oulbFyQWk7//rQ3y',
        'Tiago Ramirez',
        '2001-09-04',
        'tiagoramirez2001@gmail.com'
    );
INSERT INTO `user_roles` (
        user_id,
        role_id
    )
VALUES (
        1,
        2
    );
INSERT INTO `profile` (
        id,
        id_user,
        description,
        phone,
        location_state,
        location_country
    )
VALUES (
        2,
        1,
        'FullStack Developer',
        NULL,
        'Capital Federal',
        'Argentina'
    );
INSERT INTO `configuration` (
        id,
        id_profile,
        show_photo,
        show_banner,
        show_location,
        show_phone
    )
VALUES (
        3,
        2,
        0,
        0,
        1,
        0
    );
INSERT INTO `about_me` (id, id_profile, about_me)
VALUES (
        4,
        2,
        'Estudiante Ingeniería en Sistemas de Información en UTN. Mis conocimientos principales son GIT, SQL SERVER, MYSQL, HTML, CSS, JS, TS, ANGULAR, JAVA SPRING'
    );
INSERT INTO `user_social_media` (id, id_user, id_social_media, link)
VALUES (
        5,
        1,
        2,
        'http://www.github.com/tiagoramirez'
    );
INSERT INTO `user_social_media` (id, id_user, id_social_media, link)
VALUES (
        15,
        1,
        4,
        'https://www.linkedin.com/in/tiagoramirezmar/'
    );
INSERT INTO `experience` (
        id,
        id_user,
        position,
        type,
        company_name,
        location,
        is_actual,
        start_date,
        end_date
    )
VALUES (
        6,
        1,
        'Analista Programador',
        'Full-Time',
        'Accusys',
        'Capital Federal, Argentina',
        1,
        '2022-04-05',
        NULL
    );
INSERT INTO `description` (
        id,
        id_profile,
        id_project,
        id_education,
        id_experience,
        description
    )
VALUES (
        7,
        2,
        NULL,
        NULL,
        6,
        'Trabajo como Analista Programador Junior. Tecnologias: SQL SERVER, Java, Classic ASP, SCRUM'
    );
INSERT INTO `education` (
        id,
        id_user,
        type,
        institute_name,
        title_name,
        is_actual,
        start_date,
        end_date
    )
VALUES (
        8,
        1,
        'Universitario',
        'Universidad Tecnologica Nacional',
        'Ingenieria en Sistemas de Informacion',
        1,
        '2020-04-01',
        NULL
    );
INSERT INTO `description` (
        id,
        id_profile,
        id_project,
        id_education,
        id_experience,
        description
    )
VALUES (
        9,
        2,
        NULL,
        8,
        NULL,
        'Actualmente me encuentro haciendo 2do anio de la carrera con un promedio de 9'
    );
INSERT INTO `project` (id, id_user, name, link)
VALUES (
        10,
        1,
        'Portfolio',
        'No disponible actualmente'
    );
INSERT INTO `description` (
        id,
        id_profile,
        id_project,
        id_education,
        id_experience,
        description
    )
VALUES (
        11,
        2,
        10,
        NULL,
        NULL,
        'Portfolio personal hecho con HTML, CSS, TypeScript, Angular, MySql, Java'
    );
INSERT INTO `user_skills` (id, id_user, id_skill, percentage)
VALUES (12, 1, 1, 80);
INSERT INTO `user_skills` (id, id_user, id_skill, percentage)
VALUES (13, 1, 2, 70);
INSERT INTO `user_skills` (id, id_user, id_skill, percentage)
VALUES (14, 1, 3, 85);
INSERT INTO `user_skills` (id, id_user, id_skill, percentage)
VALUES (16, 1, 7, 75);
INSERT INTO `user_skills` (id, id_user, id_skill, percentage)
VALUES (17, 1, 8, 80);
INSERT INTO `user_skills` (id, id_user, id_skill, percentage)
VALUES (18, 1, 9, 85);
INSERT INTO `user_skills` (id, id_user, id_skill, percentage)
VALUES (19, 1, 11, 95);
INSERT INTO `user_skills` (id, id_user, id_skill, percentage)
VALUES (20, 1, 12, 80);
INSERT INTO `user_skills` (id, id_user, id_skill, percentage)
VALUES (21, 1, 13, 90);
INSERT INTO `user_skills` (id, id_user, id_skill, percentage)
VALUES (22, 1, 14, 90);
INSERT INTO `user_skills` (id, id_user, id_skill, percentage)
VALUES (23, 1, 15, 90);
INSERT INTO `user_skills` (id, id_user, id_skill, percentage)
VALUES (24, 1, 18, 90);
INSERT INTO `user_skills` (id, id_user, id_skill, percentage)
VALUES (25, 1, 19, 95);