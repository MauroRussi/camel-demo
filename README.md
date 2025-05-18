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