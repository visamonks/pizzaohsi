# Pizzeria Oh Si

Este proyecto simula la creacion de pizzas, armado de ordenes y su envio a la cocina para prepararlas, con interfaz grafica en Swing.

Errores que corregi:

En Main.java puse @interface por error en lugar de public class, me falto el metodo main para que el programa pudiera arrancar en la consola, y declare variables sin tipo.

En Pizza.java puse los tipos al reves como tipo_base str en vez de String tipoBase, y Cantidad int cuando int es palabra reservada y debia ser int cantidad. Ademas al constructor le puse void pizza con minuscula, cuando en Java se llama igual a la clase con mayuscula y no lleva tipo de retorno.

En Orden.java le habia puesto extends Pizza, pero una orden contiene pizzas y no es una pizza. Tambien me falto declarar la lista para guardar las pizzas con ArrayList, al constructor le puse pizza y debia llamarse Orden, y a los metodos les faltaban tipos de retorno como void o String.

En Cocina.java tambien le habia puesto extends Orden, pero la cocina solo procesa las ordenes. Reemplace orden_pendientes por un ArrayList de tipo Orden porque esa clase no existia, y le puse Cocina al constructor para que coincidiera con la clase.

Cuenta con una ventana grafica en VentanaPizza.java con opciones desplegables para base, salsa, topping y cantidad, ademas de botones para agregar pizza, mandar a cocina y un area de texto que va mostrando el registro en tiempo real.

Para compilar y guardar los archivos en la carpeta bin usamos javac -d bin *.java y para correr el programa usamos java -cp bin Main.
