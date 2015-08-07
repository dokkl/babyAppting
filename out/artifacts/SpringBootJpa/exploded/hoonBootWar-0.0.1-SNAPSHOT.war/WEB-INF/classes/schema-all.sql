DROP TABLE people;

CREATE TABLE people  (
    person_id BIGINT NOT NULL auto_increment,
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    PRIMARY KEY (person_id)
);
