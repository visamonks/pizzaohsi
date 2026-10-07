import javax.swing.SwingUtilities;

// Aca puse mal: puse @interface por error, asi va con public class
public class Main {

    // Aca me falto: no puse el metodo main para poder correr el programa en la terminal
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaPizza ventana = new VentanaPizza();
                ventana.setVisible(true);
            }
        });
    }
}
