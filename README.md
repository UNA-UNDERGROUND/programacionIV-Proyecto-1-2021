# Proyecto I - Programacion IV (2021)

## Sistema de cursos online

la base de datos se conecta con las credenciales proporcionadas en su archivo de manifiesto, localizado en

```
/source/src/main/resources/configuraciones/credenciales-bd.properties

📦backend
 ┣ 📂src
 ┃ ┣ 📂main
 ┃ ┃ ┣ 📂java
 ┃ ┃ ┗ 📂resources
 ┃ ┃ ┃ ┗ 📂configuraciones
 ┃ ┃ ┃ ┃ ┗ 📜credenciales-bd.properties
 ┃ ┗ 📂test
 ┣ 📜.gitignore
 ┣ 📜nbactions.xml
 ┗ 📜pom.xml
```

puede modificarse este archivo para usar las credenciales correctas, o agregar
el usuario requerido mediante 

```sql
CREATE USER 'admin'@'%' IDENTIFIED BY 'changeme';
```

y otorgarle permisos

```sql
GRANT ALL PRIVILEGES ON eif209_2021_01.* TO 'admin'@'%';
```

## dependencias del proyecto

Finalmente el Proyecto usa maven por lo que el solo genera su lista de
dependencias y las agrega, las dependencias son las siguientes en caso de ser requeridas

- mysql-connector-java-8.0.18.jar  (Driver JDBC)
- protobuf-java-3.6.1.jar          (Requerido por JDBC)
- javaee-api-8.0.jar               (requerido por los jsp y servlets)
