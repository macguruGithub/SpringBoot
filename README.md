# Spring Boot Microservice
Prerequisites
  1. Install Docker Desktop
  2. Run 'docker-compose.yml' by command : 'docker compose up -d'
    this command will pull the appropriate image from DockerHub and ran it in the local. Result you will get the postgres up and running in the local. For more details please see the 'docker-compose.yml' file.
  3. Build and run the maven modules in the following order
    a. ServiceRegistry
    b. Customer and Fraud in any order
