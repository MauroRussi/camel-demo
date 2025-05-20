# Getting Started

## Description

This is a project to add several samples of the usage of Apache Camel starting from basic examples and moving forward to more advanced projects.

These are some document references used during the tests:

- [Camel Manual](https://camel.apache.org/manual/index.html)
- [Camel Quarkus](https://camel.apache.org/camel-quarkus/3.20.x/index.html)
- [Camel components](https://camel.apache.org/components/4.10.x/eips/enterprise-integration-patterns.html)
- [Camel Examples](https://github.com/apache/camel-examples/tree/main)
- [Quarkus Project Creator](https://code.quarkus.io/)
- [Kaoto](https://kaoto.io/)

Camel related products of interest:

- **Camel Core:** Core library of the product.
- **Camel Jbang:** CLI tool for building low-code integrations with Camel.
- **Camel Karavan:** GUI to design and configure routes.
- **Kamelets:** Catalog of connectors.
- **Camel K:** Camel running on Kubernetes.

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
- [Project-4](./project-3/): This project is based on project-3 but the Yaml DSLs were created using **Karavan**. It uses **Jbang** and **Karavan**
