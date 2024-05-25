package View.Mahasiswa;

import Controller.ControllerMahasiswa;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class InputDataMahasiswa extends JFrame{
    ControllerMahasiswa controller;
    
    JLabel header = new JLabel("Input Mahasiswa");
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
        setTitle("Edit Mahasiswa");
        setSize(560, 610);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(null);
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(238,130,238));

        add(header);
        add(labelInputNama);
        add(labelInputNIM);
        add(labelInputEmail);
        add(labelInputPassword);
        add(labelInputAngkatan);
        add(inputNama);
        add(inputNIM);
        add(inputEmail);
        add(inputPassword);
        add(inputAngkatan);
        add(tombolTambah);
        add(tombolKembali);

        header.setBounds(20, 8, 440, 24);
        labelInputNama.setBounds(20, 32, 440, 24);
        inputNama.setBounds(18, 56, 430, 36);
        labelInputNIM.setBounds(20, 96, 440, 24);
        inputNIM.setBounds(18, 120, 430, 36);
        labelInputEmail.setBounds(20, 160, 440, 24);
        inputEmail.setBounds(18, 196, 430, 36);
        labelInputPassword.setBounds(18, 244, 440, 24);
        inputPassword.setBounds(18, 272, 430, 24);
        labelInputAngkatan.setBounds(18, 300, 440, 24);
        inputAngkatan.setBounds(18, 338, 430, 36);
        
        tombolKembali.setBounds(28, 400, 195, 40);
        tombolTambah.setBounds(240, 400, 195, 40);
        
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