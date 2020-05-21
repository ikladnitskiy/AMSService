DROP TABLE IF EXISTS type_of_work;
DROP TABLE IF EXISTS ams;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 10000;

CREATE TABLE ams
(
    id                 INTEGER PRIMARY KEY DEFAULT currval('global_seq'),
    code               VARCHAR(4)       NOT NULL,
    number             INTEGER          NOT NULL,
    cluster            VARCHAR,
    address            VARCHAR(200)     NOT NULL UNIQUE,
    type               VARCHAR          NOT NULL,
    height             DOUBLE PRECISION NOT NULL,
    service_contractor VARCHAR(32),
    service_date       TIMESTAMP,
    report_contractor  VARCHAR(32),
    report_date        TIMESTAMP
);

CREATE TABLE type_of_work
(
    ams_id INTEGER PRIMARY KEY,
    first  BOOL NOT NULL DEFAULT FALSE,
    second BOOL NOT NULL DEFAULT FALSE,
    third  BOOL NOT NULL DEFAULT FALSE,
    fourth BOOL NOT NULL DEFAULT FALSE,
    fifth  BOOL NOT NULL DEFAULT FALSE,
    CONSTRAINT ams_fk FOREIGN KEY (ams_id) REFERENCES ams (id) ON DELETE CASCADE
);