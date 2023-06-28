package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ActualizarContactoUI {
    private JFrame frame;
    private JTextField txtNombre;
    private JFormattedTextField txtNuevoTelefono;
    private JButton btnActualizar;

    public void mostrar() {
        frame = new JFrame("Actualizar Contacto");
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

        JLabel lblNuevoTelefono = new JLabel("Nuevo Teléfono:");
        panel.add(lblNuevoTelefono);

        txtNuevoTelefono = new JFormattedTextField();
        txtNuevoTelefono.setColumns(10);
        txtNuevoTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        panel.add(txtNuevoTelefono);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(e -> actualizarContacto());
        panel.add(btnActualizar);

        frame.setVisible(true);
    }

    private void actualizarContacto() {
        String nombre = txtNombre.getText();
        String nuevoTelefono = txtNuevoTelefono.getText();

        if (!nombre.isEmpty() && !nuevoTelefono.isEmpty()) {
            try {
                File archivo = new File("directorio.txt");
                File archivoTemp = new File("directorio_temp.txt");

                FileReader fileReader = new FileReader(archivo);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                FileWriter fileWriter = new FileWriter(archivoTemp);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                String line;
                boolean contactoEncontrado = false;

                while ((line = bufferedReader.readLine()) != null) {
                    String[] contacto = line.split(",");

                    if (contacto[0].equals(nombre)) {
                        bufferedWriter.write(contacto[0] + "," + nuevoTelefono);
                        contactoEncontrado = true;
                    } else {
                        bufferedWriter.write(line);
                    }

                    bufferedWriter.newLine();
                }

                bufferedReader.close();
                fileReader.close();
                bufferedWriter.close();
                fileWriter.close();

                if (contactoEncontrado) {
                    archivo.delete();
                    archivoTemp.renameTo(archivo);
                    JOptionPane.showMessageDialog(frame, "Contacto actualizado exitosamente.");
                } else {
                    archivoTemp.delete();
                    JOptionPane.showMessageDialog(frame, "Contacto no encontrado.");
                }

                frame.dispose();

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error al actualizar el contacto.");
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Ingrese un nombre y un número de teléfono válido.");
        }
    }
}
