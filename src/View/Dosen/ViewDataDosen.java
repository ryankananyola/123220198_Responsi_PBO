package View.Dosen;

import Controller.ControllerDosen;
import Model.Dosen.ModelDosen;
import View.HalamanUtama;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class ViewDataDosen extends JFrame{
    
    Integer baris;

    ControllerDosen controller;

    JLabel header = new JLabel("Selamat Datang Di DataBase Dosen!");
    JButton tombolTambah = new JButton("Tambah Dosen");
    JButton tombolEdit = new JButton("Edit Dosen");
    JButton tombolHapus = new JButton("Hapus Dosen");
    JButton tombolKembali = new JButton("Kembali Menu Utama");

    JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;

    String namaKolom[] = {"ID", "Nama", "NIDN"};

    public ViewDataDosen() {
        tableModel = new DefaultTableModel(namaKolom, 0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);

        setVisible(true);
        setTitle("Daftar Dosen");
        setSize(560, 610);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(null);
        setLocationRelativeTo(null);
        
        getContentPane().setBackground(new Color(152,251,152));

        add(header);
        add(scrollPane);
        add(tombolTambah);
        add(tombolEdit);
        add(tombolHapus);
        add(tombolKembali);

        header.setBounds(20, 8, 440, 24);
        scrollPane.setBounds(20, 36, 512, 320);
        tombolTambah.setBounds(20, 370, 512, 40);
        tombolEdit.setBounds(20, 414, 512, 40);
        tombolHapus.setBounds(20, 456, 512, 40);
        tombolKembali.setBounds(20, 520,512, 40);

        controller = new ControllerDosen(this);
        controller.showAllDosen();

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                baris = table.getSelectedRow();
            }
        });

        tombolTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new InputDataDosen();
            }
        });

        tombolEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (baris != null) {
                    
                    ModelDosen dosenTerpilih = new ModelDosen();
                    
                    Integer id = (int) table.getValueAt(baris, 0);
                    String nama = table.getValueAt(baris, 1).toString();
                    String nidn = table.getValueAt(baris, 2).toString();
                    
                    dosenTerpilih.setId(id);
                    dosenTerpilih.setNama(nama);
                    dosenTerpilih.setNidn(nidn);

                    dispose();
                    new EditDataDosen(dosenTerpilih);
                } else {
                    JOptionPane.showMessageDialog(null, "Data belum dipilih.");
                }
            }
        });

        tombolHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (baris != null) {
                    controller.deleteDosen(baris);
                    
                    baris = null;
                } else {
                    JOptionPane.showMessageDialog(null, "Data belum dipilih.");
                }
            }
        });
        
        tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==tombolKembali){
                    dispose();
                    new HalamanUtama(username);
                } else {
                    JOptionPane.showMessageDialog(null,"");
                }
            }
        });
    }

    public JTable getTableDosen() {
        return table;
    }
}