package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfazgrafica extends JFrame {
    private JButton btnCrear;
    private JButton btnBuscar;
    private JButton btnActualizar;
    private JButton btnEliminar;

    public Interfazgrafica() {
        setTitle("Directorio");
        setSize(400, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(207, 179, 241));

        btnCrear = new JButton("Crear");
        btnBuscar = new JButton("Buscar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");

        btnCrear.setBackground(new Color(255, 207, 207));
        btnBuscar.setBackground(new Color(255, 207, 207));
        btnActualizar.setBackground(new Color(255, 207, 207));
        btnEliminar.setBackground(new Color(255, 207, 207));

        setLayout(new FlowLayout());
        add(btnCrear);
        add(btnBuscar);
        add(btnActualizar);
        add(btnEliminar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Interfazgrafica miInterfaz = new Interfazgrafica();
                miInterfaz.setVisible(true);
                miInterfaz.inicializarEventos();
            }
        });
    }

    private void inicializarEventos() {
        btnCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CrearContactoUI crearUI = new CrearContactoUI();
                crearUI.mostrar();
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BuscarContactoUI buscarUI = new BuscarContactoUI();
                buscarUI.mostrar();
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ActualizarContactoUI actualizarUI = new ActualizarContactoUI();
                actualizarUI.mostrar();
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EliminarContactoUI eliminarUI = new EliminarContactoUI();
                eliminarUI.mostrar();
            }
        });
    }

    public void mostrar() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
