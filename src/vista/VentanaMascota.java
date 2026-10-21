package vista;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Mascota;

//Definimos una clase publica llamada VentanaMascota que hereda de un Frame
public class VentanaMascota extends Frame {
    // Definimos los componentes de la interfaz grafica
    private Label lblTitulo, lblNombre, lblEdad, lblTipo, lblDueno, lblTelefono, lblResumen, lblLista, lblTotal;
    private TextField txtNombre, txtEdad, txtDueno, txtTelefono;
    private Choice choTipo;
    private Checkbox chkVacunas;
    private Button btnRegistrar, btnLimpiar;
    private TextArea txtResumen;
    private List listMascotas;

    // aqui se guardan todas las mascotas registradas
    private ArrayList<Mascota> listaMascotas = new ArrayList<>();

    // edad máxima permitida (se cambia solo aquí)
    private int edadMaxima = 40;

    // Creamos un constructor de la clase VentanaMascota
    public VentanaMascota() {
        // Definimos un titulo a la ventana
        setTitle("Centro Veterinario - Registro de Mascotas");
        // Definimos un tamaño de la ventana
        setSize(750, 450);
        // Definimos el color de fondo de la ventana
        setBackground(Color.lightGray);
        // Centramos la ventana al ejecutar
        setLocationRelativeTo(null);
        // Definimos el layout en null
        setLayout(null);
        // Invocamos los metodos de la interfaz grafica
        configurarTitulo();
        configurarCamposDeEntrada();
        configurarBotones();
        configurarResumen();
        // Invocamos a los botones de evento
        configurarBotonesDeEventos();
    }

    // Definimos un metodo para configurar el Titulo de la ventana
    private void configurarTitulo() {
        lblTitulo = new Label("Registro de Mascotas");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setBounds(50, 35, 300, 30);
        add(lblTitulo);
    }

    // Definimos un metodo para configurar los campos de entrada
    private void configurarCamposDeEntrada() {
        // campo de entrada del Nombre
        lblNombre = new Label("Nombre:");
        lblNombre.setBounds(50, 90, 100, 20);
        add(lblNombre);

        txtNombre = new TextField();
        txtNombre.setBounds(160, 90, 180, 20);
        add(txtNombre);

        // campo de entrada de la Edad
        lblEdad = new Label("Edad:");
        lblEdad.setBounds(50, 120, 100, 20);
        add(lblEdad);

        txtEdad = new TextField();
        txtEdad.setBounds(160, 120, 180, 20);
        add(txtEdad);

        // lista desplegable con el tipo de mascota
        lblTipo = new Label("Tipo:");
        lblTipo.setBounds(50, 150, 100, 20);
        add(lblTipo);

        choTipo = new Choice();
        choTipo.add("Perro");
        choTipo.add("Gato");
        choTipo.add("Conejo");
        choTipo.add("Ave");
        choTipo.add("Otro");
        choTipo.setBounds(160, 150, 180, 20);
        add(choTipo);

        // nombre del dueño
        lblDueno = new Label("Dueño:");
        lblDueno.setBounds(50, 180, 100, 20);
        add(lblDueno);

        txtDueno = new TextField();
        txtDueno.setBounds(160, 180, 180, 20);
        add(txtDueno);

        // telefono del dueño
        lblTelefono = new Label("Teléfono:");
        lblTelefono.setBounds(50, 210, 100, 20);
        add(lblTelefono);

        txtTelefono = new TextField();
        txtTelefono.setBounds(160, 210, 180, 20);
        add(txtTelefono);

        // casilla de verificacion de vacunas
        chkVacunas = new Checkbox("Vacunas al día");
        chkVacunas.setBounds(160, 240, 180, 20);
        add(chkVacunas);
    }

    // Defino un metodo para configurar los botones
    private void configurarBotones() {
        // Agrego el boton de Registrar
        btnRegistrar = new Button("Registrar");
        btnRegistrar.setBounds(50, 280, 90, 30);
        add(btnRegistrar);

        // Agrego el boton de Limpiar
        btnLimpiar = new Button("Limpiar");
        btnLimpiar.setBounds(150, 280, 90, 30);
        add(btnLimpiar);

        // Etiqueta con el total de mascotas registradas
        lblTotal = new Label("Mascotas registradas: 0");
        lblTotal.setBounds(50, 325, 250, 20);
        add(lblTotal);
    }

