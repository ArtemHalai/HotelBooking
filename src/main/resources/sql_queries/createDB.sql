
CREATE DATABASE hotel;

USE hotel;

CREATE TABLE users(
user_id int  auto_increment primary key,
 name varchar(30),
 surname varchar(30),
 username varchar(30),
 role varchar(10) default null,
 password varchar(30),
 age int,
 phone varchar(20),
passport_id varchar(20));

//Inserting admin
INSERT INTO users(name, surname, username, role, password, age, phone, passport_id) VALUES ("Artem","Halai", "artemadmin","ADMIN",
"12345678",24, "+380505873651", "ME123456");

CREATE TABLE room_type(
room_type_id int auto_increment primary key,
description varchar(20),
capacity int);

CREATE TABLE rooms(
room_id int auto_increment primary key,
 number int unique,
 balcony bool,
 smoke bool,
 price decimal(10,2));
ALTER TABLE rooms ADD room_type_id int;
ALTER TABLE rooms ADD INDEX(price);
ALTER TABLE rooms ADD FOREIGN KEY (room_type_id) REFERENCES room_type(room_type_id)
ON DELETE CASCADE ON UPDATE CASCADE;

CREATE TABLE payments(
payment_id int auto_increment primary key,
room_id int not null,
amount decimal(10,2),
user_id int not null,
payment_date date not null,
foreign key (room_id) references rooms(room_id),
foreign key (user_id) references users(user_id));

CREATE TABLE room_requests(
room_request_id int auto_increment primary key,
room_type_id int,
date_in date not null,
date_out date not null,
foreign key (room_type_id) references room_type(room_type_id));

CREATE TABLE reservations(
reservation_id int auto_increment primary key,
 date_in date not null,
 date_out date not null,
 user_id int,
 room_id int not null,
foreign key (user_id) references users(user_id) ON DELETE CASCADE ON UPDATE CASCADE,
foreign key (room_id) references rooms(room_id) ON DELETE CASCADE ON UPDATE CASCADE);

/*Creating room types*/
insert into room_type(description, capacity) values ("single",1);
insert into room_type(description, capacity) values ("double",2);
insert into room_type(description, capacity) values ("lux",4);

/*Creating rooms in hotel*/
insert into rooms(number,balcony, smoke, price,room_type_id) values (001,false,true,159.99,2);
insert into rooms(number,balcony, smoke, price,room_type_id) values (002,false,false,89.99,1);
insert into rooms(number,balcony, smoke, price,room_type_id) values (003,true,true,120.88,2);
insert into rooms(number,balcony, smoke, price,room_type_id) values (004,true,false,89.99,1);
insert into rooms(number,balcony, smoke, price,room_type_id) values (005,true,false,89.99,1);
insert into rooms(number,balcony, smoke, price,room_type_id) values (006,true,true,120.88,2);
insert into rooms(number,balcony, smoke, price,room_type_id) values (007,false,false,89.99,1);
insert into rooms(number,balcony, smoke, price,room_type_id) values (008,true,false,89.99,1);
insert into rooms(number,balcony, smoke, price,room_type_id) values (009,true,false,89.99,1);
insert into rooms(number,balcony, smoke, price,room_type_id) values (010,true,true,120.88,2);
insert into rooms(number,balcony, smoke, price,room_type_id) values (011,false,false,89.99,1);
insert into rooms(number,balcony, smoke, price,room_type_id) values (012,true,false,89.99,1);
insert into rooms(number,balcony, smoke, price,room_type_id) values (013,true,true,120.88,2);
insert into rooms(number,balcony, smoke, price,room_type_id) values (014,true,false,89.99,1);
insert into rooms(number,balcony, smoke, price,room_type_id) values (015,true,false,89.99,1);
insert into rooms(number,balcony, smoke, price,room_type_id) values (016,true,true,120.88,2);
insert into rooms(number,balcony, smoke, price,room_type_id) values (017,true,false,89.99,1);
insert into rooms(number,balcony, smoke, price,room_type_id) values (018,true,false,89.99,1);
insert into rooms(number,balcony, smoke, price,room_type_id) values (019,true,true,120.88,2);
insert into rooms(number,balcony, smoke, price,room_type_id) values (020,true,false,89.99,1);
insert into rooms(number,balcony, smoke, price,room_type_id) values (021,false,false,89.99,1);
insert into rooms(number,balcony, smoke, price,room_type_id) values (022,true,true,120.88,2);
insert into rooms(number,balcony, smoke, price,room_type_id) values (023,true,false,89.99,1);
insert into rooms(number,balcony, smoke, price,room_type_id) values (024,true,false,89.99,1);
insert into rooms(number,balcony, smoke, price,room_type_id) values (025,true,false,89.99,1);
insert into rooms(number,balcony, smoke, price,room_type_id) values (026,true,false,89.99,1);
insert into rooms(number,balcony, smoke, price,room_type_id) values (027,false,false,89.99,1);
insert into rooms(number,balcony, smoke, price,room_type_id) values (028,true,false,89.99,1);
insert into rooms(number,balcony, smoke, price,room_type_id) values (029,true,false,89.99,1);
insert into rooms(number,balcony, smoke, price,room_type_id) values (030,false,true,289.99,1);
insert into rooms(number,balcony, smoke, price,room_type_id) values (031,true,true,289.99,3);
insert into rooms(number,balcony, smoke, price,room_type_id) values (032,true,true,289.99,3);
insert into rooms(number,balcony, smoke, price,room_type_id) values (033,true,true,289.99,3);
insert into rooms(number,balcony, smoke, price,room_type_id) values (034,false,true,289.99,3);
insert into rooms(number,balcony, smoke, price,room_type_id) values (035,true,true,289.99,3);
insert into rooms(number,balcony, smoke, price,room_type_id) values (036,true,true,289.99,3);
insert into rooms(number,balcony, smoke, price,room_type_id) values (037,false,false,289.99,3);
insert into rooms(number,balcony, smoke, price,room_type_id) values (038,true,true,289.99,3);
insert into rooms(number,balcony, smoke, price,room_type_id) values (039,true,false,289.99,3);
insert into rooms(number,balcony, smoke, price,room_type_id) values (040,true,true,149.99,2);
insert into rooms(number,balcony, smoke, price,room_type_id) values (041,true,true,289.99,3);
insert into rooms(number,balcony, smoke, price,room_type_id) values (042,false,false,89.99,1);
insert into rooms(number,balcony, smoke, price,room_type_id) values (043,true,true,289.99,3);
insert into rooms(number,balcony, smoke, price,room_type_id) values (044,false,true,289.99,3);
insert into rooms(number,balcony, smoke, price,room_type_id) values (045,true,true,189.99,2);
insert into rooms(number,balcony, smoke, price,room_type_id) values (046,true,true,289.99,3);
insert into rooms(number,balcony, smoke, price,room_type_id) values (047,false,false,289.99,2);
insert into rooms(number,balcony, smoke, price,room_type_id) values (048,false,true,189.99,3);
insert into rooms(number,balcony, smoke, price,room_type_id) values (049,true,true,289.99,2);
insert into rooms(number,balcony, smoke, price,room_type_id) values (050,false,false, 89.99,1);
