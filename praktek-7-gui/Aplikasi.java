import javax.swing.*;
import java.awt.*;

public class Aplikasi {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JLabel label = new JLabel("tamami");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        JButton btn = new JButton("Proses");
        JLabel lblNim = new JLabel("NIM");
        JLabel lblNama = new JLabel("NAMA");
        JLabel lblKelas = new JLabel("KELAS");
        JTextField txtNim = new JTextField();
        JTextField txtNama = new JTextField();
        JTextField txtKelas = new JTextField();

        panel.add(lblNim); panel.add(txtNim);
        panel.add(lblNama); panel.add(txtNama);
        panel.add(lblKelas); panel.add(txtKelas);

        //frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.getContentPane().add(btn, BorderLayout.SOUTH);
        //frame.getContentPane().add(new JLabel("utara"), BorderLayout.NORTH);
        //frame.getContentPane().add(new JLabel("selatan"), BorderLayout.SOUTH);
        //frame.getContentPane().add(new JLabel("timur"), BorderLayout.EAST);
        //frame.getContentPane().add(new JLabel("barat"), BorderLayout.WEST);
        frame.pack();
        //frame.setSize(400, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}