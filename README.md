# time-api
Example of microservice API


to run:
docker run -d -p 8080:8080 --name timeapi tsfreitas/timeapi

http://<docker-machine ip>:8080/timezone/<region>/<country/city>

ex.: http://localhost:8080/timezone/America/Sao_Paulo
