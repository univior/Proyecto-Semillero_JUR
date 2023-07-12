# Proyecto-Semillero_JUR

# EJECUCION DE PROYECTO

Para ejecutar el proyecto se debera ejecutar la siguiente clase:
/Users/junivio/Documents/Proyecto Automatizacion 2/Proyecto-Semillero_JUR/src/test/java/com/lulobank/runners/ExecuteServices.java

##  
Link parent/root build.gradle as gradle project. You will only need to create a gradle Run/Debug configuration to add the class runner.

## Running tests in Gradle verify phase
Install the parent build.gradle file
(can also be done in IntelliJ UI - Execute gradle Goal)

    brew install gradle

## Add environment variables to your shell or Run/Debug configuration
Ask your QA lead for the credentials / env variables required to run the tests.


#Create an image and run it using DOCKER
You can create an image of this project to run it with Docker.
To do so, you just need to follow next exteps:

To build
```
docker build \
. -t e2e-test
```

Go to the docker image to run the project

```
docker run \
-it \
--rm \
-t \
-e AWS_ACCESS_KEY_ID=${AWS_ACCESS_KEY_ID} \
-e AWS_SECRET_ACCESS_KEY=${AWS_SECRET_ACCESS_KEY} \
-e AWS_SESSION_TOKEN=${AWS_SESSION_TOKEN} \
-e LULO_API_BASIC_USERNAME=${LULO_API_BASIC_USERNAME} \
-e LULO_API_BASIC_PASSWORD=${LULO_API_BASIC_PASSWORD} \
-e ADOTECH_API_TOKEN=${ADOTECH_API_TOKEN} \
-e ZENDESK_KEY=${ZENDESK_KEY} \
-e AWS_REGION=${AWS_REGION} \
-e DENV="qa" \
-e PLATFORM="backend" \
e2e-test
```