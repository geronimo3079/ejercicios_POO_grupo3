package app;

import javax.swing.*;
import java.io.*;

public class EliminarContactoUI {
    private JFrame frame;
    private JTextField txtNombre;
    private JButton btnEliminar;

    public void mostrar() {
        frame = new JFrame("Eliminar Contacto");
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

        btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(e -> eliminarContacto());
        panel.add(btnEliminar);

        frame.setVisible(true);
    }

    private void eliminarContacto() {
        String nombre = txtNombre.getText();

        if (!nombre.isEmpty()) {
            try {
                File archivo = new File("directorio.txt");
                File archivoTemp = new File("directorio_temp.txt");

                FileReader fileReader = new FileReader(archivo);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                FileWriter fileWriter = new FileWriter(archivoTemp);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                String line;
                boolean contactoEliminado = false;

                while ((line = bufferedReader.readLine()) != null) {
                    String[] contacto = line.split(",");

                    if (!contacto[0].equals(nombre)) {
                        bufferedWriter.write(line);
                        bufferedWriter.newLine();
                    } else {
                        contactoEliminado = true;
                    }
                }

                bufferedReader.close();
                fileReader.close();
                bufferedWriter.close();
                fileWriter.close();

                archivo.delete();
                archivoTemp.renameTo(archivo);

                if (contactoEliminado) {
                    JOptionPane.showMessageDialog(frame, "Contacto eliminado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Contacto no encontrado.");
                }

                frame.dispose();

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error al eliminar el contacto.");
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Ingrese un nombre válido.");
        }
    }
}
