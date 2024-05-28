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

SELECT *
FROM board;

DELETE FROM board WHERE id BETWEEN 1 AND 34;

ALTER TABLE board MODIFY COLUMN date DATE;
