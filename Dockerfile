# Imagen base con Maven y JDK 17
FROM maven:3.8.6-eclipse-temurin-17 AS build

# Establecer directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el código fuente al contenedor
COPY . .

# Compilar el código sin empaquetar
RUN mvn clean compile

# Segunda etapa: Imagen final con JDK 17 para ejecución
FROM eclipse-temurin:17-jre

# Establecer directorio de trabajo
WORKDIR /app

# Copiar el código compilado de la imagen anterior
COPY --from=build /app /app

# Exponer el puerto donde corre la aplicación
EXPOSE 8080

# Ejecutar la aplicación con Maven
CMD ["mvn", "spring-boot:run"]
