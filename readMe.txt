
To build:
mvn clean package

To start the app:
java -jar target/phrasefinder-1.0-SNAPSHOT.jar server config.yaml

To check the app:
I ran the POSTMAN extension on Chrome.

1. Make a GET request by calling:

http://localhost:8080/phrase/100

and selecting GET from the dropdown

Click Send to submit the GET request


2. Make a POST request by calling:

http://localhost:8080/phrase

Set the x-www-form-urlencoded data:

Set key to: phrase
Set value to: Live long and prosper

Since the POST request expects Authentication which GET doesn't 
(look at the isAuthenticated param in the entry points in PhraseResource.java)
you will need to provide Basic Authentication.

Select the Basic Auth tab (at the very top):

Set username to: star
Set password to: trek

Click Refresh Headers.

Click Send to submit the POST request

