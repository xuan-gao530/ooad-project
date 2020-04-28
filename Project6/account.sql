drop table if exists accounts;
create table accounts (
  aid     int,
  type  varchar(50),
  username varchar(50),
  password varchar(50),
  email    varchar(50),
  addresss varchar(80),
  primary key (aid));

insert into accounts values(1,'Register','Rachel','rachel001','rachel@gmail.com','16 Black Street Apt106');
insert into accounts values(2,'Register','Ross','ross002','ross@gmail.com','134 Black Street Apt309');
insert into accounts values(3,'Register','Roy','roy003','roy@gmail.com','2240 Brown Street Apt502');
insert into accounts values(6,'Stock','Sophie','sophie006','sophie@gmail.com','');
insert into accounts values(7,'Stock','Scott','scott007','scott@gmail.com','');
insert into accounts values(8,'Order','Owen','owen008','owen@gmail.com','');