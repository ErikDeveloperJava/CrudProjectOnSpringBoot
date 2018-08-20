create database spring_demo_db character set utf8 collate utf8_general_ci;

use spring_demo_db;

create table author(
  id int not null auto_increment primary key ,
  name varchar(255) not null ,
  surname varchar(255) not null
)engine InnoDB character set utf8 collate utf8_general_ci;

create table book(
  id int not null auto_increment primary key ,
  title varchar(255) not null ,
  description varchar(255) not null ,
  price double not null ,
  author_id int not null ,
  foreign key (author_id) references author(id)
)engine InnoDB character set utf8 collate utf8_general_ci;