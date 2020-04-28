# OOAD- Final Project: Sunny Supermarket System

## Team member: Xuan Gao & Lan Sang

## Language and environment used for development
- Java version 13.0.2
- IntelliJ IDEA Ultimate Edition 2020.1
- Mysql 
- JDBC:mysql-connector-java-8.0.19
- Tomcat Server 9.0.34
- HTML

### Description of program design
1. We use **`MVC pattern`** to finish  this project.
- Model:     userdao package inludes UserDao, ProductDao, OrderDao，CartDADao.
             This part is used to connect the databases and make CURD of four tables(accounts,products,order_records,cart_records) in mysql.
- View:      web filefolder includes all webpages writing by HTML
- Contoller：package service and servlet. We have mainly 4 parts:
   - LoginServlet for login
   - SearhSevlet for search the products
   - ShowServlet,UpdateStockServlet,ViewStockServlet for managing the stock
   - OrderServlet,ViewOrderSerlvet for managing the order
* Other parts: package util for connecting, updating, querying and closing the database.
               package entity for instantiating the object users and products

2. We have four kinds of users

|Name | type | infomation| description|
|-----|--------|------|------|
|Rachel | Register | Customer--userid:1| view the account information/ shopping/ view orders |
|Ross| Register | Customer--userid:2| view the account information/ shopping/ view orders |
|Roy  | Register |Customer--userid:3| view the account information/ shopping/ view orders |
|Sophie| Stock | Staff--userid:6| view the stock(one products or input all to view all products)/update the stock|
|Scott| Stock | Staff --userid:7|view the stock(one products or input all to view all products)/update the stock|
|Owent| Order| Staff --userid:8| view all orders which are made by all customers|
|none| Unregister |Customer --userid:9| shopping as a guest and need to input the address to finish the order|

Ps: In accounts table, we don't save the information of unregister.

### Run information
- Install the mysql /JDBC/ TOMCAT
- Start the mysql server and Login the mysql to create the databases:
    - create databases market
    - create the tables use the .sql file. EX. source f:/ooad-project/products.sql
- Open the  IntelliJ IDEA and edit the tomcat configuration
- Run the program and open the webpage :http://localhost:8080/sunny/
    - Login username and userpassword information is in accounts.sql.
