import java.util.ArrayList;

// Aca tenia mal: tenias 'extends Pizza', pero una orden no es una pizza, sino que contiene pizzas
public class Orden {

    private int numeroOrden;

    // Aca tenia mal: faltaba una lista para guardar las pizzas, asi va con ArrayList
    private ArrayList<Pizza> listaPizzas;

    // Aca tenia mal: el constructor se llama igual que la clase (Orden, no 'pizza')
    public Orden(int numeroOrden) {
        this.numeroOrden = numeroOrden;
        this.listaPizzas = new ArrayList<>();
    }

    public Orden() {
        this(1);
    }

    // Aca tenia mal: faltaba el tipo de retorno 'void' y Pizza va con mayuscula
    public void agregarPizza(Pizza pizza) {
        this.listaPizzas.add(pizza);
    }

    // Aca tenia mal: faltaba 'void', los tipos y llamar a 'new Pizza' con mayuscula
    public void crearPizza(String tipoBase, Tipo_salsa salsa, Toppings toppings, int cantidad) {
        Pizza pizza = new Pizza(tipoBase, salsa, toppings, cantidad);
        this.agregarPizza(pizza);
    }

    // Aca tenia mal: faltaba el tipo de retorno (String) y hacerlo public para ver la orden
    public String getOrden() {
        if (listaPizzas.isEmpty()) {
            return "Orden #" + numeroOrden + ": (Vacia)";
        }
        String texto = "Orden #" + numeroOrden + ":\n";
        for (Pizza p : listaPizzas) {
            texto += "  * " + p + "\n";
        }
        return texto;
    }

    public int getNumeroOrden() { return numeroOrden; }
    public ArrayList<Pizza> getPizzas() { return listaPizzas; }
    public boolean estaVacia() { return listaPizzas.isEmpty(); }
}
