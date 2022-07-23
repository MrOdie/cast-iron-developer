-- https://www.geeksforgeeks.org/postgresql-create-table/?ref=lbp
CREATE TABLE "user"
(
    user_id serial PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(50) NOT NULL ,
    email VARCHAR(50) UNIQUE NOT NULL,
    created_on TIMESTAMP NOT NULL,
    last_login TIMESTAMP NOT NULL
);

INSERT INTO "user" (username, password, email, created_on, last_login) VALUES ('sodonn', '12345', 'test@gmail.com', CURRENT_TIMESTAMP, now());

CREATE TABLE "role"
(
    role_id serial PRIMARY KEY,
    role_name VARCHAR (250) UNIQUE NOT NULL
);

CREATE TABLE "user_role"
(
    user_id integer NOT NULL,
    role_id integer NOT NULL,
    grant_date TIMESTAMP WITHOUT TIME ZONE,
    PRIMARY KEY (user_id, role_id),
    CONSTRAINT user_role_role_id_fkey FOREIGN KEY (role_id)
        REFERENCES "role" (role_id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT user_role_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES "user" (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE "posts"
(
    post_id serial PRIMARY KEY,
    title VARCHAR(100) UNIQUE NOT NULL,
    description VARCHAR(350) NOT NULL,
    body TEXT NOT NULL,
    draft Boolean NOT NULL,
    created_date TIMESTAMP NOT NULL,
    published_date TIMESTAMP NOT NULL
);

CREATE TABLE "post_creator"
(
    user_id integer NOT NULL,
    post_id integer NOT NULL,
    PRIMARY KEY (user_id, post_id),
    CONSTRAINT post_creator_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES "user" (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT post_creator_post_id_fkey FOREIGN KEY (post_id)
        REFERENCES "posts" (post_id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
);

-- Queries:
ALTER TABLE "posts" ADD CONSTRAINT unique_title UNIQUE (title);



