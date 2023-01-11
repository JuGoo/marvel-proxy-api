drop table if exists favorites;
CREATE TABLE favorites
(
    id VARCHAR DEFAULT RANDOM_UUID() PRIMARY KEY,
    userid VARCHAR NOT NULL,
    hero VARCHAR NOT NULL
);