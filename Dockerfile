FROM openjdk:17-jdk

WORKDIR /app

COPY . .

RUN javac *.java

CMD ["java", "BookServer"]