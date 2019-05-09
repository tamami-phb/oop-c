package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class TambahUI extends JFrame {

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

    public TambahUI(MainUI parent) {
        initUI();
        this.parent = parent;
    }

    private void initUI() {
        setTitle("Tambah Data Mahasiswa");

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
    }

    public void clearForm() {
        txtNim.setText("");
        txtNama.setText("");
        txtKelas.setText("");
    }


    // ----- event

    private class BtnSimpanClick implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            String nim = txtNim.getText();
            String nama = txtNama.getText();
            String kelas = txtKelas.getText();
            String query = "insert into mahasiswa(nim, nama, kelas) " +
                    "values('" + nim + "','" + nama + "','" + kelas + "')";
            try {
                MainUI.koneksi.eksekusiUpdate(query);
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                setVisible(false);
                parent.refreshTable();
            } catch(SQLException e) {
                JOptionPane.showMessageDialog(null, "Gagal menyimpan data baru");
            }
        }
    }

    private class BtnBatalClick implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
        }
    }

}