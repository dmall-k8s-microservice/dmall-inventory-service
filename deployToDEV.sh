#!/usr/bin/env bash

JENKINS_DOCKER_IMAGE=$DMALL_DOCKER_REGISTRY/$SLUG/inventory-service:$BUILD_NUMBER
sed -i -e "s|image: .*|image: ${JENKINS_DOCKER_IMAGE}|g" inventory-service.yaml

kubectl --kubeconfig=$KUBECTL_CONFIG_FILE apply -f inventory-service.yaml