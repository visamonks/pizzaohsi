import java.util.ArrayList;

// Aca tenia mal: tenias 'extends Orden', pero la cocina no es una orden, solo las procesa
public class Cocina {

    // Aca tenia mal: pusiste 'orden_pendientes', ese tipo no existe, asi va: ArrayList<Orden>
    private ArrayList<Orden> listaOrdenes;

    // Aca tenia mal: el constructor se llama Cocina(), no 'orden_pendientes'
    public Cocina() {
        this.listaOrdenes = new ArrayList<>();
    }

    // Aca tenia mal: faltaba el tipo boolean y recibir un objeto tipo Orden
    public boolean verificarOrden(Orden orden) {
        return orden != null && !orden.estaVacia();
    }

    // Recibe y valida la orden
    public void recibirOrden(Orden orden) {
        System.out.println("[COCINA] Recibiendo Orden #" + orden.getNumeroOrden() + "...");
        if (verificarOrden(orden)) {
            listaOrdenes.add(orden);
            System.out.println("[COCINA] Orden #" + orden.getNumeroOrden() + " verificada con exito!");
        } else {
            System.out.println("[COCINA] Error: La orden esta vacia o es invalida.");
        }
    }

    // Muestra en la terminal el progreso de cocción
    public void cocinarOrdenes() {
        System.out.println("\nCOCINANDO EN EL HORNO:");
        if (listaOrdenes.isEmpty()) {
            System.out.println("No hay ordenes para cocinar.");
            return;
        }

        for (Orden orden : listaOrdenes) {
            System.out.println("\n>> Preparando Orden #" + orden.getNumeroOrden() + ":");
            for (Pizza pizza : orden.getPizzas()) {
                System.out.println("   -> Horneando " + pizza.getCantidad() + " pizza(s) con base " 
                    + pizza.getTipoBase() + ", salsa " + pizza.getSalsa() 
                    + " y " + pizza.getToppings());
            }
            System.out.println("   [OK] Orden #" + orden.getNumeroOrden() + " lista!");
        }
        listaOrdenes.clear();
        System.out.println("\n[COCINA] Todo despachado.");
    }
}
