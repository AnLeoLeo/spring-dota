#!/bin/bash

while [ true ]; do
    curl -s -I "http://localhost:8080/api/tactics/2" | grep HTTP
done