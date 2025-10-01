# build
FROM eclipse-temurin:17-jdk-alpine as build
WORKDIR/workspace/app

# Maven
RUN apk add --no-cache maven

# build
COPY pom.xml .
COPY src src

# Compila o projeto
RUN mvn package -DskipTests

# Extrai dependências
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

 # Etapa de runtime
FROM eclipse-temurin:17-jre-alpine
VOLUME /tmp

ARG DEPENDENCY=/workspace/app/target/dependency

COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

# Entrada da aplicação
ENTRYPOINT ["java","-cp","app:app/lib/*","br.monitoramento.motu.ApiMottuApplication"]

# Usuário não-root para segurança
RUN addgroup -S spring && adduser -S spring -G spring USER spring