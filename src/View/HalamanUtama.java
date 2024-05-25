
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;


import View.Dosen.ViewDataDosen;
import View.Mahasiswa.ViewDataMahasiswa;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author USER
 */
public class HalamanUtama extends JFrame implements ActionListener {
    
    JLabel Header = new JLabel();
    JLabel SubHeader = new JLabel("Silahkan pilih untuk melanjutkan");
    
    JButton mahasiswa = new JButton("Mahasiswa");
    JButton dosen = new JButton("Dosen");
    JButton keluar = new JButton("Logout");
    
    HalamanUtama(String username){
        setVisible(true);
        setTitle("Halaman Utama");
        setSize(560, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(null);
        setLocationRelativeTo(null);
        
        getContentPane().setBackground(new Color(255, 215, 0));
       
        add(Header);
        Header.setText("Selamat Datang, " + username);
        Header.setFont(new Font("Times New Roman", Font.BOLD, 32));
        Header.setBounds(50,50,300,35);
        add(SubHeader);
        SubHeader.setFont(new Font("Times New Roman", Font.BOLD, 18));
        SubHeader.setBounds(50,90,300,35);
        
    // tampilkan button
        add(mahasiswa);
        mahasiswa.setBounds(50,230,460,35);
        
        add(dosen);
        dosen.setBounds(50,310,460,35);
        
        add(keluar);
        keluar.setBounds(50,390,460,35);
        
    
        mahasiswa.addActionListener(this);
        dosen.addActionListener(this);
        keluar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
           if (e.getSource()==mahasiswa){
               dispose();
               new ViewDataMahasiswa();
           } else if (e.getSource()==dosen){
               dispose();
               new ViewDataDosen();
           } else if(e.getSource()==keluar){
               dispose();
               new LoginPage();
           }
            
        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, error.getMessage());
        }
    }

}
