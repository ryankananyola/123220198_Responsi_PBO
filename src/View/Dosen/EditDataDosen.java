package View.Dosen;

import Controller.ControllerDosen;
import Model.Dosen.ModelDosen;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EditDataDosen extends JFrame {
    
    ControllerDosen controller;
    
    JLabel header = new JLabel("EDIT DOSEN");
    JLabel labelInputNama = new JLabel("Nama");
    JLabel labelInputNohp = new JLabel("No Hp");
    JLabel labelInputEmail = new JLabel("Email");
    JTextField inputNama = new JTextField();
    JTextField inputNohp = new JTextField();
    JTextField inputEmail = new JTextField();
    JButton tombolEdit = new JButton("Edit Dosen");
    JButton tombolKembali = new JButton("Kembali");

    public EditDataDosen(ModelDosen dosen) {
        setVisible(true);
        setTitle("Edit Dosen");
        setSize(560, 610);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(null);
        setLocationRelativeTo(null);

        add(header);
        header.setBounds(180, 25, 440, 30);
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
        
        inputNama.setText(dosen.getNama());
        inputNohp.setText(dosen.getNohp());
        inputEmail.setText(dosen.getEmail());
        
        add(tombolEdit);
        tombolEdit.setBounds(70, 450, 195, 38);
        tombolEdit.setForeground(new Color(255,255,255));
        tombolEdit.setBackground(new Color(50,205,50));
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

        tombolEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.editDosen(dosen.getId());
            }
        });
    }
   
    public String getInputNama() {
        return inputNama.getText();
    }
    
    public String getInputNohp() {
        return inputNohp.getText();
    }
    
    public String getInputEmail(){
        return inputEmail.getText();
    }
}