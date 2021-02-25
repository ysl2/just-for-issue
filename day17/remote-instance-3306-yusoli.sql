-- CREATE DATABASE IF NOT EXISTS day17;
-- -- 创建数据库
-- -- 使用数据库
-- CREATE TABLE user(
--     -- 创建表
--     id int PRIMARY KEY AUTO_INCREMENT,
--     name varchar(20) NOT NULL,
--     gender varchar(5),
--     age int,
--     address varchar(32),
--     qq varchar(20),
--     email varchar(50)
-- );
-- USE day17;

-- INSERT INTO
--     user(name, gender, age, address, qq, email)
-- VALUES
--     (
--         '张三',
--         '男',
--         13,
--         '陕西',
--         '12345',
--         'zhangsan@itcast.cn'
--     );

-- INSERT INTO
--     user(name, gender, age, address, qq, email)
-- VALUES
--     (
--         '李四',
--         '女',
--         15,
--         '北京',
--         '88888',
--         'lisi@itcast.cn'
--     );
USE day17;
SELECT
    *
FROM
    user;
