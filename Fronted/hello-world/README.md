# SoccerLeagues FRONTEND

**Pasos para configurar el fronted**


**1)** Descargar la carpeta Fronted de este repositorio

**2)** Navegar hasta la ruta de la carpeta Fronted, **cd ~/User/Downloads/Fronted/hello-world**, posiblemente la ruta puede cambiar dependiendo de donde se haya puesto la carpeta descargada.

**3)** Cuando se esté dentro de esta carpeta se corre el comando **npm start**

**4)** Esperar a que suba el proyecto, para probar los endpoints con el fronted.

**5)** Si no hay problema, el navegador se abrirá automáticamente con la vista de editar un equipo por defecto.

**6)** Si se quiere cambiar de vista, se tiene abrir el archivo **hello-world** en un editor de texto y después de esto, hay que ir hasta el archivo **index.js** y comentar la línea **import EditarEquipo from './EditarEquipo';** y poner la vista que se quiere mostrar.

**7)** Luego de esto en estas lineas de código, cambiar **EditarEquipo** por la vista que se cambió anteriormente

```
ReactDOM.render(
  <EditarEquipo/>,
  document.getElementById('root')
);
```
