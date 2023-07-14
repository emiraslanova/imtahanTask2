create  schema task2;

create  table  parents
(
    id bigint primary key  auto_increment,
    name varchar(20),
    surname varchar(30),
    parent_brith_date timestamp,
    job_name varchar(50)

);




create  table  children
(
    id bigint primary key  auto_increment,
    name varchar(20),
    brith_date date,
    parent_id bigint ,
    foreign key (parent_id) references parents(id)


);
select *from children;
insert into children(name, parent_id)
values ('Minaver',3)
