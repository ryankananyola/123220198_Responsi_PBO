package View.Mahasiswa;

import Controller.ControllerMahasiswa;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class InputDataMahasiswa extends JFrame{
    ControllerMahasiswa controller;
    
    JLabel header = new JLabel("INPUT MAHASISWA");
    JLabel labelInputNama = new JLabel("Nama");
    JLabel labelInputNIM = new JLabel("NIM");
    JLabel labelInputEmail = new JLabel("Email");
    JLabel labelInputPassword = new JLabel("Password");
    JLabel labelInputAngkatan = new JLabel("Angkatan");
    
    JTextField inputNama = new JTextField();
    JTextField inputNIM = new JTextField();
    JTextField inputEmail = new JTextField();
    JTextField inputPassword = new JTextField();
    JTextField inputAngkatan = new JTextField();
    
    JButton tombolTambah = new JButton("Tambah Mahasiswa");
    JButton tombolKembali = new JButton("Kembali");

    public InputDataMahasiswa() {
        
        setVisible(true);
        setTitle("Input Mahasiswa");
        setSize(560, 610);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(238,130,238));
        
        add(header);
        header.setBounds(145, 25, 440, 30);
        header.setFont(new Font("Times New Roman", Font.BOLD, 28));
        add(labelInputNama);
        labelInputNama.setBounds(55, 85, 430, 24);
        add(labelInputNIM);
        labelInputNIM.setBounds(55, 145, 430, 24);
        add(labelInputEmail);
        labelInputEmail.setBounds(55, 205, 430, 24);
        add(labelInputPassword);
        labelInputPassword.setBounds(55, 265, 430, 24);
        add(labelInputAngkatan);
        labelInputAngkatan.setBounds(55, 325, 433, 24);
        
        add(inputNama);
        inputNama.setBounds(55, 110, 430, 30);
        add(inputNIM);
        inputNIM.setBounds(55, 170, 430, 30);
        add(inputEmail);
        inputEmail.setBounds(55, 230, 430, 30);
        add(inputPassword);
        inputPassword.setBounds(55, 290, 430, 30);
        add(inputAngkatan);
        inputAngkatan.setBounds(55, 350, 430, 30);
        
        add(tombolTambah);
        tombolTambah.setBounds(70, 450, 195, 38);
        tombolTambah.setForeground(new Color(255,255,255));
        tombolTambah.setBackground(new Color(50,205,50));
        add(tombolKembali);
        tombolKembali.setBounds(280, 450, 195, 38);
        tombolKembali.setForeground(new Color(255,255,255));
        tombolKembali.setBackground(new Color(255,0,0));

        controller = new ControllerMahasiswa(this);

        tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewDataMahasiswa();
            }
        });

        tombolTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.insertMahasiswa();
            }
        });
    }
    
    public String getInputNama() {
        return inputNama.getText();
    }
    
    public String getInputNIM() {
        return inputNIM.getText();
    }
    public String getInputEmail() {
        return inputEmail.getText();
    }
    
    public String getInputPassword() {
        return inputPassword.getText();
    }
    public String getInputAngkatan() {
        return inputAngkatan.getText();
    }
    
}