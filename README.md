# Parcial práctico - Sección 2 - 202020

## Instrucciones

1. Haga un fork de este repositorio
2. Clone el repositorio bifurcado en su máquina virtual
3. Abra los proyectos en Netbeans
4. En Netbeans vaya a _Services > Databases > JavaDB_ y cree una base de datos que se llame _parcial1_ (los demás campos déjelos en blanco)
5. Lea el enunciado completamente antes de iniciar

## Punto 1 (30%). Persistencia

Esta aplicación tiene el propósito de crear un sistema de información para un consultorio médico.

(10%) Cree la entidad Medico en la carpeta correspondiente. Un Medico tiene un nombre, un apellido, un registro médico, una especilidad y un id de tipo _Long_ que representa su llave primaria.

(10%) Realice la implementación de la persistencia del Medico. La clase de persistencia debe tener por lo menos el método para crear un nuevo Medico.

(10%) Cree la prueba unitaria en la clase correspondiente, para el método **crear** un Medico, el cual valida si está correcta la implementación de la persistencia de la entidad.

Ejecute la prueba y valide que pasa correctamente.

## Punto 2 (40%). Lógica

Usted debe crear la lógica de la aplicación que cubra las reglas de negocio para la entidad _MedicoEntity_. Las reglas de negocio para **crear** un Medico son:

- No puede haber dos médicos con el mismo número de registro
- Los nombres y apellidos no pueden ser nulos o vacíos
- La especialidad debe tener más de 4 caracteres

(20%) Crear el método en la capa de lógica que valide las reglas de negocio y solicita persistir en caso que todas pasen (sólo para el método crear).

(20%) Crear al menos dos pruebas unitarias: una que valida el escenario ideal en el que todas las reglas de negocio se aprueban, y otra en la que valide cuando una regla de negocio falla. Si las reglas de negocio se cumplen, se debe llamar la persistencia para que el objeto sea persistido, de lo contrario debe lanzar una excepción _BusinessLogicException_ con un mensaje donde se especifique el problema.

## Punto 3 (20%). API

En la aplicación le hemos brindado parte de la capa REST API para probar. Para esto, en la clase _MedicoDTO_ usted debe:

(5%) Incluir los atributos correspondientes y un constructor vacío

(5%) Crear el método _toEntity_ que retorna un objeto _MedicoEntity_ con los datos del objeto _MedicoDTO_.

(5%) Agregue el método constructor que recibe un _MedicoEntity_ y hace el mapeo correspondiente entre ambas clases.

En la clase _MedicoResource_ usted debe:

(5%) Modificar el método _createMedico_ para que llame al método de la lógica que crea el médico, y retorne al usuario el nuevo médico creado.

## Punto 4 (10%). Pruebas de interación en Postman

Cree las siguientes pruebas de integración en una colección

### Creación correcta

```
Method: POST
URL: http://localhost:8080/s2_parcial1-api/api/medicos
Body:
{
	"nombre": "Juan Jose",
	"apellido": "Rodríguez Ortiz"
	"registroMedico": "FC3578K",
	"especialidad": "Anestesiología"
}
Response: 200
```

### Creación incorrecta: apellido vacío o nulo

```
Method: POST
URL: http://localhost:8080/s2_parcial1-api/api/medicos
Body:
{
	"nombre": "Juan Jose",
	"apellido": "",
	"registroMedico": "FC3578K",
	"especialidad": "Anestesiología"
}
Response: 412
"El médico tiene el apellido vacío o nulo"
```

## Entrega

1. Agregue los pantallazos de las pruebas de Postman a la carpeta _images_ de su repositorio

2. Exporte la coleccioń en la carpeta `s2_parcial1-api/collections`

3. Haga commit y push a la rama master

4. Cree un _release_ de su código con el nombre "Parcial1_2603".

5. Suba el archivo zip del release como respuesta a la actividad en SICUA
