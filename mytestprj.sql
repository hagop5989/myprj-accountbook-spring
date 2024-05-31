USE mytestprj0527;

CREATE TABLE board
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    date       VARCHAR(30)   NOT NULL,
    income     INT(100)      NOT NULL,
    expense    INT(100)      NOT NULL,
    categories VARCHAR(100)  NOT NULL,
    how        VARCHAR(1000) NOT NULL
);



DELETE
FROM board
WHERE id BETWEEN 1 AND 1;

ALTER TABLE board
    MODIFY COLUMN date DATE;

SELECT *
FROM board;

ALTER TABLE board
    ADD COLUMN rowSum INT(100) NOT NULL;

CREATE TABLE member
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    nick_name VARCHAR(30) NOT NULL UNIQUE,
    password  VARCHAR(30) NOT NULL
)