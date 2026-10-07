public class Pizza {

    // Aca puse mal: tenia tipo_base str, asi va: String tipoBase (primero tipo y luego nombre)
    private String tipoBase;

    private Tipo_salsa salsa;
    private Toppings toppings;

    // Aca puse mal: tenia Cantidad int, asi va: int cantidad (int es palabra reservada)
    private int cantidad;

    // Aca puse mal: le habia puesto void y minuscula, el constructor va como Pizza y sin void
    public Pizza(String tipoBase, Tipo_salsa salsa, Toppings toppings, int cantidad) {
        this.tipoBase = tipoBase;
        this.salsa = salsa;
        this.toppings = toppings;
        // Aca puse mal: puse this.int = int, asi va: this.cantidad = cantidad
        this.cantidad = cantidad;
    }

    public Pizza(String tipoBase, Tipo_salsa salsa, Toppings toppings) {
        this(tipoBase, salsa, toppings, 1);
    }

    public String getTipoBase() { return tipoBase; }
    public Tipo_salsa getSalsa() { return salsa; }
    public Toppings getToppings() { return toppings; }
    public int getCantidad() { return cantidad; }

    public double getPrecioUnitario() {
        double pBase = 0;
        if ("Delgada".equalsIgnoreCase(tipoBase)) pBase = 50;
        else if ("Tradicional".equalsIgnoreCase(tipoBase)) pBase = 60;
        else if ("Gruesa".equalsIgnoreCase(tipoBase)) pBase = 70;

        double pSalsa = 0;
        if (salsa == Tipo_salsa.NORMAL) pSalsa = 10;
        else if (salsa == Tipo_salsa.PICANTE) pSalsa = 15;
        else if (salsa == Tipo_salsa.HONGO) pSalsa = 20;

        double pTopping = 0;
        if (toppings == Toppings.JAMON) pTopping = 20;
        else if (toppings == Toppings.PEPPERONI) pTopping = 25;
        else if (toppings == Toppings.CHILE) pTopping = 15;

        return pBase + pSalsa + pTopping;
    }

    public double getTotal() {
        return getPrecioUnitario() * cantidad;
    }

    @Override
    public String toString() {
        return cantidad + " pizza(s) con base " + tipoBase + ", salsa " + salsa + " y " + toppings + " (Q" + getTotal() + ")";
    }
}
