public class Cocina {
    private orden_pendientes lista_ordenes;

    private orden_pendientes() {
        this.lista_ordenes = new orden_pendientes[5];
    }

    private verificar_orden(orden_pendientes orden) {
        if (orden != null) {
            return true;
        } else {
            return false;
        }
    }
    
    
}
