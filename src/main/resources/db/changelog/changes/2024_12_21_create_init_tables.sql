CREATE TABLE items(
    id SERIAL PRIMARY KEY,
    name varchar,
    description varchar,
    create_at timestamp,
    update_at timestamp
);