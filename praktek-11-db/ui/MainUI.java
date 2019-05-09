package ui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.table.*;
import util.*;
import java.sql.*;

public class MainUI extends JFrame {

    public static Koneksi koneksi;
    public static TambahUI tambahUI;

    private JTable table;
    private JButton btnTambah;
    private JButton btnUbah;
    private JButton btnHapus;
    private JPanel panelButton;
    private Container contentPane;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;
    private Vector data;
    private Vector columnNames;

    public MainUI() {
        try {
            koneksi = new Koneksi();
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Gagal koneksi");
            e.printStackTrace();
        }
        initUI();
        initData();
    }

    private void initData() {
        String query = "select * from mahasiswa";
        try {
            ResultSet result = koneksi.eksekusiSelect(query);
            data = new Vector();
            while (result.next()) {
                Vector row = new Vector();
                row.add(result.getString(1));
                row.add(result.getString(2));
                row.add(result.getString(3));
                data.add(row);
            }
            tableModel.setDataVector(data, columnNames);
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "query gagal di eksekusi");
        }
    }

    public void refreshTable() {
        initData();
    }

    private void initUI() {
        setTitle("Aplikasi Mahasiswa");

        tambahUI = new TambahUI(this);

        contentPane = getContentPane();

        columnNames = new Vector();
        columnNames.add("NIM");
        columnNames.add("NAMA");
        columnNames.add("KELAS");
        data = new Vector();
        tableModel = new DefaultTableModel(data, columnNames);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        panelButton = new JPanel();
        panelButton.setLayout(new GridLayout(1, 3));
        btnTambah = new JButton("Tambah");
        btnUbah = new JButton("Ubah");
        btnHapus = new JButton("Hapus");
        panelButton.add(btnTambah);
        panelButton.add(btnUbah);
        panelButton.add(btnHapus);
        contentPane.add(panelButton, BorderLayout.SOUTH);

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnTambah.addActionListener(new BtnTambahClick());
    }


    // ------ events

    private class BtnTambahClick implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            tambahUI.setVisible(true);
        }
    }

}