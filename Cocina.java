import java.util.ArrayList;

// Aca puse mal: le puse extends Orden, pero la cocina no es una orden sino que las procesa
public class Cocina {

    // Aca puse mal: invente el tipo orden_pendientes, asi va: ArrayList<Orden>
    private ArrayList<Orden> listaOrdenes;

    // Aca puse mal: le puse orden_pendientes al constructor, debe llamarse Cocina()
    public Cocina() {
        this.listaOrdenes = new ArrayList<>();
    }

    // Aca me falto: ponerle tipo boolean y recibir la variable tipo Orden
    public boolean verificarOrden(Orden orden) {
        return orden != null && !orden.estaVacia();
    }

    public String recibirOrden(Orden orden) {
        System.out.println("La cocina recibe la orden " + orden.getNumeroOrden() + "...");
        if (verificarOrden(orden)) {
            listaOrdenes.add(orden);
            String msg = "Orden " + orden.getNumeroOrden() + " verificada con exito.";
            System.out.println(msg);
            return msg;
        } else {
            String msg = "Error: La orden esta vacia o no es valida.";
            System.out.println(msg);
            return msg;
        }
    }

    public String cocinarOrdenes() {
        if (listaOrdenes.isEmpty()) {
            String msg = "No hay ordenes para cocinar.";
            System.out.println(msg);
            return msg;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Cocinando en el horno:\n");
        for (Orden orden : listaOrdenes) {
            sb.append("\nPreparando orden ").append(orden.getNumeroOrden()).append(":\n");
            for (Pizza pizza : orden.getPizzas()) {
                sb.append("  Horneando ").append(pizza.getCantidad()).append(" pizza(s) con base ") 
                    .append(pizza.getTipoBase()).append(", salsa ").append(pizza.getSalsa()) 
                    .append(" y ").append(pizza.getToppings()).append("...\n");
            }
            sb.append("  Orden ").append(orden.getNumeroOrden()).append(" lista para entregar.\n");
        }
        listaOrdenes.clear();
        sb.append("\nTodas las ordenes listas.");

        String resultado = sb.toString();
        System.out.println(resultado);
        return resultado;
    }
}
