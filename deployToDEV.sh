#!/usr/bin/env bash

kubectl --kubeconfig=$KUBECTL_CONFIG_FILE delete -f inventory-service.yaml
sleep 10
kubectl --kubeconfig=$KUBECTL_CONFIG_FILE create -f inventory-service.yaml
