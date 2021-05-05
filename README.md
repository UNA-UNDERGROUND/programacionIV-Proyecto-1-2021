# Proyecto I - Programacion IV (2021)

## Sistema de cursos online

la base de datos se conecta con las credenciales proporcionadas en su archivo de manifiesto, localizado en

```
/source/src/java/db.properties

📦source
 ┗📂src
  ┗ 📂java
    ┗ 📜db.properties
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

Finalmente el Proyecto usa ant y incluye las dependencias requeridas en la carpeta source/Librerias JAR
