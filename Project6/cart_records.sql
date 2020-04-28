drop table if exists cart_records;
create table cart_records (
  pid     int,
  category  varchar(50),
  name varchar(50),
  qty_incart  int,
  price  float,
  aid int,
  primary key (pid));
