#!/usr/bin/env bash

kubectl --kubeconfig=$KUBECTL_CONFIG_FILE apply -f inventory-service.yaml
