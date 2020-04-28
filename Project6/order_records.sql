drop table if exists order_records;
create table order_records (
  aid     int,
  pid     int,
  category  varchar(50),
  name varchar(50),
  qty  int,
  price  float);
