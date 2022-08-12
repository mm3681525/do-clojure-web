# syntax=docker/dockerfile:1
FROM clojure:lein AS builder
COPY . /usr/src/app
WORKDIR /usr/src/app
RUN lein test
RUN lein uberjar

FROM openjdk:17-alpine
WORKDIR /usr/src/myapp
COPY --from=builder /usr/src/app/target/do-clojure-web-0.1.0-standalone.jar ./
CMD ["java", "-jar", "do-clojure-web-0.1.0-standalone.jar"]
