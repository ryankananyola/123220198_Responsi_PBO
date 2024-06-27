package View.Mahasiswa;

import Controller.ControllerMahasiswa;
import Model.Mahasiswa.ModelMahasiswa;
import Model.Mahasiswa.ModelTabelMahasiswa;
import View.HalamanUtama;
import View.Session;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewDataMahasiswa extends JFrame {

    Integer baris;
    ControllerMahasiswa controller;
    
    JLabel header = new JLabel("Selamat Datang Di Database Mahasiswa!");
    
    JTextField textCari = new JTextField();
    
    JButton tombolCari = new JButton("Cari");
    JButton tombolTambah = new JButton("Tambah Mahasiswa");
    JButton tombolEdit = new JButton("Edit Mahasiswa");
    JButton tombolHapus = new JButton("Hapus Mahasiswa");
    JButton tombolKembali = new JButton("Kembali Menu Utama");
    
    JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;

    String namaKolom[] = {"ID", "Nama", "NIM", "Email", "Password", "Angkatan"};
    
    String username;
    
    public ViewDataMahasiswa() {
        this.username = Session.getUsername();
        
        ModelTabelMahasiswa tableModel = new ModelTabelMahasiswa(new ArrayList<>());
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);

        setVisible(true);
        setTitle("Daftar Mahasiswa");
        setSize(560, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 215, 0));
        
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
        
        controller = new ControllerMahasiswa(this);
        controller.showAllMahasiswa();

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                baris = table.getSelectedRow();
            }
        });
        
        tombolCari.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String keyword = textCari.getText();
                controller.cariMahasiswa(keyword);
            }
        });

        textCari.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e) {
                String keyword = textCari.getText();
                controller.cariMahasiswa(keyword);
            }
        });

        tombolTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new InputDataMahasiswa();
            }
        });

        tombolEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (baris != null) {
                    
                    ModelMahasiswa mahasiswaTerpilih = new ModelMahasiswa();
                    
                    Integer id = (int) table.getValueAt(baris, 0);
                    String nama = table.getValueAt(baris, 1).toString();
                    String nim = table.getValueAt(baris, 2).toString();
                    String email = table.getValueAt(baris, 3).toString();
                    String password = table.getValueAt(baris, 4).toString();
                    String angkatan = table.getValueAt(baris, 5).toString();
                    
                    mahasiswaTerpilih.setId(id);
                    mahasiswaTerpilih.setNama(nama);
                    mahasiswaTerpilih.setNim(nim);
                    mahasiswaTerpilih.setEmail(email);
                    mahasiswaTerpilih.setPassword(password);
                    mahasiswaTerpilih.setAngkatan(angkatan);

                    dispose();
                    new EditDataMahasiswa(mahasiswaTerpilih);
                } else {
                    JOptionPane.showMessageDialog(null, "Data belum dipilih.");
                }
            }
        });

        tombolHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (baris != null) {
                    controller.deleteMahasiswa(baris);
                    
                    baris = null;
                } else {
                    JOptionPane.showMessageDialog(null, "Data belum dipilih.");
                }
            }
        });
        
        tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new HalamanUtama();
            }
        });
    }

    public JTable getTableMahasiswa() {
        return table;
    }
}
