drop table if exists users;

create table users (
    userid      varchar(18)     not null,
    passwd      varchar(18)     not null,
    name        varchar(10)     not null,
    email       varchar(50)     not null,
    createdAt   datetime        default current_timestamp,
    primary key (userid)
);