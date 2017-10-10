# cs504_HW1
Bittiger CS504 Homework 1
1. Run docker-compose.yml to link with MySQL
2. Run mvn clean install in the main folder (cs504_HW1)
3. Go to /target, run java -jar running-information-analysis-service-1.0.0.BUILD-SNAPSHOT.jar
4. Open Postman via Google Chrome
5. Enter http://localhost:8080/running, select "POST"
6. Select "Body" -> "raw"
7. Copy Json data into the blank box
8. Click "Send" nears the url which was entered in step 5
9. Change "POST" to "GET"
10. Enter http://localhost:8080/running/?page=n&size=m, n,m are integers to control the page and the number of outputs
11. Click Send
