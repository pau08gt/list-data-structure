import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {

    Lista listadoPaquetes=new Lista();
    private JTabbedPane tabbedPane1;
    private JSpinner spinner1;
    private JComboBox comboBox1;
    private JList list1;
    private JTextField txtNombre;
    private JButton BUSCARPORNOMBREYButton;
    private JTextField txtNumeroTrack;
    private JTextArea txtListarPaquete;
    private JButton BUSCARTRACKINGButton;
    private JButton RECUPERARLISTADODEPAQUETESButton;
    private JTextArea txtBuscarCiudadNombre;
    private JButton button1;
    private JButton button2;
    private JTextArea textArea3;
    private JComboBox cboCiudad;
    private JLabel lblNombre;

    private JPanel principal;

    public Ventana() {

        BUSCARPORNOMBREYButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ciudad=cboCiudad.getSelectedItem().toString();
                String nombre= lblNombre.getText();
                StringBuilder texto=new StringBuilder();
                //JOptionPane.showMessageDialog(null,ciudad+" "+nombre+" " +listadoPaquetes.buscarCiudadNombre(ciudad,nombre).size() );
                for (Paquete paquete: listadoPaquetes.buscarCiudadNombre(ciudad,nombre))
                    texto.append(paquete.toString());
                if(!texto.isEmpty())
                    txtBuscarCiudadNombre.setText(""+texto);
                else
                    txtBuscarCiudadNombre.setText("NO hay elementos");
            }
        });
        BUSCARTRACKINGButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numeroTracking=Integer.parseInt(txtNumeroTrack.getText());
                JOptionPane.showMessageDialog(null,numeroTracking+" " +listadoPaquetes.buscarBinario(numeroTracking).toString() );
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,listadoPaquetes.totalPeso("QUITO") );
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
