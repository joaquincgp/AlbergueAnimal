import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class MainGUI extends JFrame {
    private JTextField nombreInscripcionlField;
    private JPanel panelPrincipal;
    private JTextField fechaNacimientoField;
    private JTextField idField;
    private JTextField especieField;
    private JTextField colorField;
    private JTextField pabellonField;
    private JButton botonInscribir;
    private JButton adoptarButton;
    private JComboBox comboBoxDoctor;
    private JTextField fechaCitaField;
    private JTextField pacienteField;
    private JButton agendarButton;
    private JTextField idAdopcionField;
    private JTextField nombreResponsableField;
    private JButton donarButton;
    private JButton verDonacionesButton;
    private JTextField celularResponsableField;
    private JTextField cedulaField;
    private JTextField correoField;
    private JTextField estadoCivilField;
    private JTextField direccionField;
    private JScrollBar scrollBar1;

    private JTextField donanteField;
    private JTextField montoField;
    private JTextArea textAreaAnimales;
    private Albergue albergue = new Albergue();

    public static void main(String[] args) {
            MainGUI panel = new MainGUI();
            panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            panel.setContentPane(panel.panelPrincipal);
            panel.setSize(1900, 1000);
            panel.setVisible(true);
    }

    public MainGUI() {
        botonInscribir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombreAnimal = nombreInscripcionlField.getText();
                    String inputFecha = fechaNacimientoField.getText();
                    String idAnimal = idField.getText();
                    String especieTexto = especieField.getText().toUpperCase();
                    String colorAnimal = colorField.getText();
                    char pabellon = pabellonField.getText().toLowerCase().charAt(0);

                    if (nombreAnimal.isEmpty() || inputFecha.isEmpty() || idAnimal.isEmpty() || especieTexto.isEmpty() || colorAnimal.isEmpty()) {
                        throw new CampoVacioException("Algun campo esta vacio");
                    }
                    if(pabellon!= 'a' && pabellon != 'b'){
                        throw new CampoVacioException("Algun campo esta mal");
                    }

                    LocalDate fechaNacimiento = LocalDate.parse(inputFecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    Animal.Especie especieAnimal = Animal.Especie.valueOf(especieTexto);

                    Animal animalRegistrado = new Animal(nombreAnimal, fechaNacimiento, idAnimal, colorAnimal, pabellon, especieAnimal);
                    albergue.agregarAnimal(animalRegistrado);
                } catch (CampoVacioException ex) {
                    JOptionPane.showMessageDialog(MainGUI.this, "Error al registrar animalito: Hay algun(os) campo(s) vacio(s) o un formato no es valido", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        adoptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        agendarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        donarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        verDonacionesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }



}
