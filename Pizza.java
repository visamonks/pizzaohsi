public class Pizza {

    // Aca tenia mal: pusiste 'tipo_base str', asi va: String tipoBase (tipo y luego nombre)
    private String tipoBase;

    private Tipo_salsa salsa;
    private Toppings toppings;

    // Aca tenia mal: pusiste 'Cantidad int', asi va: int cantidad ('int' es palabra reservada)
    private int cantidad;

    // Aca tenia mal: el constructor se llama igual a la clase (Pizza) y no lleva 'void'
    public Pizza(String tipoBase, Tipo_salsa salsa, Toppings toppings, int cantidad) {
        this.tipoBase = tipoBase;
        this.salsa = salsa;
        this.toppings = toppings;
        // Aca tenia mal: pusiste 'this.int = int', asi va: this.cantidad = cantidad
        this.cantidad = cantidad;
    }

    // Constructor simple por si no indican cantidad (por defecto 1)
    public Pizza(String tipoBase, Tipo_salsa salsa, Toppings toppings) {
        this(tipoBase, salsa, toppings, 1);
    }

    public String getTipoBase() { return tipoBase; }
    public Tipo_salsa getSalsa() { return salsa; }
    public Toppings getToppings() { return toppings; }
    public int getCantidad() { return cantidad; }

    @Override
    public String toString() {
        return cantidad + "x Pizza [Base: " + tipoBase + ", Salsa: " + salsa + ", Topping: " + toppings + "]";
    }
}
