create table customer (
    id serial primary key,
    first_name varchar(20),
    last_name varchar(20),
    email varchar(20),
    address varchar(80),
    seller_id integer,
    foreign key(seller_id) references seller(id)
);

create table seller (
    id serial primary key,
    first_last_name varchar(40),
    age integer check (age > 0 and age < 120),
    phone_number varchar,
    storage_id integer,
    foreign key(storage_id) references storage(id)
);

create table toy (
    id serial primary key,
    description varchar(20),
    cost integer check (cost >= 0),
    size varchar(10),
    customer_id integer,
    foreign key(customer_id) references customer(id)
);

insert into toy (description, cost, size, customer_id) values ('The big white bear', 2500, 'big', 1);
insert into toy (description, cost, size, customer_id) values ('The pony', 500, 'small', 2);
insert into toy (description, cost, size) values ('Полярный медведь', 700, 'small');
insert into toy (description, cost, size, customer_id) values ('The rubbish', 1200, 'middle', 1);

create table storage (
    id serial primary key,
    capacity integer check (capacity > 2)
);

insert into storage (capacity) values (210);
insert into storage (capacity) values (500);


create table feedback (
    id serial primary key,
    feedback varchar(400),
    toy_id integer,
    foreign key(toy_id) references toy(id),
    customer_id integer,
    foreign key(customer_id) references customer(id)
);

drop table toy;

drop table seller;

drop table customer;

drop table storage;

insert into seller(first_last_name) values ('Екатерина Завчук');


