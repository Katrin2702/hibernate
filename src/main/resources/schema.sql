create schema persons;
use persons;

create table persons
(
    name varchar(255) not null,
    surname varchar(255) not null,
    age int check (age > 0),
    phone_number varchar(255) not null default 'нет данных',
    city_of_living varchar(255) not null default 'нет данных',
    PRIMARY KEY (name, surname, age)
);

insert into persons values ('Andrey', 'Sidorov', 38, '+79778523120', 'MOSCOW');
insert into persons values ('Mike', 'Wilson', 15, '+447800767690', 'LONDON');
insert into persons values ('Natali', 'Spiridonova', 21, '+380502362122', 'KYIV');
insert into persons values ('Ivan', 'Sukhanov', 56, '+79053645452', 'MOSCOW');