    // Defino un metodo para configurar el area de texto del resumen
    private void configurarResumen() {
        lblResumen = new Label("Ficha de atencion:");
        lblResumen.setBounds(380, 70, 200, 20);
        add(lblResumen);

        // area de texto donde se muestra la ficha
        txtResumen = new TextArea();
        txtResumen.setEditable(false);
        txtResumen.setBounds(380, 95, 330, 170);
        add(txtResumen);

        // lista de mascotas ya registradas
        lblLista = new Label("Mascotas registradas (clic para ver su ficha):");
        lblLista.setBounds(380, 272, 330, 20);
        add(lblLista);

        listMascotas = new List();
        listMascotas.setBounds(380, 295, 330, 100);
        add(listMascotas);
    }

    // Metodo Limpiar
    private void limpiarCampos() {
        txtNombre.setText("");
        txtEdad.setText("");
        choTipo.select(0);
        txtDueno.setText("");
        txtTelefono.setText("");
        chkVacunas.setState(false);
        txtResumen.setText("");
    }

    // revisa si un texto contiene algun numero
    private boolean contieneNumeros(String texto) {
        for (int i = 0; i < texto.length(); i++) {
            if (Character.isDigit(texto.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    // revisa si un texto está formado solo por números
    private boolean soloNumeros(String texto) {
        for (int i = 0; i < texto.length(); i++) {
            if (!Character.isDigit(texto.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    // Metodos para botones de Evento
    private void configurarBotonesDeEventos() {
        // Agregar un ActionListener al boton "Registrar"
        btnRegistrar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = txtNombre.getText().trim();
                    String dueno = txtDueno.getText().trim();
                    String telefono = txtTelefono.getText().trim();

                    // Validaciones del nombre de la mascota
                    if (nombre.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Ingresa el nombre de la mascota.");
                        return;
                    }
                    if (contieneNumeros(nombre)) {
                        JOptionPane.showMessageDialog(null, "El nombre de la mascota no puede tener números.");
                        return;
                    }

                    // Validaciones de la edad
                    int edad = Integer.parseInt(txtEdad.getText().trim());
                    if (edad < 0) {
                        JOptionPane.showMessageDialog(null, "La edad no puede ser negativa.");
                        return;
                    }
                    if (edad > edadMaxima) {
                        JOptionPane.showMessageDialog(null, "La edad no puede ser mayor a " + edadMaxima + " años.");
                        return;
                    }

                    // Validaciones del dueño
                    if (dueno.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Ingresa el nombre del dueño.");
                        return;
                    }
                    if (contieneNumeros(dueno)) {
                        JOptionPane.showMessageDialog(null, "El nombre del dueño no puede tener números.");
                        return;
                    }

                    // Validaciones del teléfono
                    if (!soloNumeros(telefono) || telefono.length() < 8 || telefono.length() > 12) {
                        JOptionPane.showMessageDialog(null,
                                "El teléfono debe tener entre 8 y 12 dígitos, solo números.");
                        return;
                    }

                    // Creamos la mascota del modelo y le pasamos los datos
                    Mascota nuevaMascota = new Mascota();
                    nuevaMascota.setNombre(nombre);
                    nuevaMascota.setEdad(edad);
                    nuevaMascota.setTipo(choTipo.getSelectedItem());
                    nuevaMascota.setVacunadoAlDia(chkVacunas.getState());
                    nuevaMascota.setNombreDueno(dueno);
                    nuevaMascota.setTelefono(telefono);

                    // Mostramos la ficha en el area de texto
                    txtResumen.setText(nuevaMascota.generarResumen());

                    // Guardamos la mascota en la lista interna
                    listaMascotas.add(nuevaMascota);
                    // Agregamos una línea resumida a la lista visible
                    String lineaLista = nuevaMascota.getNombre()
                            + " | " + nuevaMascota.getTipo()
                            + " | Dueño: " + nuevaMascota.getNombreDueno()
                            + " | " + nuevaMascota.obtenerFechaTexto();
                    listMascotas.add(lineaLista);

                    lblTotal.setText("Mascotas registradas: " + listaMascotas.size());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "La edad debe ser un número entero válido.");
                }
            }
        });

        // Agregar un ActionListener al boton "Limpiar"
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });
        // al seleccionar una mascota de la lista, se muestra su ficha
        listMascotas.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int fila = listMascotas.getSelectedIndex();
                if (fila != -1) {
                    txtResumen.setText(listaMascotas.get(fila).generarResumen());
                }
            }
        });

        // Agrega un WindowListener para manejar el evento de cierre de la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Cerrando la ventana...");
                dispose();
                System.exit(0);
            }
        });
    }
}
