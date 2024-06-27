package View.Dosen;

import Controller.ControllerDosen;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class InputDataDosen extends JFrame {
    
    ControllerDosen controller;
    
    JLabel header = new JLabel("INPUT DOSEN");
    JLabel labelInputNama = new JLabel("Nama");
    JLabel labelInputNohp = new JLabel("No Hp");
    JLabel labelInputEmail = new JLabel("Email");
    
    JTextField inputNama = new JTextField();
    JTextField inputNohp = new JTextField();
    JTextField inputEmail = new JTextField();
    
    JButton tombolTambah = new JButton("Tambah Dosen");
    JButton tombolKembali = new JButton("Kembali");

    public InputDataDosen() {
        
        setVisible(true);
        setTitle("Input Dosen");
        setSize(560, 610);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        
        add(header);
        header.setBounds(175, 25, 440, 30);
        header.setFont(new Font("Times New Roman", Font.BOLD, 28));
        add(labelInputNama);
        labelInputNama.setBounds(55, 85, 430, 24);
        add(labelInputNohp);
        labelInputNohp.setBounds(55, 145, 430, 24);
        add(labelInputEmail);
        labelInputEmail.setBounds(55, 205, 430, 24);
        
        add(inputNama);
        inputNama.setBounds(55, 110, 430, 30);
        add(inputNohp);
        inputNohp.setBounds(55, 170, 430, 30);
        add(inputEmail);
        inputEmail.setBounds(55, 230, 430, 30);
        
        add(tombolTambah);
        tombolTambah.setBounds(70, 450, 195, 38);
        tombolTambah.setForeground(new Color(255,255,255));
        tombolTambah.setBackground(new Color(50,205,50));
        add(tombolKembali);
        tombolKembali.setBounds(280, 450, 195, 38);
        tombolKembali.setForeground(new Color(255,255,255));
        tombolKembali.setBackground(new Color(255,0,0));
        
        controller = new ControllerDosen(this);

        tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewDataDosen();
            }
        });

        tombolTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.insertDosen();
            }
        });
    }
    
    public String getInputNama() {
        return inputNama.getText();
    }
    
    public String getInputNoHp() {
        return inputNohp.getText();
    }
    
    public String getInputEmail() {
        return inputEmail.getText();
    }
}