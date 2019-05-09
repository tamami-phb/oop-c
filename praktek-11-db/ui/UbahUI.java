package ui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UbahUI extends JFrame {

    private Container contentPane;
    private JPanel panelForm;
    private JPanel panelButton;
    private JLabel lblNim;
    private JLabel lblNama;
    private JLabel lblKelas;
    private JTextField txtNim;
    private JTextField txtNama;
    private JTextField txtKelas;
    private JButton btnSimpan;
    private JButton btnBatal;
    private MainUI parent;

    public UbahUI(MainUI parent) {
        this.parent = parent;
        initUI();
    }

    private void initUI() {
        setTitle("Ubah Data Mahasiswa");

        contentPane = getContentPane();

        panelForm = new JPanel();
        panelForm.setLayout(new GridLayout(3, 2));
        lblNim = new JLabel("NIM");
        lblNama = new JLabel("NAMA");
        lblKelas = new JLabel("KELAS");
        txtNim = new JTextField();
        txtNama = new JTextField();
        txtKelas = new JTextField();
        panelForm.add(lblNim); panelForm.add(txtNim);
        panelForm.add(lblNama); panelForm.add(txtNama);
        panelForm.add(lblKelas); panelForm.add(txtKelas);
        contentPane.add(panelForm, BorderLayout.CENTER);

        panelButton = new JPanel();
        panelButton.setLayout(new GridLayout(1, 2));
        btnSimpan = new JButton("Simpan");
        btnBatal = new JButton("Batal");
        panelButton.add(btnSimpan); panelButton.add(btnBatal);
        contentPane.add(panelButton, BorderLayout.SOUTH);

        pack();

        btnSimpan.addActionListener(new BtnSimpanClick());
        btnBatal.addActionListener(new BtnBatalClick());
        txtNim.setEditable(false);
    }

    public void tampilkan(String nim, String nama, String kelas) {
        txtNim.setText(nim);
        txtNama.setText(nama);
        txtKelas.setText(kelas);
        setVisible(true);
    }


    // ---- events

    private class BtnSimpanClick implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            String query = "update mahasiswa set " +
                    "nama='" + txtNama.getText() + "'," +
                    "kelas='" + txtKelas.getText() + "' " +
                    "where nim='" + txtNim.getText() + "'";
            try {
                MainUI.koneksi.eksekusiUpdate(query);
                JOptionPane.showMessageDialog(null,
                        "Data Berhasil Diubah");
                setVisible(false);
                parent.refreshTable();
            } catch(SQLException e) {
                JOptionPane.showMessageDialog(null,
                        "Data gagal diubah");
            }
        }
    }

    private class BtnBatalClick implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            setVisible(false);
        }
    }

}