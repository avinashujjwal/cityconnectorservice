##CityConnectorService

CityConnectorService which determines if two cities are connected using Breadth First Search (BFS) graph traversal method. Two cities are considered connected if there’s a series of roads that can be traveled from one city to another.

Assumption : Comma will not appear within city names in the file. For example, "Washington, D.C."

#####HOW TO RUN THE SERVICE
Run the Application.java to start the service using Tomcat WebServer on default port # 8080

The Swagger UI-generated documentation URL: http://localhost:8080/swagger-ui.html

By default server error white label page enable is true and can be turned off in application.properties by providing the value as false for the below property.

server.error.whitelabel.enabled=false

#####CODE CHALLENGE

Write a program in java to determines if two cities are connected.

Two cities are considered connected if there’s a series of roads that can be traveled from one city to another.

List of roads is available in a file (citi.txt).

File contains a list of city pairs (one pair per line, comma separated), which indicates that there’s a road between those cities.

It will be deployed as a spring-boot app and expose one endpoint:

http://localhost:8080/connected?origin=city1&destination=city2

The program should respond with "Yes", if city1 is connected to city2, "No", if city1 is not connected to city2.

Any unexpected input should result in a "No" response.


Example:

city.txt content is:

Boston, New York

Philadelphia, Newark

Newark, Boston

Trenton, Albany


#####SAMPLE TEST CASES
~~~~~~~
http://localhost:8080/connected?origin=Boston&destination=Newark

Should return "Yes"

http://localhost:8080/connected?origin=Boston&destination=Philadelphia

Should return "Yes"

http://localhost:8080/connected?origin=Philadelphia&destination=Albany

Should return "No"
