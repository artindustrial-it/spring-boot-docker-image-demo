#### Building efficient docker images for spring boot apps



Story:
  - intro:
    - Ist eine Lösung für ein Problem, das wir hatten, deswegen teilen wir's vielleicht hilft's jemandem
    - wir freuen uns über Rückmeldungen, speziell verbesserungen

  - spring boot apps are packed in a single fat jar
    - (explain: BOOT-INF / META-INF / Starter )
  - docker and spring boot apps are well suited for microservices in orchestrated environments (kubernetes)
    - (explain: docker works in layers, each with his own file system, ...)
  - conclusion: spring boot is not layer-friendly
  - story: we want to create docker-friendly images because:
    - less consumption of storage space in repo
    - image push and pull is much faster => downtime of services is much faster
  - Umgebung:
    - wir bauen mit Gradle
    - benutzen das docker-palantir plugin
    - mit Dockerfile  
  - Idee
    - Zerlegen in "stabilere" libraries und volatilen Applikations-Code
  - Umsetzung
    - Dockerfile durchgehen
    - Spring boot Starter
    - Problem: main class in start script => Lösung: dynamisches startup-Skript
    - Reihenfolge der Layers
    - Resultat: wieviele Layer, wie groß sind sie
    - Testen: wir ändern am Code etwas => bauen neu => welche Layer haben sich geändert wieviel müssen wir pushen
    - Erklärung: Java ist PID 1 - die kriegt alle signale - keine shell dazwischen
  - Weitere Verbesserungen:
    - startup-Zeit: urandom (provide links)
    - java 8: unlockexperimental features (provide links)
    - openjdk statt alpine/oracle   
    - java 11 statt java 8?
    - executable WAR vs. executable JAR (jsp unterschied)
  
https://docs.spring.io/spring-boot/docs/current/reference/html/executable-jar.html

weitere interessante Entwicklungen:
  - spring boot thin launcher: https://github.com/spring-projects-experimental/spring-boot-thin-launcher
  - a docker layer for every jar
  - multi-stage-build
  - https://github.com/spring-projects-experimental/spring-boot-thin-launcher/issues/25
  - docker prepare plugin: https://github.com/gclayburg/dockerPreparePlugin
  - startup optimization: https://dev.to/bufferings/lets-make-springboot-app-start-faster-k9m
