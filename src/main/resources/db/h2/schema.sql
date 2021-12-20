DROP TABLE FEATURE IF EXISTS;
DROP TABLE USER_GROUP IF EXISTS;
DROP TABLE USER_FEATURE IF EXISTS;

CREATE TABLE FEATURE (
    id   INTEGER IDENTITY PRIMARY KEY    NOT NULL,
    name VARCHAR(128) UNIQUE             NOT NULL,
    enabled BOOLEAN                      NOT NULL
);

CREATE TABLE USER_GROUP (
    id   INTEGER IDENTITY PRIMARY KEY    NOT NULL ,
    first_name VARCHAR(128)               NOT NULL,
    last_name VARCHAR(128)                NOT NULL
);

ALTER TABLE USER_GROUP ADD CONSTRAINT UNIQUE_USER_GROUP UNIQUE(first_name, last_name);

CREATE TABLE USER_FEATURE (
    user_id INTEGER  NOT NULL,
    feature_id INTEGER NOT NULL,
    FOREIGN KEY (user_id) REFERENCES USER_GROUP(id),
    FOREIGN KEY (feature_id) REFERENCES FEATURE(id),
    PRIMARY KEY (user_id, feature_id)
);

