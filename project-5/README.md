# Project-5

This is a project to explain steps to install **Camel K** and deployment some routes created with **Camel Karavan**.

## Steps to run the demo

This document was the key to deploy this: [https://artifacthub.io/packages/helm/camel-k/camel-k/2.5.0]

### Install Minikube using Docker (Colima)

1. Start Colima in Docker mode

   ```bash
   # Start Colima
   $ colima start

   # Check docker is running
   $ docker info
   ```

2. Start minikube

   ```bash
   # Start minikube
   $ minikube start

   # Check status of minikube
   $ minikube status
   ```

### Setup Camel K Operator

1. Install **Camel K Operator** using helm

   ```bash
   # Create namespace
   $ kubectl create ns camel-k

   # Add Helm repo
   $ helm repo add camel-k https://apache.github.io/camel-k/charts/

   # Install operator
   $ helm install camel-k camel-k/camel-k -n camel-k

   # Check if operator is running
   $ kubectl get pods -n camel-k
   ```

2. Enable registry of minikube

   ```bash
   # Enable registry
   $ minikube addons enable registry

   # Check registry is working (Port is given in previous step)
   $ curl http://localhost:32790/v2/_catalog

   # Get the internal IP of the registry and include it in the itp.yaml
   $ kubectl -n kube-system get service registry -o jsonpath='{.spec.clusterIP}'
   ```

3. Setup the Integration Platform and Registry

   ```bash
   # Apply the conf/itp.yaml file
   $ kubectl apply -f ./conf/itp.yaml -n camel-k

   # Verify the IntegrationPlatform is in Ready status
   $ kubectl get itp
   ```

### Deploy routes using Camel K

1. Download and install **kamel** application from [here](https://github.com/apache/camel-k/releases). On Mac OS you can do:

   ```bash
   # Install kamel using brew
   $ brew install kamel
   
   # Check installation
   $ kamel version
   ```

2. Deploy, check, and delete timer route

   ```bash
   # Deploy timer route
   kamel -n camel-k run --name timer-routes ./routes/timer-routes.camel.yaml

   # Query routes
   kamel -n camel-k get

   # Query logs
   kamel -n camel-k log timer-routes

   # Delete 
   kamel -n camel-k delete timer-routes
   ```

3. Deploy, check, and delete two dependent routes

   ```bash
   # Deploy multiple routes
   kamel -n camel-k run --name rest-routes ./routes/direct-routes.camel.yaml ./routes/rest-routes.camel.yaml

   # Query logs
   kamel -n camel-k log rest-routes

   # Delete 
   kamel -n camel-k delete rest-routes   
   ```

### Insights

- Query the logs of operator pod to find errors.
- **kamel run** command must use a namespace which has a Camel K operator deployed.
- If **kamel log <route>** table does not have information, the deployment failed.
