import java.util.ArrayList;

// Aca puse mal: le puse extends Pizza, pero una orden no es una pizza sino que contiene pizzas
public class Orden {

    private int numeroOrden;

    // Aca me falto: no cree una lista para guardar las pizzas, asi va con ArrayList
    private ArrayList<Pizza> listaPizzas;

    // Aca puse mal: le habia puesto de nombre pizza, el constructor debe llamarse Orden
    public Orden(int numeroOrden) {
        this.numeroOrden = numeroOrden;
        this.listaPizzas = new ArrayList<>();
    }

    public Orden() {
        this(1);
    }

    // Aca me falto: no le puse tipo de retorno void y Pizza va con mayuscula
    public void agregarPizza(Pizza pizza) {
        this.listaPizzas.add(pizza);
    }

    // Aca puse mal: me faltaba void, arreglar los tipos y llamar a new Pizza con mayuscula
    public void crearPizza(String tipoBase, Tipo_salsa salsa, Toppings toppings, int cantidad) {
        Pizza pizza = new Pizza(tipoBase, salsa, toppings, cantidad);
        this.agregarPizza(pizza);
    }

    // Aca me falto: ponerle tipo de retorno String y ponerlo public para mostrar la orden
    public String getOrden() {
        if (listaPizzas.isEmpty()) {
            return "Orden " + numeroOrden + ": (Vacia)";
        }
        String texto = "Detalle de la orden " + numeroOrden + ":\n";
        for (Pizza p : listaPizzas) {
            texto += "  * " + p + "\n";
        }
        return texto;
    }

    public double calcularTotal() {
        double total = 0;
        for (Pizza p : listaPizzas) {
            total += p.getTotal();
        }
        return total;
    }

    public String generarFactura() {
        if (listaPizzas.isEmpty()) {
            return "Orden " + numeroOrden + ": No hay pizzas para facturar.\n";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Factura de la orden ").append(numeroOrden).append(":\n");
        for (Pizza p : listaPizzas) {
            sb.append("  * ").append(p.toString()).append("\n");
        }
        sb.append("Total a pagar: Q").append(calcularTotal()).append("\n");
        return sb.toString();
    }

    public int getNumeroOrden() { return numeroOrden; }
    public ArrayList<Pizza> getPizzas() { return listaPizzas; }
    public boolean estaVacia() { return listaPizzas.isEmpty(); }
}
