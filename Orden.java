public class Orden {
    private  pizza (tipo_orden str, Tipo_salsa salsa, Toppings toppings, Cantidad int) {
        this.str = str;
        this.salsa = salsa;
        this.toppings = toppings;
        this.int = int;
    }
    
    private getOrden() {
        return this.str + this.salsa + this.toppings + this.int;
    }

    private agregarOrden(pizza pizza) {
        this.orden.add(pizza);
    }

    private crear_pizza(tipo_orden str, Tipo_salsa salsa, Toppings toppings, Cantidad int) {
        pizza pizza = new pizza(str, salsa, toppings, int);
        this.agregarOrden(pizza);
    }

}
