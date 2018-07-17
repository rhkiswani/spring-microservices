## Atms Loader

Small application based on Java micro services that loads all the ING atms in netherlands and show them in web format.


### Project Structure

- Parent project: a common parent for all the modules. it extends spring boot parent 
- Core module : it's the common module used by other modules where it has the common entities, services, repos  
- Loader Module : mainly acting a feeding micro service where it fetch the data from the ING web service, then transform it into relation form and store in local database
- Web Module : UI micro service
- Deployment : mainly for CI

### Prerequisite 

- Java
- Maven 
- MySql database 
- Docker

### Dev getting Started

- Clone the repo 
- Create new database called atms on your local 
- Go to `web/src/main/resources/application.properties`
- modify the below configurations to have your local database configurations 

```ruby
spring.datasource.url=jdbc:mysql://localhost:3306/atms
spring.datasource.username=
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
```
- Go to `loader/src/main/resources/application.properties`
- modify the below configurations to have your local database configurations 

```ruby
spring.datasource.url=jdbc:mysql://localhost:3306/atms
spring.datasource.username=
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
```

- Run `com.rhkiswani.backbasetask.loader.LoaderApp`
- Run `com.rhkiswani.backbasetask.web.WebApp`
- Open the browser on `http://localhost:8081`
- Username: admin
- Password : admin

### Hints

ING atms web service is secured by https so u might need to install the certificate
##### install SSL certificates 
- go to `deployment/`
- run `install_certs.sh`
- Please note that the `install_certs.sh` assums that you have `JAVA_HOME` define on the path

### Deployment

##### deploy the images
- go to `deployment/scripts`
- run `build.sh` which will build all the modules and create docker images for them
- run `run.sh`

##### Clean the env and stop the running services
- go to `deployment/scripts`
- run `clean.sh`

### TODO
- Unit tests 
- Implement forntend with react
- setup with `maven checkstyle plugin`
- setup with `maven pmd plugin`
- setup `maven release plugin`
- integrate with nexus to publish the artifacts
- remove the UI work from `index.jsp` and use the dist from the frontend folder
 

### Contact
- rhkiswani@gmail.com

