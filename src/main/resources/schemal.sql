drop database if exists ds0;
drop database if exists ds1;
create database ds0;
create database ds1;
drop table if exists ds0.t_user_0;
drop table if exists ds0.t_user_1;
drop table if exists ds0.t_user_2;
drop table if exists ds0.t_user_3;
drop table if exists ds0.t_user_4;
drop table if exists ds0.t_user_5;
drop table if exists ds0.t_user_6;
drop table if exists ds0.t_user_7;
drop table if exists ds0.t_user_8;
drop table if exists ds0.t_user_9;
drop table if exists ds1.t_user_0;
drop table if exists ds1.t_user_1;
drop table if exists ds1.t_user_2;
drop table if exists ds1.t_user_3;
drop table if exists ds1.t_user_4;
drop table if exists ds1.t_user_5;
drop table if exists ds1.t_user_6;
drop table if exists ds1.t_user_7;
drop table if exists ds1.t_user_8;
drop table if exists ds1.t_user_9;
create table ds0.t_user_1
(
    f_id       bigint primary key,
    f_username varchar(50) not null default '',
    unique uniq_username (f_username)
) default charset 'utf8mb4'
  engine innodb;
drop table if exists ds0.t_order_202201;
drop table if exists ds0.t_order_202202;
drop table if exists ds0.t_order_202203;
drop table if exists ds0.t_order_202204;
drop table if exists ds0.t_order_202205;
drop table if exists ds0.t_order_202206;
drop table if exists ds0.t_order_202207;
drop table if exists ds0.t_order_202208;
drop table if exists ds0.t_order_202209;
drop table if exists ds0.t_order_202210;
drop table if exists ds0.t_order_202211;
drop table if exists ds0.t_order_202212;
drop table if exists ds1.t_order_202201;
drop table if exists ds1.t_order_202202;
drop table if exists ds1.t_order_202203;
drop table if exists ds1.t_order_202204;
drop table if exists ds1.t_order_202205;
drop table if exists ds1.t_order_202206;
drop table if exists ds1.t_order_202207;
drop table if exists ds1.t_order_202208;
drop table if exists ds1.t_order_202209;
drop table if exists ds1.t_order_202210;
drop table if exists ds1.t_order_202211;
drop table if exists ds1.t_order_202212;
create table ds0.t_order_202201
(
    f_id         bigint primary key,
    f_user_id    bigint not null default 0,
    f_month      int    not null default 0,
    f_created_at bigint not null default 0
) default charset 'utf8mb4'
  engine innodb;
create table ds0.t_order_202202 like ds0.t_order_202201;
create table ds0.t_order_202203 like ds0.t_order_202201;
create table ds0.t_order_202204 like ds0.t_order_202201;
create table ds0.t_order_202205 like ds0.t_order_202201;
create table ds0.t_order_202206 like ds0.t_order_202201;
create table ds0.t_order_202207 like ds0.t_order_202201;
create table ds0.t_order_202208 like ds0.t_order_202201;
create table ds0.t_order_202209 like ds0.t_order_202201;
create table ds0.t_order_202210 like ds0.t_order_202201;
create table ds0.t_order_202211 like ds0.t_order_202201;
create table ds0.t_order_202212 like ds0.t_order_202201;
create table ds1.t_order_202201 like ds0.t_order_202201;
create table ds1.t_order_202202 like ds0.t_order_202201;
create table ds1.t_order_202203 like ds0.t_order_202201;
create table ds1.t_order_202204 like ds0.t_order_202201;
create table ds1.t_order_202205 like ds0.t_order_202201;
create table ds1.t_order_202206 like ds0.t_order_202201;
create table ds1.t_order_202207 like ds0.t_order_202201;
create table ds1.t_order_202208 like ds0.t_order_202201;
create table ds1.t_order_202209 like ds0.t_order_202201;
create table ds1.t_order_202210 like ds0.t_order_202201;
create table ds1.t_order_202211 like ds0.t_order_202201;
create table ds1.t_order_202212 like ds0.t_order_202201;

create table ds0.t_user_0 like ds0.t_user_1;
create table ds0.t_user_2 like ds0.t_user_1;
create table ds0.t_user_3 like ds0.t_user_1;
create table ds0.t_user_4 like ds0.t_user_1;
create table ds0.t_user_5 like ds0.t_user_1;
create table ds0.t_user_6 like ds0.t_user_1;
create table ds0.t_user_7 like ds0.t_user_1;
create table ds0.t_user_8 like ds0.t_user_1;
create table ds0.t_user_9 like ds0.t_user_1;
create table ds1.t_user_0 like ds0.t_user_1;
create table ds1.t_user_1 like ds0.t_user_1;
create table ds1.t_user_2 like ds0.t_user_1;
create table ds1.t_user_3 like ds0.t_user_1;
create table ds1.t_user_4 like ds0.t_user_1;
create table ds1.t_user_5 like ds0.t_user_1;
create table ds1.t_user_6 like ds0.t_user_1;
create table ds1.t_user_7 like ds0.t_user_1;
create table ds1.t_user_8 like ds0.t_user_1;
create table ds1.t_user_9 like ds0.t_user_1;

create table ds0.t_city
(
    f_id        bigint primary key,
    f_city_name varchar(50) not null default '',
    unique uniq_city_name (f_city_name)
) default charset 'utf8mb4'
  engine innodb;
create table ds1.t_city
(
    f_id        bigint primary key,
    f_city_name varchar(50) not null default '',
    unique uniq_city_name (f_city_name)
) default charset 'utf8mb4'
  engine innodb;