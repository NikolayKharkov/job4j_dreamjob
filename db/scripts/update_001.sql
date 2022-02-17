CREATE TABLE posts (
        id SERIAL PRIMARY KEY,
        name TEXT,
        description TEXT,
        created DATE
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

CREATE TABLE cities (
        id SERIAL PRIMARY KEY,
        name VARCHAR(255) UNIQUE
);

insert into cities(name) values('Москва');
insert into cities(name) values('Санкт-Петербург');
insert into cities(name) values('Казань');
insert into cities(name) values('Владивосток');
insert into cities(name) values('Калининград');
insert into cities(name) values('Сочи');
