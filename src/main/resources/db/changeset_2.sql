--liquibase formatted sql

--changeset serhii:createdTableDepartment
create table department (
    id int primary key AUTO_INCREMENT,
    name varchar(50),
    description varchar(100)
);

--changeset serhii:initializedTableDepartment
insert into department (name, description)  values ('sales', 'stuff'), ('advertisement', 'lorem ipsum');

--changeset serhii:addedLinkingTableEmployee_department
create table employee_department (
    id_employee int,
    id_department int,
    foreign key (id_employee) references employee(id),
    foreign key (id_department) references department(id)
);

--changeset serhii:initializedLinkingTableEmployee_department
insert into employee_department values (1, 1), (2, 1), (3, 1), (4, 2), (5, 2), (5, 1);
