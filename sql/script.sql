create database if not exists spring_hotels;

use spring_hotels;

create table if not exists users (
                       id int primary key auto_increment,
                       login varchar(128) not null,
                       password longblob not null,
                       role enum('ADMIN', 'USER') not null
);

create table if not exists rooms (
                       id int primary key auto_increment,
                       size int not null ,
                       status enum('FREE', 'RESERVED', 'OCCUPIED') not null ,
                       type enum('COMMON', 'BUSINESS', 'DELUXE') not null ,
                       price decimal not null
);

create table if not exists reservation_templates (
                                       id int primary key auto_increment,
                                       user_id int not null ,
                                       room_size int not null ,
                                       room_type enum('COMMON', 'BUSINESS', 'DELUXE') not null ,
                                       start_date date not null ,
                                       end_date date not null ,
                                       creation_time datetime not null,
                                       foreign key (user_id) references users(id)
);

create table if not exists reservations (
                              id int primary key auto_increment,
                              user_id int not null ,
                              room_id int not null ,
                              start_date date not null ,
                              end_date date not null ,
                              pay_time datetime ,
                              creation_time datetime not null ,
                              price decimal not null ,
                              foreign key (user_id) references users(id),
                              foreign key (room_id) references rooms(id)
);

insert into rooms (size, status, type, price) VALUE
    (4, 'FREE', 'COMMON', 5.6),
    (2, 'FREE', 'BUSINESS', 3.4),
    (3, 'FREE', 'DELUXE', 67),
    (1, 'FREE', 'COMMON', 23),
    (4, 'FREE', 'BUSINESS', 3.4);
