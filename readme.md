#Running and deployment guide

#spring boot run to include build info
mvn clean install spring-boot:run

#docker google plugin to generate and upload docker image on docker hub
docker login
mvn compile jib:build 

#run in container

docker network create micro 

docker run -d --name elasticsearch --net micro -p 9200:9200 -p9300:9300 -e "discovery.type=single-node" elasticsearch:7.8.0

docker run -d --name logstash --net micro -p 5000:5000 -v ~/developments/docker-images/configs/logstash.conf:/usr/share/logstash/pipeline/logstash.conf docker.elastic.co/logstash/logstash:7.8.0

docker run -d —-name kibana --net micro -e “ELASTICSEARCH_URL=http://elasticsearch.micro:9200” -p 5601:5601 docker.elastic.co/kibana/kibana:7.8.0

docker run -d --name intro --net micro -p 8080:8080 faisaldev79/intro-to-spring-boot:latest