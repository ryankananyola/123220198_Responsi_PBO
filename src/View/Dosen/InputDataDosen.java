package View.Dosen;

import Controller.ControllerDosen;
import View.Dosen.ViewDataDosen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class InputDataDosen extends JFrame {
    ControllerDosen controller;
    
    JLabel header = new JLabel("Input Dosen");
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
        add(labelInputNama);
        add(labelInputNohp);
        add(labelInputEmail);
        add(inputNama);
        add(inputNohp);
        add(inputEmail);
        add(tombolTambah);
        add(tombolKembali);

        header.setBounds(20, 8, 440, 24);
        labelInputNama.setBounds(20, 32, 440, 24);
        inputNama.setBounds(18, 56, 430, 36);
        labelInputNohp.setBounds(20, 96, 440, 24);
        inputNohp.setBounds(18, 120, 430, 36);
        labelInputEmail.setBounds(10, 176, 440, 24);
        inputEmail.setBounds(18, 215, 430, 36);
        tombolKembali.setBounds(28, 300, 195, 40);
        tombolTambah.setBounds(240, 300, 195, 40);
        
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
    
    public String getInputNIDN() {
        return inputNohp.getText();
    }
    
    public String getInputEmail() {
        return inputEmail.getText();
    }
    
    
}