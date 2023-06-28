package app;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BuscarContactoUI {
    private JFrame frame;
    private JTextField txtNombre;
    private JButton btnBuscar;

    public void mostrar() {
        frame = new JFrame("Buscar Contacto");
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel lblNombre = new JLabel("Nombre:");
        panel.add(lblNombre);

        txtNombre = new JTextField();
        panel.add(txtNombre);

        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(e -> buscarContacto());
        panel.add(btnBuscar);

        frame.setVisible(true);
    }

    private void buscarContacto() {
        String nombre = txtNombre.getText();

        if (!nombre.isEmpty()) {
            try {
                FileReader fileReader = new FileReader("directorio.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line;
                boolean contactoEncontrado = false;

                while ((line = bufferedReader.readLine()) != null) {
                    String[] contacto = line.split(",");

                    if (contacto[0].equals(nombre)) {
                        JOptionPane.showMessageDialog(frame, "Número de teléfono: " + contacto[1]);
                        contactoEncontrado = true;
                        break;
                    }
                }

                bufferedReader.close();
                fileReader.close();

                if (!contactoEncontrado) {
                    JOptionPane.showMessageDialog(frame, "Contacto no encontrado.");
                }

                frame.dispose();

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error al leer el archivo.");
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Ingrese un nombre válido.");
        }
    }
}

