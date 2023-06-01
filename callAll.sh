#!/bin/bash
x=1
while [ $x -le 10 ]
do
  curl http://localhost:8080/demo/all/ | jq
  x=$(( $x + 1 ))
done
