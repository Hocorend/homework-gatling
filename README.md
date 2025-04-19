# Realtime monitoring
```shell
docker compose -f conf/docker-compose.yml up -d
```

Open http://localhost:3000


## 1. Gatling

```shell
sbt "Gatling/testOnly *.Debug"
sbt "Gatling/testOnly *.Stability"
sbt "Gatling/testOnly *.MaxPerformance"
```

