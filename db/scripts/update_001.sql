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
