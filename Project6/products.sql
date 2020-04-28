drop table if exists products;
create table products (
  pid     int,
  category  varchar(50),
  name varchar(50),
  qty  int,
  price  float,
  primary key (pid));
 
insert into products values(9001,'Food','Shrimp',12,9.99);
insert into products values(9002,'Food','Beef',10,8.99);
insert into products values(9003,'Food','Pork',15,3.0);
insert into products values(9004,'Food','Orange',50,0.99);
insert into products values(9005,'Food','Apple',50,1.19);
insert into products values(9006,'Food','Banana',60,0.5);
insert into products values(9007,'Food','Bread',40,4.99);
insert into products values(9008,'Food','Milk',30,3.5);
insert into products values(9009,'Food','Eggs',30,3.6);
insert into products values(9010,'Beverage','Coffee',45,3.2);
insert into products values(9011,'Beverage','Tea',30,2.5);
insert into products values(9012,'Beverage','Water',50,1.5);
insert into products values(9013,'Beverage','Juices',30,2.0);
insert into products values(9014,'Beverage','Cola',50,1.5);
insert into products values(9015,'Household','Laundry',20,7.99);
insert into products values(9016,'Household','Dishwashing',15,2.99);
insert into products values(9017,'Household','Paper',20,6.99);
insert into products values(9018,'Household','Pet supplies',10,8.99);
insert into products values(9019,'Personal Care','Shampoo',10,15.99);
insert into products values(9020,'Personal Care','Condition',10,14.99);