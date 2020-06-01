SET client_encoding TO 'utf8';

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
    address            VARCHAR(200)     NOT NULL,
    type               VARCHAR          NOT NULL,
    height             DOUBLE PRECISION NOT NULL,
    service_contractor VARCHAR(32),
    service_date       TIMESTAMP,
    report_contractor  VARCHAR(32),
    report_date        TIMESTAMP
);

CREATE TABLE type_of_work
(
    ams_id   INTEGER PRIMARY KEY,
    first_1  BOOL NOT NULL DEFAULT FALSE,
    first_1A BOOL NOT NULL DEFAULT FALSE,
    second   BOOL NOT NULL DEFAULT FALSE,
    third    BOOL NOT NULL DEFAULT FALSE,
    fourth   BOOL NOT NULL DEFAULT FALSE,
    fifth    BOOL NOT NULL DEFAULT FALSE,
    sixth    BOOL NOT NULL DEFAULT FALSE,
    seventh  BOOL NOT NULL DEFAULT FALSE,
    eighth_1 BOOL NOT NULL DEFAULT FALSE,
    eighth_2 BOOL NOT NULL DEFAULT FALSE,
    eighth_3 BOOL NOT NULL DEFAULT FALSE,
    eighth_4 BOOL NOT NULL DEFAULT FALSE,
    eighth_5 BOOL NOT NULL DEFAULT FALSE,
    eighth_6 BOOL NOT NULL DEFAULT FALSE,
    eighth_7 BOOL NOT NULL DEFAULT FALSE,
    CONSTRAINT ams_fk FOREIGN KEY (ams_id) REFERENCES ams (id) ON DELETE CASCADE
);