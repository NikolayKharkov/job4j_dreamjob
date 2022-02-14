CREATE TABLE posts (
        id SERIAL PRIMARY KEY,
        name TEXT,
        description TEXT,
        created DATE
);

CREATE TABLE candidates (
        id SERIAL PRIMARY KEY,
        name VARCHAR(255)
);

CREATE TABLE users (
        id SERIAL PRIMARY KEY,
        name VARCHAR(255),
        email VARCHAR(100) UNIQUE,
        password VARCHAR(100),
        created DATE default CURRENT_DATE
);

