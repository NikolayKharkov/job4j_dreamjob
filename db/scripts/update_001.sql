CREATE TABLE posts (
        id SERIAL PRIMARY KEY,
        name TEXT,
        description TEXT,
        created DATE
);

CREATE TABLE cities (
        id SERIAL PRIMARY KEY,
        name VARCHAR(255) UNIQUE
);

CREATE TABLE candidates (
        id SERIAL PRIMARY KEY,
        name VARCHAR(255),
        city_id INTEGER REFERENCES cities (Id),
        created DATE default CURRENT_DATE
);

CREATE TABLE users (
        id SERIAL PRIMARY KEY,
        name VARCHAR(255),
        email VARCHAR(100) UNIQUE,
        password VARCHAR(100),
        created DATE default CURRENT_DATE
);

INSERT INTO cities(name) VALUES('Москва');
INSERT INTO cities(name) VALUES('Санкт-Петербург');
INSERT INTO cities(name) VALUES('Казань');
INSERT INTO cities(name) VALUES('Владивосток');
INSERT INTO cities(name) VALUES('Калининград');
INSERT INTO cities(name) VALUES('Сочи');
