CREATE TABLE myuser(
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(32) UNIQUE NOT NULL,
    -- 最后一个属性不要加后面的逗号。否则一辈子报错。
    password VARCHAR(32) NOT NULL
);
USE day14;
INSERT INTO myuser (username, password) VALUES ('superbaby', '123');
SELECT * FROM myuser;
