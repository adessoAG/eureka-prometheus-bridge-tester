# Eureka-prometheus-bridge-tester
Microservice Repository for Testing the Eureka-Prometheus-Bridge

### Running with docker-compose

To run this example simply execute the docker-compose.yml with 
`docker-compose up` in the project_dir.

### Run the standard way

You can also start the application via `gradlew build` (in each service_dir) and then executing
 the jars in `build/libs/service-nameXYZ.jar`, but i recommend to start eureka first, so that the other services
 can connect directly. In fact it doesn't matter, because they'll connect when they launch after some seconds.
 
 