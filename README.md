# SGC-DOCS

Pagina web interna del SGC

El objetivo de la página es centralizar la información del Sistema de Gestion de Calidad para todo el departamento, siendo accesible solo en red local. Se comparte:

- Registros de control de documentacion, tareas y personal responsable (Documentacion Emitida)
- Formularios, manuales y procedimientos propios del Departamento (Home)
- Documentación relevante de clientes (Docs clientes)

La página se ejecuta en una PC que se utiliza como file-server y la generacion de vínculos se realiza con JAVA Spring (lee archivos de cada directorio y los pone disponibles como recurso) y JS (GET a controlador para leer listado de archivos y genera los vínculos en el DOM). Como características especiales:

- Acceso con Spring Security (Tabla de usuarios en DB)

- DB en MSSQL (de )usuarios y tablas de registros varios de documentacion) 

- Consulta a datos en MSSQL a través de API y visualización de la consulta en tabla con JS 
(Nota: como en el SGC somos 3 personas que podemos dar mantenimiento y cada uno está cursando codo a codo con diferentes lenguajes, la actualizacion dinamica de las paginas las implemente con javascript)

- Se generan listados de archivos para descargar (en las distintas vista) leyendo una ruta externa del programa para simplificar la actualizacion de los archivos (con copiar o borrar del directorio no hay que actualizar las ubicaciones)

TODO:
- Reestructurar proyecto y eliminar comentarios y salidas de consola
- Filtrar paginas de administrador por rol (actualmente no hay link, los usuarios con rol de admin son redirigidos despues de loguearse)
- Encriptar contraseñas en la DB
