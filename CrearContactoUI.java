package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class CrearContactoUI {
    private JFrame frame;
    private JTextField txtNombre;
    private JFormattedTextField txtTelefono;
    private JButton btnCrear;

    public void mostrar() {
        frame = new JFrame("Crear Contacto");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel lblNombre = new JLabel("Nombre:");
        panel.add(lblNombre);

        txtNombre = new JTextField();
        panel.add(txtNombre);

        JLabel lblTelefono = new JLabel("Teléfono:");
        panel.add(lblTelefono);

        txtTelefono = new JFormattedTextField();
        txtTelefono.setColumns(10);
        txtTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        panel.add(txtTelefono);

        btnCrear = new JButton("Crear");
        btnCrear.addActionListener(e -> crearContacto());
        panel.add(btnCrear);

        frame.setVisible(true);
    }

    private void crearContacto() {
        String nombre = txtNombre.getText();
        String telefono = txtTelefono.getText();

        if (!nombre.isEmpty() && !telefono.isEmpty()) {
            try {
                FileWriter fileWriter = new FileWriter("directorio.txt", true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                bufferedWriter.write(nombre + "," + telefono);
                bufferedWriter.newLine();

                bufferedWriter.close();
                fileWriter.close();

                JOptionPane.showMessageDialog(frame, "Contacto agregado exitosamente.");

                frame.dispose();

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error al crear el archivo.");
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Ingrese un nombre y un número de teléfono válido.");
        }
    }
}
