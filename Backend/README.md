# SoccerLeagues BACKEND

**Pasos para configurar el backend**

**1)** Descargar el archivo modelo_liga_futbol.mwb que se encuentra dentro de la carpeta Modelo.

**2)** Abrir el modelo con MySQLWorkbench y generar la base de datos a partir del modelo.

**3)** Cambiar el archivo presistence.xml que se encuetra en el directorio **SoccerLeagues/Backend/src/main/resources/META-INF/**

**)** Descargar la carpeta backend de este repositorio

**2)** Navegar hasta la ruta de la carpeta backend 
```
cd ~/User/Downloads/SoccerLeagues/Backend 
```
posiblemente la ruta puede cambiar dependiendo de donde se haya puesto la carpeta descargada.

**3)** Cuando se esté dentro de esta carpeta se corre el comando **mvn appdengine:devserver**

**4)** Esperar a que suba el proyecto, para probar los endpoints.

**5)** Poner en el navegador la ruta **localhost:8080/_ah/api/explorer** para probar los endpoints con el API de google.

**6)** O, también se puede probar los endpoints con Postman.
