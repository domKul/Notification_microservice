### Microservice for catch notifcations from rabbitmq and send emails



####  part (3) of microservices
* (1) [Eureka Server](https://github.com/domKul/EurekaServer_microservice)
* (2) [Gateway](https://github.com/domKul/Gateway_microservice)
* (3) [Notification service](https://github.com/domKul/Notification_microservice)
* (4) [Course service](https://github.com/domKul/CourseService_microservice)
* (5) [Student service](https://github.com/domKul/Students_microservice)

## Running the Courses Server

To run the Courses Server, follow these steps:

1. Make sure you have Java installed on your machine.

2. Clone the project sources from the repository.

3. You need to setup the connection with rabbitmq queue:
```spring.rabbitmq.addresses=amqps://${YOUR_USERNAME}:${YOUR_PASSWORD}@sparrow.rmq.cloudamqp.com/${YOUR_USERNAME}```
replace all environment variables with yours information in `application.properties` file

4. You need to setup the connection with smtp for endping emails:
```
spring.mail.username=${MAIL_HOST_USER}
spring.mail.password=${MAIL_HOST_PASSWORD}
```
replace this 2 lines wit your user and password i use gmail smpt in my service.
