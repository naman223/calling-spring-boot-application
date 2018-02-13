This one is going to call another spring-boot-application

mvn clean install

curl  http://localhost:8087

curl -X POST http://localhost:8087/emp

curl  http://localhost:8087/callone

