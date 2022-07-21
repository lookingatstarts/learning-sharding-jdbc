
create table product_description_0
(
    product_id bigint       not null primary key,
    shop_id    bigint       not null default 0,
    content    varchar(100) not null default ''
) engine = innodb;


create table product_description_1
(
    product_id bigint       not null primary key,
    shop_id    bigint       not null default 0,
    content    varchar(100) not null default ''
) engine = innodb;


create table product_description_2
(
    product_id bigint       not null primary key,
    shop_id    bigint       not null default 0,
    content    varchar(100) not null default ''
) engine = innodb;


create table product_description_3
(
    product_id bigint       not null primary key,
    shop_id    bigint       not null default 0,
    content    varchar(100) not null default ''
) engine = innodb;

create table product_description_4
(
    product_id bigint       not null primary key,
    shop_id    bigint       not null default 0,
    content    varchar(100) not null default ''
) engine = innodb;

create table product_description_5
(
    product_id bigint       not null primary key,
    shop_id    bigint       not null default 0,
    content    varchar(100) not null default ''
) engine = innodb;

create table product_description_6
(
    product_id bigint       not null primary key,
    shop_id    bigint       not null default 0,
    content    varchar(100) not null default ''
) engine = innodb;

create table product_description_7
(
    product_id bigint       not null primary key,
    shop_id    bigint       not null default 0,
    content    varchar(100) not null default ''
) engine = innodb;

create table product_description_8
(
    product_id bigint       not null primary key,
    shop_id    bigint       not null default 0,
    content    varchar(100) not null default ''
) engine = innodb;

create table product_description_9
(
    product_id bigint       not null primary key,
    shop_id    bigint       not null default 0,
    content    varchar(100) not null default ''
) engine = innodb;

create table product_base_0
(
    product_id bigint         not null primary key,
    `name`     varchar(100)   not null default '',
    price      decimal(18, 2) not null default '0.00',
    shop_id    bigint         not null default 0,
    type       smallint       not null default 1
) engine = innodb;

create table product_base_1
(
    product_id bigint         not null primary key,
    `name`     varchar(100)   not null default '',
    price      decimal(18, 2) not null default '0.00',
    shop_id    bigint         not null default 0,
    type       smallint       not null default 1
) engine = innodb;
create table product_base_2
(
    product_id bigint         not null primary key,
    `name`     varchar(100)   not null default '',
    price      decimal(18, 2) not null default '0.00',
    shop_id    bigint         not null default 0,
    type       smallint       not null default 1
) engine = innodb;
create table product_base_3
(
    product_id bigint         not null primary key,
    `name`     varchar(100)   not null default '',
    price      decimal(18, 2) not null default '0.00',
    shop_id    bigint         not null default 0,
    type       smallint       not null default 1
) engine = innodb;
create table product_base_4
(
    product_id bigint         not null primary key,
    `name`     varchar(100)   not null default '',
    price      decimal(18, 2) not null default '0.00',
    shop_id    bigint         not null default 0,
    type       smallint       not null default 1
) engine = innodb;
create table product_base_5
(
    product_id bigint         not null primary key,
    `name`     varchar(100)   not null default '',
    price      decimal(18, 2) not null default '0.00',
    shop_id    bigint         not null default 0,
    type       smallint       not null default 1
) engine = innodb;
create table product_base_6
(
    product_id bigint         not null primary key,
    `name`     varchar(100)   not null default '',
    price      decimal(18, 2) not null default '0.00',
    shop_id    bigint         not null default 0,
    type       smallint       not null default 1
) engine = innodb;

create table product_base_7
(
    product_id bigint         not null primary key,
    `name`     varchar(100)   not null default '',
    price      decimal(18, 2) not null default '0.00',
    shop_id    bigint         not null default 0,
    type       smallint       not null default 1
) engine = innodb;

create table product_base_8
(
    product_id bigint         not null primary key,
    `name`     varchar(100)   not null default '',
    price      decimal(18, 2) not null default '0.00',
    shop_id    bigint         not null default 0,
    type       smallint       not null default 1
) engine = innodb;

create table product_base_9
(
    product_id bigint         not null primary key,
    `name`     varchar(100)   not null default '',
    price      decimal(18, 2) not null default '0.00',
    shop_id    bigint         not null default 0,
    type       smallint       not null default 1
) engine = innodb;

create table t_user_0
(
    f_id       bigint not null primary key,
    f_username varchar(50) default '' not null
) charset = utf8mb4;

create table t_user_1
(
    f_id       bigint not null primary key,
    f_username varchar(50) default '' not null
) charset = utf8mb4;

create table t_user_2
(
    f_id       bigint not null primary key,
    f_username varchar(50) default '' not null
) charset = utf8mb4;

create table t_user_3
(
    f_id       bigint not null primary key,
    f_username varchar(50) default '' not null
) charset = utf8mb4;

create table t_user_4
(
    f_id       bigint not null primary key,
    f_username varchar(50) default '' not null
) charset = utf8mb4;

create table t_user_5
(
    f_id       bigint not null primary key,
    f_username varchar(50) default '' not null
) charset = utf8mb4;


create table t_user_6
(
    f_id       bigint not null primary key,
    f_username varchar(50) default '' not null
) charset = utf8mb4;

create table t_user_7
(
    f_id       bigint not null primary key,
    f_username varchar(50) default '' not null
) charset = utf8mb4;

create table t_user_8
(
    f_id       bigint not null primary key,
    f_username varchar(50) default '' not null
) charset = utf8mb4;

create table t_user_9
(
    f_id       bigint not null primary key,
    f_username varchar(50) default '' not null
) charset = utf8mb4;

create table shop
(
    product_id bigint      not null,
    `name`     varchar(30) not null default '',
    `address`  varchar(30) not null default '',
    `level`    varchar(30) not null default ''
) engine = innodb;

create table order_0
(
    order_id bigint not null primary key,
    user_id  bigint not null
) engine = innodb;

create table order_1
(
    order_id bigint not null primary key,
    user_id  bigint not null
) engine = innodb;

create table order_2
(
    order_id bigint not null primary key,
    user_id  bigint not null
) engine = innodb;

create table order_3
(
    order_id bigint not null primary key,
    user_id  bigint not null
) engine = innodb;

create table order_4
(
    order_id bigint not null primary key,
    user_id  bigint not null
) engine = innodb;

create table order_5
(
    order_id bigint not null primary key,
    user_id  bigint not null
) engine = innodb;

create table order_6
(
    order_id bigint not null primary key,
    user_id  bigint not null
) engine = innodb;

create table order_7
(
    order_id bigint not null primary key,
    user_id  bigint not null
) engine = innodb;

create table order_8
(
    order_id bigint not null primary key,
    user_id  bigint not null
) engine = innodb;

create table order_9
(
    order_id bigint not null primary key,
    user_id  bigint not null
) engine = innodb;