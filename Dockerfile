# FROM anapsix/alpine-java:8_server-jre_unlimited
FROM openjdk:8-jre-alpine
ARG DEPENDENCY
COPY ${DEPENDENCY}/BOOT-INF/lib2 /app/lib
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/org /app/org
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT java -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XX:MaxRAMFraction=1 -XshowSettings:vm -Djava.security.egd=file:/dev/./urandom -Dspring.jmx.enabled=false -noverify -XX:TieredStopAtLevel=1 -cp app:app/lib/*  org.springframework.boot.loader.JarLauncher
