package View.Dosen;

import Controller.ControllerDosen;
import Model.Dosen.ModelDosen;
import View.Dosen.ViewDataDosen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author USER
 */
public class EditDataDosen extends JFrame {
    ControllerDosen controller;
    
    JLabel header = new JLabel("Edit Dosen");
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
        add(labelInputNama);
        add(labelInputNohp);
        add(inputNama);
        add(inputNohp);
        add(inputEmail);
        add(tombolEdit);
        add(tombolKembali);

        header.setBounds(20, 8, 440, 24);
        labelInputNama.setBounds(20, 32, 440, 24);
        inputNama.setBounds(18, 56, 430, 36);
        labelInputNohp.setBounds(20, 96, 440, 24);
        inputNohp.setBounds(18, 120, 430, 36);
        labelInputEmail.setBounds(20, 150, 440, 24);
        inputEmail.setBounds(18, 200, 430, 36);
        tombolKembali.setBounds(28, 170, 195, 40);
        tombolEdit.setBounds(240, 170, 195, 40);
        
        inputNama.setText(dosen.getNama());
        inputNohp.setText(dosen.getNohp());
        
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
    
    public String getInputNIDN() {
        return inputNohp.getText();
    }
}