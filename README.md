# jubilant-octo-guacamole
Take home project

Install postgres https://www.postgresql.org/download/

After installing postgres create a user for the postgres server and set a username and password

login as the created user and use postgres to create database called: cameraiq

edit application.yml in main/resources with postgres username and password you've set

Run below command in a bash terminal in src directory:
./mvnw package && java -jar target/ciRestAPI-0.0.1-SNAPSHOT.jar

Now the server should be running in your localhost:8080

the folowing endpoints exist are used to manipualte the database:
GET:

http://localhost:8080/getAllUsers

http://localhost:8080/getAllOrganizationsForUser?userId=1

POST:
http://localhost:8080/createUser?firstName=f&lastName=T&address=temp&email=thon0045&phone=6124685

http://localhost:8080/createOrganization?name=f&address=orgaddress&phone=6124685

http://localhost:8080/addUserToOrganization?userId=1&organizationId=1

http://localhost:8080/deleteUserFromOrganization?userId=1&organizationId=1

Recommend using some type of Rest Client to test the endpoints.
I used Advance Rest Client which is a chrome app extension. 


Note: Web app server will create tables on start up and drop all tables on shutdown