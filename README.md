# Proyecto-Semillero_JUR


# PRESENTACION DE PROYECTO
El proyecto se desarrolla mediante la API https://developers.thecatapi.com, donde se utilizaron los principales verbos del API (POST, GET, DELETE), con el fin de hacer las correspondientes validaciones a las peticiones.
Dentro del proyecto se interactuo con las diferentes dependencias y/o herramientas:
* Gradle para gestión de librerías.
* Java.
* Serenity (última versión) con BDD Screenplay: https://github.com/serenity-bdd/serenity-core
* Cucumber (última versión) con Serenity.
* Serenity Rest con Serenity y Screenplay
* Hamcrest
* Patron de diseño Screenplay.

 
# EJECUCION DEL PROYECTO

* El proyecto se compone de 9 casos de prueba, que se estan ubicados dentro de la carpeta "features", a continuacion relaciono ubicacion:

    /Users/junivio/Documents/Proyecto Automatizacion 2/Proyecto-Semillero_JUR/src/test/resources/features/services.feature

* Dentro de nuestro directorio vamos a encontrar la carpeta: "runners" compuesta por la clase llamada "ExecuteServices"; en este espacio se podrá visualizar las configuraciones necesarias para ejecutar el feature.
  /Users/junivio/Documents/Proyecto Automatizacion 2/Proyecto-Semillero_JUR/src/test/java/com/lulobank/runners/ExecuteServices.java
  
El proyecto se podrá ejecutar en su totalidad bajo el siguiente tag:

    * tags = "@services"
ó de forma parcial bajo los siguientes tags:
* @GetImages
* @GetAnImage
* @PostCreateFavourite
* @GetImagesFavourites
* @PostUnHappy
* @DeleteFavourite

De igual manera contamos con la carpeta:"StepDefinition" compuesta por la clase llamada "ExecuteServicesStepDefinition"; alli se podrá visualizar el código de todos los Given, When y Then que componen el proyecto.
 
   /Users/junivio/Documents/Proyecto Automatizacion 2/Proyecto-Semillero_JUR/src/test/java/com/lulobank/stepdefinitions/ExecuteServicesStepDefinition.java

# MODULOS TRABAJADOS

Durante la automatizacion de los modulos trabajados se crearon las diferentes directorios compuestos por clases, las cuales nos ayudaban a manejar el desarrollo de la automatizacion de forma organizada, dentro de los directorios creados se encuentran los siguientes:

* tasks: Donde se encuentran los metodos (POST, GET, DELETE) creados como clases, esta clases creadas nos sirvieron para dar habilidades al actor para poder utilizar los diferentes metodos.
* questions: Nos permite realizar validaciones o verificaciones de las pruebas.
* factory: Nos permite generar data aleatoria.
* models: Nos permite encapsular en un objeto tipo registro el cuerpo o body a enviar para la petición POST
* exceptions: Nos permite dar manejo a errores que pueda presentarse en la api.

## OBTENCION DE IMAGENES

### Metodo GET
1. Bajo este modulo se trabajó el método GET donde por medio de la URL https://api.thecatapi.com/v1/images/search?limit=10 y la Api Key, se obtienen 10(diez) de imágenes aleatorias de gatos.
El response de este servicio ademas de entregarnos la URL de la imagen nos muestra información del ID, width y height, como se muestra a continuación:

{ "id": "34j", "url": "https://cdn2.thecatapi.com/images/34j.gif", "width": 245, "height": 138 }

El caso se puede ejecutar de forma individual en la siguiente ruta::

    /Users/junivio/Documents/Proyecto Automatizacion 2/Proyecto-Semillero_JUR/src/test/java/com/lulobank/runners/ExecuteServices.java

ingresando el siguiente Tag :
* tags = "@GetImages"


2. Bajo este modulo se trabajó el método GET, donde por medio de la URL https://api.thecatapi.com/v1/images/search, se obtiene la consulta de 1 (una) imágen aleatoria de gatos.
Este response ademas de la URL de la imagen nos muestra información del ID, width y height, como se muestra a continuación:

{"id": "a7i", "url": "https://cdn2.thecatapi.com/images/a7i.jpg", "width": 500, "height": 375}

