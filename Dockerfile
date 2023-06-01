FROM registry-1.i-city.brucity.be/eclipse-temurin:11-jre-alpine
RUN apk --no-cache --update-cache add bash curl
RUN addgroup -g 1000 -S appuser && adduser -u 1000 -S appuser -G appuser
COPY target/*.jar /home/appuser/app.jar
RUN chown -R appuser:appuser /home/appuser/app.jar
EXPOSE 8080
CMD ["java","-jar", "/home/appuser/app.jar"]