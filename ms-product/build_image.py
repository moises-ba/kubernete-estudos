#!/usr/bin/env/ python


import os, sys

script_path = os.path.dirname(os.path.realpath(__file__))

def execute(shell_command):
  return os.system('cd ' + script_path + ' && ' + shell_command)


print('Buildando...')
execute('mvn clean package -DskipTests')


image = 'moisesba/ms-product:0.0.1' 

#print('Setando o ambiente do docker pada o minikube...')
#execute('eval $(minikube docker-env)')


#print('Gerando imagem...')
#execute('eval $(minikube docker-env) && docker image rm -f ' + image)
#execute('eval $(minikube docker-env) &&  docker build -t ' + image + ' . ')
execute('docker image rm -f ' + image)
execute('docker build -t ' + image + ' . ')


#print('Voltando o ambiente do docker pada o host local...')
#execute('eval $(minikube docker-env -u)')
