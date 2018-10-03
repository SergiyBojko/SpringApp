--liquibase formatted sql

--changeset serhii:createdTableEmployee
create table employee (
    id int primary key AUTO_INCREMENT,
    name varchar(50)
);

--changeset serhii:initializedTableEmployee
insert into employee (name) values ('John'),('Alex'),('Bob'),('Mark'),('Kate');

