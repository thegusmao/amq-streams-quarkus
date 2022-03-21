# amq-stream-quickstart Project

## Objetivo 

Essa aplicação é uma demonstração para validar a comunicação com um broker AMQ Streams no Openshift.

## Estrutura

**PingProducer**: Classe que envia uma mensagem periodicamente para o tópico Kafka, as configurações estão no properties com o formato `mp.messaging.outgoing.<CHANNEL-OUT>.*`

**PongConsumer**: Classe que recebe as mensagens do tópico Kafka, as configurações estão no properties com o formato `mp.messaging.incoming.<CHANNEL>.*`

**GreetingResource**: Classe que já vem ao gerar o projeto no https://code.quarkus.redhat.com/, serve pra validar se a aplicação tá funcionando.

## Deploy no Openshift

Para realizar o deploy vamos utilizar o helm disponível para Quarkus em:
https://github.com/redhat-developer/redhat-helm-charts/tree/master/alpha/quarkus-chart

### Adicionar repositório com alguns Charts helm

```sh
#Adicionar o repo de charts da Red Hat (https://github.com/redhat-developer/redhat-helm-charts)
helm repo add redhat-charts https://redhat-developer.github.io/redhat-helm-charts
```

### Implantar a aplicação no Openshift (executar o helm)

Editar o quarkus-helm-values.yaml que se encontra na raiz do projeto
Alterar os textos: `<REPOSITORIO GIT>`, `<CHANNEL>`,`<TOPICO>`,`<CHANNEL-OUT>`

```sh
#Para testar antes de enviar para o Openshift
helm install -f quarkus-helm-values.yaml quarkus redhat-charts/quarkus --dry-run --debug 

#Para instalar de fato (precisa estar logado no OCP)
helm install -f quarkus-helm-values.yaml quarkus redhat-charts/quarkus
```
