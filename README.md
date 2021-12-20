# FeatureFlagService

*Requirements to run the application:
- Java 11
- Gradle (I used 7.2)
- Junit 5
- Postman or other means to send the requests to the service

* The current version is only at a POC level of detail and it contains the following functionalities:
- able to create a feature which defaults to disabled
- able to switch on and off a feature for a user 
- able to get all the enabled features (a mix of all the globally enabled ones and the ones enabled just for my user)

* Testing
- Manual testing
- Included REST calls collection in /postman/FeatureFlagService.postman_collection.json

Given the time constraint I decided to implement something that works and can be reviewed.
Future improvements include:
- unit & integration tests (added just a few scenarios due to time limitation)
- add Spring Security for admin/user endpoints
- add Swagger for endpoint descriptions
- add certificates for HTTPS
- add a minimal frontend for easier testing and interaction with the service
- further improve the application overall thinking of different use cases that might be useful