# Spring boot example app 
Sample app using Spring-boot stack with Hibernate and MySQL. 
Based on jpa, jetty and freemarker samples at 4444

## Development
* Build and test
~~~bash
mvn package
~~~
* Start local server

~~~bash
export PORT=8080
export MYSQLS_HOSTNAME=...
export MYSQLS_PORT=...
export MYSQLS_DATABASE=...
export MYSQLS_USERNAME=...
export MYSQLS_PASSWORD=...
java -jar target/spring-boot-example-app-*.jar
~~~

## Deploy on cloudControl

###Defining the process type
CloudControl uses a Procfile to know how to start your process. Create a file called Procfile:
~~~
web: java -jar target/spring-boot-example-app-*.jar
~~~

## Pushing and deploying your app

Choose a unique name (from now on called APP_NAME) for your application and
create it on the cloudControl platform:
~~~bash
$ cctrlapp APP_NAME create java
~~~

Push your code to the application's repository. This will create a deployment image:
~~~
$ cctrlapp APP_NAME/default push
~~~

Add MySQLs Add-on:

~~~bash
$ cctrlapp APP_NAME/default addon.add mysqls.free
~~~

Deploy your app :
 
~~~bash
$ cctrlapp APP_NAME/default deploy --memory 768MB
~~~
The --memory=768MB argument increases the container size to meet the high memory consumption of the Spring framework. Please note: increasing the size comes with additional costs.

**Congratulations, you should now be able to reach your application at http://APP_NAME.cloudcontrolled.com.**

