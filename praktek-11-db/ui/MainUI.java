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
    public static UbahUI ubahUI;

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
        ubahUI = new UbahUI(this);

        contentPane = getContentPane();

        columnNames = new Vector();
        columnNames.add("NIM");
        columnNames.add("NAMA");
        columnNames.add("KELAS");
        data = new Vector();
        tableModel = new DefaultTableModel(data, columnNames);
        table = new JTable(tableModel);
        table.setSelectionModel(new MySingleSelectionModel());
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
        btnUbah.addActionListener(new BtnUbahClick());
        btnHapus.addActionListener(new BtnHapusClick());
    }


    // ------ events

    private class BtnTambahClick implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            tambahUI.clearForm();
            tambahUI.setVisible(true);
        }
    }

    private class BtnUbahClick implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            if(table.getSelectedRow() != -1) {
                ubahUI.tampilkan(
                        "" + table.getValueAt(table.getSelectedRow(), 0),
                        table.getValueAt(table.getSelectedRow(), 1).toString(),
                        (String) table.getValueAt(table.getSelectedRow(), 2));
            } else {
                JOptionPane.showMessageDialog(null,
                        "Pilih dulu data yang akan diubah di tabel");
            }
        }
    }

    private class BtnHapusClick implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            if(table.getSelectedRow() != -1) {
                String nim = table.getValueAt(table.getSelectedRow(), 0).toString();
                String query = "delete from mahasiswa " +
                        "where nim='" + nim + "'";
                try {
                    koneksi.eksekusiUpdate(query);
                    JOptionPane.showMessageDialog(null,
                            "Data dengan nim " + nim + " telah dihapus.");
                    refreshTable();
                } catch(SQLException e) {
                    JOptionPane.showMessageDialog(null,
                            "Data gagal dihapus");
                }
            } else {
                JOptionPane.showMessageDialog(null,
                        "Pilih dahulu data yang akan dihapus.");
            }
        }
    }

}