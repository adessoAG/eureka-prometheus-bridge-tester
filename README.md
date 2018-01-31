# Eureka-prometheus-bridge-tester
Microservice Repository for Testing the Eureka-Prometheus-Bridge

### Running with docker-compose

To run this example simply execute the docker-compose.yml with 
`docker-compose up` in the project_dir.

### Running via Docker-Registry

The services can also be used and run for testing via docker registry.

Use:

`docker run -d --name eureka-service -p 8761:8761 smahler/epb-eureka-service`

`docker run -d --name test-service -p 1001:1001 --link=eureka-service smahler/epb-test-service`

`docker run -d --name test-service2 -p 1002:1002 --link=eureka-service smahler/epb-test-service2`


### Run the standard way

You can also start the application via `gradlew build` (in each service_dir) and then executing
 the jars in `build/libs/service-nameXYZ.jar`, but i recommend to start eureka first, so that the other services
 can connect directly. In fact it doesn't matter, because they'll connect when they launch after some seconds.
 
 
