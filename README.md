## PetService
This is a pet project to define a simple backend API, which aims to support my future front-end studies =)

### OpenAPI

To generate the API from the .yml description file (located inside the main/resources dir), run the gradle task *openApiGenerate*

Once the auto generated base API classes are generated, the API should not indicate code errors due to missing auto generated base files.

### Running with Docker
First it is necessary to build the project and generate the jar file. Run:

    $ ./gradlew build

The file will be created inside the directory called ./build/libs. An alternative is to run the Gradle Build task from
IntelliJ (or your preferred) IDE.

Now that we have the jar file, it is possible to build and run the docker application using the Dockerfile. Run:

    $ docker build -t petservice .
    $ docker run -d -p 8080:8080 --name petservice petservice

## Mongo container

Mongo container requires a directory _mongodb inside the root folder of the repository to run (is its volume).

### Cat image generation

Using thecatapi to get random cat images :)

https://api.thecatapi.com/v1/images/search  
https://docs.thecatapi.com/
