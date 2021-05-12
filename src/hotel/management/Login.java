/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management;

/**
 *
 * @author yuvrajsingh
 */

import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame  implements ActionListener{
    
    JLabel l1, l2;
    JTextField t1;
    JButton b1,b2;
    JPasswordField t2;
    
    Login(){
        l1 = new JLabel("Username");
        l1.setBounds(40,20,100,30);
        add(l1);
        
        l2 = new JLabel("Password");
        l2.setBounds(40,70,100,30);
        add(l2);
        
        t1 = new JTextField();
        t1.setBounds(150,20,150,30);
        add(t1);
        
        t2 = new JPasswordField();
        t2.setBounds(150,70,150,30);
        add(t2);
        
        b1 = new JButton("Login");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.setOpaque(true);
        b1.setBorderPainted(false);  
        b1.setBounds(40, 150, 120, 30);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.setOpaque(true);
        b2.setBorderPainted(false);  
        b2.setBounds(180, 150, 120, 30);
        add(b2);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setLayout(null);
        setBounds(500,300,600,400);
        setVisible(true);
    }
    
    
     public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1) {
            String username =   t1.getText();
            String password =   t2.getText();
            
            String str = "select * from login where username = '"+username+"' and password ='"+password+"'";
            conn c = new conn();
            try {
                ResultSet rs = c.s.executeQuery(str);
                if(rs.next()){
                    new Dashboard().setVisible(true); 
                    this.setVisible(false); 
                } else {
                   JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } else if (ae.getSource() == b2){
         System.exit(0);
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}  
