-- 기존의 CREATE DATABASE... 문장은 MySQL용이라 H2에서는 지워야 합니다.
-- 바로 테이블 생성 문구로 넘어가거나, 파일 내용을 아예 비워두어도 JPA가 자동으로 만들어줍니다.

DROP TABLE IF EXISTS settlement;
DROP TABLE IF EXISTS expense_share;
DROP TABLE IF EXISTS expense;
DROP TABLE IF EXISTS house_member;
DROP TABLE IF EXISTS house;

CREATE TABLE house (
    house_id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255),
    invite_code VARCHAR(255)
);

CREATE TABLE house_member (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    house_id VARCHAR(255),
    user_id VARCHAR(255),
    role VARCHAR(50)
);

CREATE TABLE expense (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    house_id VARCHAR(255),
    title VARCHAR(255),
    amount BIGINT,
    category VARCHAR(255),
    paid_by VARCHAR(255),
    expense_date VARCHAR(255)
);

CREATE TABLE expense_share (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    house_id VARCHAR(255),
    user_id VARCHAR(255),
    share_amount BIGINT,
    settled BOOLEAN
);

CREATE TABLE settlement (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    house_id VARCHAR(255),
    from_user_id VARCHAR(255),
    to_user_id VARCHAR(255),
    amount BIGINT,
    status VARCHAR(50)
);