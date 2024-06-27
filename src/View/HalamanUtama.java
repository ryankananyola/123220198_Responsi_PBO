package View;


import View.Dosen.ViewDataDosen;
import View.Mahasiswa.ViewDataMahasiswa;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class HalamanUtama extends JFrame implements ActionListener {
    
    JLabel Header = new JLabel();
    JLabel SubHeader = new JLabel("Silahkan pilih untuk melanjutkan");
    
    JButton mahasiswa = new JButton("Mahasiswa");
    JButton dosen = new JButton("Dosen");
    JButton keluar = new JButton("Logout");
    
    String username;
    
    public HalamanUtama(){
        this.username = Session.getUsername();
        
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
        Header.setBounds(50,50,400,35);
        add(SubHeader);
        SubHeader.setFont(new Font("Times New Roman", Font.BOLD, 18));
        SubHeader.setBounds(50,90,300,35);
        
    // tampilkan button
        add(mahasiswa);
        mahasiswa.setBounds(50,230,440,35);
        
        add(dosen);
        dosen.setBounds(50,310,440,35);
        
        add(keluar);
        keluar.setBounds(50,390,440,35);
        keluar.setForeground(new Color(255,255,255));
        keluar.setBackground(new Color(255,0,0));
        
    
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
               Session.setUsername(null); 
               new LoginPage();
           }
            
        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, error.getMessage());
        }
    }

}
