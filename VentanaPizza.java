import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPizza extends JFrame {

    private JComboBox<String> comboBase;
    private JComboBox<Tipo_salsa> comboSalsa;
    private JComboBox<Toppings> comboTopping;
    private JSpinner spinnerCantidad;
    private JTextArea areaRegistro;

    private Cocina cocina;
    private Orden ordenActual;
    private int contadorOrden;

    public VentanaPizza() {
        setTitle("Pizzeria Oh Si");
        setSize(650, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cocina = new Cocina();
        contadorOrden = 1;
        ordenActual = new Orden(contadorOrden);

        iniciarComponentes();
    }

    private void iniciarComponentes() {
        JPanel panelOpciones = new JPanel(new GridLayout(4, 2, 8, 8));
        panelOpciones.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelOpciones.add(new JLabel("Base:"));
        comboBase = new JComboBox<>(new String[]{"Delgada (Q50)", "Tradicional (Q60)", "Gruesa (Q70)"});
        panelOpciones.add(comboBase);

        panelOpciones.add(new JLabel("Salsa:"));
        comboSalsa = new JComboBox<>(Tipo_salsa.values());
        panelOpciones.add(comboSalsa);

        panelOpciones.add(new JLabel("Topping:"));
        comboTopping = new JComboBox<>(Toppings.values());
        panelOpciones.add(comboTopping);

        panelOpciones.add(new JLabel("Cantidad:"));
        spinnerCantidad = new JSpinner(new SpinnerNumberModel(1, 1, 50, 1));
        panelOpciones.add(spinnerCantidad);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 8));
        JButton btnAgregar = new JButton("Agregar pizza a la orden");
        JButton btnMostrar = new JButton("Mostrar orden");
        JButton btnFactura = new JButton("Generar factura");
        JButton btnCocinar = new JButton("Enviar a cocina");
        JButton btnLimpiar = new JButton("Limpiar");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnMostrar);
        panelBotones.add(btnFactura);
        panelBotones.add(btnCocinar);
        panelBotones.add(btnLimpiar);

        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.add(panelOpciones, BorderLayout.CENTER);
        panelSuperior.add(panelBotones, BorderLayout.SOUTH);

        JPanel panelRegistro = new JPanel(new BorderLayout());
        panelRegistro.setBorder(BorderFactory.createTitledBorder("Registro"));

        areaRegistro = new JTextArea();
        areaRegistro.setEditable(false);
        areaRegistro.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scroll = new JScrollPane(areaRegistro);
        panelRegistro.add(scroll, BorderLayout.CENTER);

        setLayout(new BorderLayout(5, 5));
        add(panelSuperior, BorderLayout.NORTH);
        add(panelRegistro, BorderLayout.CENTER);

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String baseSeleccionada = (String) comboBase.getSelectedItem();
                String base = "Tradicional";
                if (baseSeleccionada.startsWith("Delgada")) base = "Delgada";
                else if (baseSeleccionada.startsWith("Gruesa")) base = "Gruesa";

                Tipo_salsa salsa = (Tipo_salsa) comboSalsa.getSelectedItem();
                Toppings topping = (Toppings) comboTopping.getSelectedItem();
                int cantidad = (int) spinnerCantidad.getValue();

                ordenActual.crearPizza(base, salsa, topping, cantidad);
                areaRegistro.append("Se agrego " + cantidad + " pizza(s) a la orden " + contadorOrden + "\n");
            }
        });

        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaRegistro.append("\n" + ordenActual.getOrden() + "\n");
            }
        });

        btnFactura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaRegistro.append("\n" + ordenActual.generarFactura() + "\n");
            }
        });

        btnCocinar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ordenActual.estaVacia()) {
                    areaRegistro.append("La orden " + contadorOrden + " no tiene pizzas.\n");
                    return;
                }

                areaRegistro.append("\nEnviando orden " + contadorOrden + " a cocina...\n");
                String respuesta = cocina.recibirOrden(ordenActual);
                areaRegistro.append(respuesta + "\n\n");

                String cocinado = cocina.cocinarOrdenes();
                areaRegistro.append(cocinado + "\n\n");

                contadorOrden++;
                ordenActual = new Orden(contadorOrden);
                areaRegistro.append("Iniciando orden " + contadorOrden + "\n");
            }
        });

        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaRegistro.setText("");
            }
        });

        areaRegistro.append("Pizzeria Oh Si\n");
        areaRegistro.append("Iniciando orden " + contadorOrden + "\n\n");
    }
}
