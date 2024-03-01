
### Tras finalizarr el proyecto, responde de forma concisa (máximo 1 párrafo) y clara a las siguientes preguntas que te darán indicios de  tu grado de entendimiento del patrón Strategy

- ¿Cuáles son las estrategias?
    Las estrategias son cada una de las clases que implementan la interface "Ataque", es decir, AtaqueCuchillo, AtaqueEspada, AtaqueArco.

- ¿Está el código de las diferentes ataques  mezclado?¿El código del ataque con espada es independiente del código del ataque con arco?  .Relaciona esto con algún principio SOLID.
    No, cada estrategia es independiente y tiene su propio código. 
    Esto se relaciona con dos principios SOLID. 
    El primero, el Principio de Responsabilidad Única. Cada clase tiene su función: restar un determinado valor a la vida del oponente. 
    También cumple el principio de Abierto/Cerrado. Abiertas a extensión y cerradas a modificación. Ya que permite introducir nuevas clases que implementen nuevos ataques sin modificar el código existente.

- ¿Para que vale la interface Ataque?
    Sirve como "seguro" de que las clases que la hereden deberán implementar el método lanzaAtaque obligatoriamente. 

- ¿Qué clase o clase se encarga del papel de contexto?
    El contexto es la clase Personaje, que incorpora un método setAtaque así como otro método ataque que lo utiliza.

- ¿En que se parece y  en que se diferencia el  contexto de tu proyecto al contexto del Patrón teórico del boletín?
    Se diferencian en que el ejemplo del boletín pasa la estrategia por constructor y en mi caso no es así. Podría haberlo hecho, un constructor para Personaje con dos parámetros uno el nombre y otro para el Ataque, pero creo que iba en contra de la práctica no usar el método setAtaque. 

- ¿Quién es el Cliente?
    El cliente es la clase DDapp, o más bien, la clase ControlLucha incluida en ella.

- ¿Como cambia el cliente de  estrategia?
    Utilizando los métodos setAtaque. (Ejemplo: ejercito_troll[i].setAtaque(new AtaqueEspada()))

- ¿Para cambiar de estrategia, tiene que conocer el cliente detalles de implementación de la estrategia?
    No es necesario, le basta con saber que el método ataca utiliza una estrategia definida en el Personaje de tipo Ataque.

- ¿Si creamos un nuevo tipo de ataque para un nuevo cliente, por ejemplo App2,  es
necesario modificar el cliente antiguo? Relaciona esto con algún principio SOLID.
    Como dije anteriormente, gracias al principio de Responsabilidad Única, es posible extender las funcionalidades en una nnueva App sin necesidad de modificar el código previo. Bastaría con crear una nueva clase que implementase Ataque.

