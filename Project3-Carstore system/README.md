# OOAD-Project3: Carstore system
## Team member : Lan Sang (lasa9094)  & Xuan Gao(xuga2324)

## Language and environment used for development 
Java version 13.0.2
IntelliJ IDEA Community Edition 2019.3.1

## File
1.output file :printout.txt
2.PDF file: UML Diagram

## Description of program design
We has 3 parts: cars,customers and store.
* We use **Factory Pattern** to instantiate cars and customer.
* We use **Decorator Pattern** to add options to cars.
* We use **Observer Pattern** to output the information.

1. cars (options)

|type | number | price|
|-----|--------|------| 
|Economy | 6 | 50|
|Standard| 8 | 60|
|Luxury  | 3 | 90|
|Minivan | 4 | 70|
|SUV     | 3 | 80|
|child car seat| 0-4 | 10|
|gps     | 0-1 |15|
|radio satellite| 0-1 | 5|

We set the number of options randomly. And we calculate the cost with options.

2.customer
|type | number | rent car| rent night
|-----|--------|---------|----------|
|Business | 3 | 3 | 7|
|Regular  | 4 |1-3|3-5|
|Casual   | 5 | 1 |1-3|

For each type of customer, we all set the limit for their rental cars and nights in the class and then randomly set the value.

3.store
This package has 6 parts.
* processdata is used to process data, such as instiating the car and customer.What's more, it deals with renting cars and returning cars.
* Subject and Observer are interfaces to used in Observer Pattern.
* carstore is the main progress of simulator of 35 days. Each day randomly select customer to rent cars with different number of options. Each customer can rent once each day.  If the store has less than 3 cars, then a Business customer will not arrive.
* printout is the observer to get the notification to print everyday rental information.
