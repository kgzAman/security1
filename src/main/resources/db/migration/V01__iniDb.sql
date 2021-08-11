use `security`;
create table users (
    id bigint not null auto_increment,
    email varchar(255) unique, password varchar(255),
    status varchar(255), sur_name varchar(255),
    user_name varchar(255), roles varchar(255),
    primary key (id)) engine=InnoDB