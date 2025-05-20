# Project-4

This is a project using **Apache Karavan** that aims to:

- Create the same routes of project-3 using Karavan.

## Steps to run the demo

### Docker mode

 1. Set the following environment variables:

    ```bash
    export KARAVAN_GIT_USERNAME=<DUMMY_USERNAME>
    export KARAVAN_GIT_REPOSITORY=<URL_REPOSITORY>
    export KARAVAN_GIT_PASSWORD=<GIT_TOKEN>
    export KARAVAN_REGISTRY_URL=<REGISTRY_URL>
    export KARAVAN_REGISTRY_USERNAME=<REGISTRY_USERNAME>
    export KARAVAN_REGISTRY_PASSWORD=<REGISTRY_PASSWORD>
    ```

 2. Runs the docker compose file located [here](./docker/docker-compose.yaml). It deploys a registry and Karavan web designer.
 3. Open the Karavan designed located on http://localhost:8080

### Visual Studio (Karavan)

 1. Install the extension of Karavan.
 2. Install jbang and add the camel module executing command:

 ```bash
 jbang app install camel@apache/camel
 ```