El caso se puede ejecutar de forma individual en la siguiente ruta:

    /Users/junivio/Documents/Proyecto Automatizacion 2/Proyecto-Semillero_JUR/src/test/java/com/lulobank/runners/ExecuteServices.java

ingresando el siguiente Tag :
* tags = "@GetAnImage"

## FAVORITOS

### Metodo POST

Bajo este modulo se trabajó el método POST, donde por medio de la URL https://api.thecatapi.com/v1/favourites y la Api Key, permite que usuarios marquen como favorita una imagen.
Este caso se ejecuto mediante un escenario OutLine donde se tienen 4 imagenes como variables, para que unos usuarios creados de forma aleatoria las marquen como favoritas.

El response de este escenario nos arroja la siguiente información:
    { "message": "SUCCESS", "id": 232365084 }

El caso se puede ejecutar de forma individual en la siguiente ruta:
    
    /Users/junivio/Documents/Proyecto Automatizacion 2/Proyecto-Semillero_JUR/src/test/java/com/lulobank/runners/ExecuteServices.java

ingresando el siguiente Tag :
* tags = "@PostCreateFavourite"

### Metodo GET

Bajo este modulo se trabajó el método GET, donde por medio de la URL https://api.thecatapi.com/v1/favourites/:favourite_id y la Api Key, permite que el usuario por medio del id favourite, obtenga la información de la imagen, usuario, id usuario y al fecha en que se marco dicha imagen como favorita.
Este caso se ejecuta con imagenes marcadas con anterioridad como favoritas, donde por media de Faker se hace una seleccion aleatoria y se presenta el siguiente response:

{ "id": 232365209, "user_id": "tawdt0", "image_id": "9ccXTANkb14", "sub_id": "your-user-445", "created_at": "2023-07-13T03:55:35.000Z", "image": {
}
}

El caso se puede ejecutar de forma individual en la siguiente ruta:
    /Users/junivio/Documents/Proyecto Automatizacion 2/Proyecto-Semillero_JUR/src/test/java/com/lulobank/runners/ExecuteServices.java

ingresando el siguiente Tag :
* tags = "@GetImagesFavourites"

### Metodo POST - UnHappyPath
Bajo este modulo se trabajó el caso unhappypath con el método POST, donde por medio de la URL https://api.thecatapi.com/v1/favourites y la Api Key, permite hacer una doble peticion de favorita a una imagen.
Este caso se ejecuto mediante un escenario OutLine donde se tienen como variables el image_id, sub_id y el mensaje de error controlado "DUPLICATE_FAVOURITE - favourites are unique for account + image_id + sub_id".

El caso se puede ejecutar de forma individual en la siguiente ruta:
 
   /Users/junivio/Documents/Proyecto Automatizacion 2/Proyecto-Semillero_JUR/src/test/java/com/lulobank/runners/ExecuteServices.java

ingresando el siguiente Tag :
* tags = "@PostUnHappy"

### Metodo DELETE
Bajo este modulo se trabajó el método DELETE, donde por medio de la URL https://api.thecatapi.com/v1/favourites/:favourite_idy la Api Key, permite borrar una imagen marcada como favorita.
Este caso se ejecuta con imagenes marcadas con anterioridad como favoritas, donde por media de Faker se hace una seleccion aleatoria y se borra dicha imagen como favorita, obteniendo como response:
    { "message": "SUCCESS" }

El caso se puede ejecutar de forma individual en la siguiente ruta:

    /Users/junivio/Documents/Proyecto Automatizacion 2/Proyecto-Semillero_JUR/src/test/java/com/lulobank/runners/ExecuteServices.java

ingresando el siguiente Tag :
* tags = "@DeleteFavourite"

# RESULTADO DE EJECUCION

Con el fin de tener un reporte total ó parcial de la ejecucion automatizada del proyecto, se anexo la configuracion para crear un informe de Serenity Reports, donde se podrá visualizar los numeros de casos ejecutados con sus correspondientes estados, hora de inicio, hora de finalizacion, tiempo de duracion, entre otros.

# REPOSITORIO

El proyecto de automatizacion se encuentra ubicado en el repositorio de GitHub:
https://github.com/univior/Proyecto-Semillero_JUR
Dentro del repositorio se utilizaron las ramas main y feature.

