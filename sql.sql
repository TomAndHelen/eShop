create database shop;
use shop;

create table t_user(
	`id` int primary key auto_increment,
    `username` varchar(50) not null unique,
    `password` varchar(50) not null,
    `email` varchar(50)
);

insert into t_user(`username`, `password`, `email`)
values('admin', 'admin', '840165852@qq.com');

insert into t_user(`username`, `password`, `email`)
values('user1', '123456', 'xiaojianpeng1102@outlook.com');



create table t_good(
	`id` int primary key auto_increment,
    `name` varchar(100),
    `price` decimal(11,2),
    `sales` int,
    `stock` int
    );
    
insert into t_good(`id`,`name`, `price`,`sales`, `stock`)
values(null, '货物1', 11.1, 0, 200);
insert into t_good(`id`,`name`, `price`,`sales`, `stock`)
values(null, '货物2', 11.1, 0, 200);
insert into t_good(`id`,`name`, `price`,`sales`, `stock`)
values(null, '货物3', 11.1, 0, 200);
insert into t_good(`id`,`name`, `price`,`sales`, `stock`)
values(null, '货物4', 11.1, 0, 200);
insert into t_good(`id`,`name`, `price`,`sales`, `stock`)
values(null, '货物5', 11.1, 0, 200);

create table t_order(
	`orderId` varchar(50) primary key,
    `createTime` datetime,
    `price` decimal(11,2),
    `userId` int,
    foreign key(`userId`) references t_user(`id`)
);

create table t_order_item(
	`id` int primary key auto_increment,
    `name` varchar(100),
    `count` int,
    `price` decimal(11,2),
    `totalPrice` decimal(11,2),
    `orderId` varchar(50),
    foreign key(`orderId`) references t_order(`orderId`)
);

