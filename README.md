# Getting Started

## Description

This is a project to add several samples of the usage of Apache Camel starting from basic examples and moving forward to more advanced projects.

## Environment preparation

These are the required software:

- Java 22
- Docker
- Quarkus
- Apache Camel

## Project creation

This is the command to create a Quarkus project with basic libraries:

```bash
mvn io.quarkus.platform:quarkus-maven-plugin:3.22.3:create \
    -DprojectGroupId=co.com.home.labs.camel \
    -DprojectArtifactId=project-1 \
    -Dextensions='rest'
cd project-1
```

Remove unnecessary files to upload in the repo

```bash
rm -rf .mvn
rm -f mvnw*
```

Build and test the project created:

```bash
mvn clean compile install quarkus:dev
```

## Project index

This is a description of every project:

- [Project-1](./project-1/): This project is a simple route written in Java DSL that prints in a log a hardcoded message every 2 seconds. It uses a **camel-timer** and **camel-log**.
- [Project-2](./project-2/): This project is a route written in Java DSL that exposes 3 Rest endpoints and routes every request to an internal routes that set the response of the endpoints and prints them in a log. It uses a **camel-rest**, **camel-direct** and **camel-log**.
- [Project-3](./project-3/): This project is a migration of project-1 and project-2 in Yaml DSL. It uses a **camel-timer**, **camel-rest**, **camel-direct**, **camel-log**, and **camel-yaml-dsl**.
