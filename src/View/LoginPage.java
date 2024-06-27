package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;

public class LoginPage extends JFrame implements ActionListener {
    
    JLabel Header = new JLabel("Selamat Datang");
    JLabel SubHeader1 = new JLabel("Silahkan masuk untuk melanjutkan.");
    JLabel labelUsername = new JLabel("Username");
    JLabel labelPassword = new JLabel("Password");
    
    JTextField inputUsername = new JTextField();
    JPasswordField inputPassword = new JPasswordField();
    
    JButton tombolLogin = new JButton("Login");
    
    public LoginPage(){
        setVisible(true);
        setTitle("Halaman Login");
        setSize(560, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(null);
        setLocationRelativeTo(null);
        
        getContentPane().setBackground(new Color(255, 215, 0));
        
        add(Header);
        Header.setFont(new Font("Times New Roman", Font.BOLD, 32));
        Header.setBounds(50,50,300,35);
        add(SubHeader1);
        SubHeader1.setFont(new Font("Times New Roman", Font.BOLD, 18));
        SubHeader1.setBounds(50,90,300,35);
        
         add(labelUsername);
        //username.setFont(new Font("Arial", Font.PLAIN, 15));
        labelUsername.setBounds(50,150,150,35);
        
        add(labelPassword);
        //username.setFont(new Font("Arial", Font.PLAIN, 15));
        labelPassword.setBounds(50,240,150,35);

        
    // tampilkan text field
        add(inputUsername);
        inputUsername.setBounds(50,190,435,35);
        
        add(inputPassword);
        inputPassword.setBounds(50,280,435,35);
   
        
         // tampilkan login
        add(tombolLogin);
        tombolLogin.setBounds(50, 375, 435, 35);
        tombolLogin.addActionListener(this);
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       try {
            String username = inputUsername.getText();
            String password = new String(inputPassword.getPassword());
            
            if(username.equals("")&& password.equals("")){
                throw new Exception("Username dan Password Belum diisi");
            } else if(password.equals("")){
                throw new Exception("Password Belum diisi");
            } else if (username.equals("")  ){
                throw new Exception("Username Belum diisi");
            }
            
            new HalamanUtama(username);
            this.dispose();
            
        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, error.getMessage());
        }
    }
}
