#!/usr/bin/env bash
set -e
docker login -u mic-alm_ww@oracle.com -p Muall2015 mic2.docker.oraclecorp.com
docker build -t mic2.docker.oraclecorp.com/zipkin-service-two:1.0 .
#   docker push mic2.docker.oraclecorp.com/zipkin-service-two:1.0
