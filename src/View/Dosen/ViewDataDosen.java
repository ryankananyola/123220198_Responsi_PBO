package View.Dosen;

import Controller.ControllerDosen;
import Model.Dosen.ModelDosen;
import View.HalamanUtama;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class ViewDataDosen extends JFrame{
    
    Integer baris;

    ControllerDosen controller;

    JLabel header = new JLabel("Selamat Datang Di DataBase Dosen!");
    
    JTextField textCari = new JTextField();
    
    JButton tombolCari = new JButton("Cari");
    JButton tombolTambah = new JButton("Tambah Dosen");
    JButton tombolEdit = new JButton("Edit Dosen");
    JButton tombolHapus = new JButton("Hapus Dosen");
    JButton tombolKembali = new JButton("Kembali Menu Utama");

    JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;

    String namaKolom[] = {"ID", "Nama", "No Hp", "Email"};

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
        header.setBounds(20, 15, 440, 25);
        header.setFont(new Font("Times New Roman", Font.BOLD, 24));
        
        add(textCari);
        textCari.setBounds(20,58,400,27);
        
        add(scrollPane);
        scrollPane.setBounds(20, 90, 512, 270);
        
        add(tombolCari);
        tombolCari.setBounds(430, 58, 100, 27);
        add(tombolTambah);
        tombolTambah.setBounds(20, 380, 512, 35);
        add(tombolEdit);
        tombolEdit.setBounds(20, 419, 512, 35);
        add(tombolHapus);
        tombolHapus.setBounds(20, 458, 512, 35);
        add(tombolKembali);
        tombolKembali.setBounds(20, 520,512, 35);
        tombolKembali.setForeground(new Color(255,255,255));
        tombolKembali.setBackground(new Color(255,0,0));

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
                    String no_hp = table.getValueAt(baris, 2).toString();
                    String email = table.getValueAt(baris, 3).toString();
                    
                    dosenTerpilih.setId(id);
                    dosenTerpilih.setNama(nama);
                    dosenTerpilih.setNohp(no_hp);
                    dosenTerpilih.setEmail(email);

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
                    //new HalamanUtama(username);
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