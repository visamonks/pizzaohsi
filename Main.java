// Aca tenia mal: pusiste '@interface', asi va con 'public class'
public class Main {

    // Aca tenia mal: faltaba el metodo main para poder correr el programa en la terminal
    public static void main(String[] args) {
        System.out.println("PIZZERIA OH SI\n");

        // Aca tenia mal: faltaba poner el tipo (Cocina) y adentro del metodo no se usa 'private'
        Cocina cocina = new Cocina();

        // Creamos la primera orden
        Orden orden1 = new Orden(1);
        System.out.println("[CLIENTE] Tomando orden #1...");
        orden1.crearPizza("Delgada", Tipo_salsa.PICANTE, Toppings.PEPPERONI, 2);
        orden1.crearPizza("Tradicional", Tipo_salsa.NORMAL, Toppings.JAMON, 1);

        // Mostramos la orden en la terminal
        System.out.println("\n" + orden1.getOrden());

        // La enviamos a la cocina
        cocina.recibirOrden(orden1);

        // Creamos una segunda orden de prueba
        Orden orden2 = new Orden(2);
        System.out.println("\n[CLIENTE] Tomando orden #2...");
        orden2.crearPizza("Gruesa", Tipo_salsa.HONGO, Toppings.CHILE, 1);
        System.out.println("\n" + orden2.getOrden());
        cocina.recibirOrden(orden2);

        // La cocina prepara todo
        cocina.cocinarOrdenes();

        System.out.println("\nFIN DEL PEDIDO");
    }
}
