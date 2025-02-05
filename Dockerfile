# Imagen base con Maven y JDK 17 para construir el proyecto
FROM maven:3.8.6-eclipse-temurin-17 AS build

# Establecer directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el código fuente al contenedor
COPY . .

# Compilar el código y empaquetarlo
RUN mvn clean package -DskipTests

# Segunda etapa: Imagen final con JDK 17 para ejecución
FROM eclipse-temurin:17-jre

# Establecer directorio de trabajo
WORKDIR /app

# Copiar el JAR generado en la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto donde corre la aplicación
EXPOSE 8080

# Ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]
