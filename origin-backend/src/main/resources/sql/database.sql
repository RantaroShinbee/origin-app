-- create database
drop database if exists originstore;
create database originstore;

-- use database
use originstore;

-- create structure --

-- user_roles
create table user_roles (
    id varchar(64) primary key not null,
    role varchar(65) unique not null,
    description varchar(255)
);