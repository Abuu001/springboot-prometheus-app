
list all exposed endpoint http://localhost:8080/actuator

### To start prometheus and grafana
1. cd to docker folder
2. run in terminal `docker-compose up`


## To access prometheus on browser
http://localhost:9090/

## To access grafana dashboard on browser
http://localhost:3000/


## when setting up prometheus datasource
1. set the url to http://prometheus:9090


## exposed app endpoint
http://localhost:8080/customMetric


## Configuring prometheus.yml 
Exec into the .yml  `cd /etc/prometheus/`
`vi prometheus.yml`