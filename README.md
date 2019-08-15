![giphy](https://user-images.githubusercontent.com/49983024/63015541-860c5000-be91-11e9-8fc8-7cebb7f12003.gif)
# HotelBooking
## Content:
* [Project description](#project-description)
* [Dependencies](#dependencies)
* [Installation instruction](#installation-instruction)
* [Launch instruction](#launch-instruction)

### Project description:
This project is a hotel booking system which gives ability to users to make request with following room criteria: room type (single, double,
lux),
balcony availability, smoking possibility, price range and time period they want to stay at this hotel. If there is available room for given
period and room criteria then user receives the amount he has to pay for staying in this room. If there is no available room then user gets
message that with given room criteria nothing was found. There is an authorization system as well which gives possibility 
to all authorized users not to fulfill the guest info form everytime they want to make a reservation.

### Dependencies:
* jstl 1.2
* javaee-api 6.0
* javax.servlet-api 3.0.1
* jsp-api 2.0
* junit 4.12
* log4j 1.2.17
* mockito-all 1.9.5
* mysql-connector-java 8.0.16
* tomcat-dbcp 7.0.47

### Installation instruction:

#### *Step 1:*
***Tools to be pre-installed on your device:***
- [x] MySQL Server (Not less than 8.0 version)
- [x] JDK 1.8.0_192
- [x] Apache Tomcat 7.0.94 Tomcat7
- [x] Apache-maven-3.6.1

#### *Step 2:*
Clone this repository - https://github.com/ArtemHalai/HotelBooking.git

### Launch instruction:

#### *Step 1:*
After opening this project in your IDE type "mvn tomcat7:run" in your terminal.

#### *Step 2:*
Open your browser and type "http://localhost:8080/" in address bar.
