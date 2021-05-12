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

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class Checkout extends JFrame implements ActionListener{
    
    Choice c1;
    JTextField t1;
    JButton b1,b2, b3;
    
    Checkout(){
        
        // Heading
        JLabel l1 = new JLabel("Check out");
        l1.setBounds(50,20,100,30);
        l1.setFont(new Font("Tahoma" , Font.BOLD , 18));
        add(l1);
        
        
        // Customer id
        JLabel l2 = new JLabel("Customer id");
        l2.setBounds(30,80,100,30);
        add(l2);
        
        c1 = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                c1.add(rs.getString("number"));
                
            }
        } catch(Exception e){
            System.out.println(e);
        }
        c1.setBounds(150,80,150,30);
        add(c1);
        
        // Room number
        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(30,130,100,30);
        add(l3);
        
        t1 = new JTextField();
        t1.setBounds(150,130,150,30);
        add(t1);
        
        b1 = new JButton("Checkout");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.setBounds(30,200,120,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.setOpaque(true);
        b2.setBorderPainted(false);
        b2.setBounds(170,200,120,30);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Check");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.white);
        b3.setOpaque(true);
        b3.setBorderPainted(false);
        b3.setBounds(310,80,20,20);
        b3.addActionListener(this);
        add(b3);
        
        setLayout(null);
        setBounds(500,200,800,300);
        setVisible(true);
       
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1){
            String id = c1.getSelectedItem();
            String roomNumber = t1.getText();
            String str = "delete from customer where number  = '" + id+"'";
            String str2 = "update rooms set availabilty = 'Available' where roomNumber  = '" + roomNumber+"'";

            conn c = new conn();
            try {
                c.s.executeUpdate(str);
                c.s.executeUpdate(str2);
                JOptionPane.showMessageDialog(null, "Customer checked out!");
            } catch(Exception e) {
                System.out.println(e);
            }
            
        } else if(ae.getSource() == b2) {
            new Reception().setVisible(true);
            this.setVisible(false);
        } else if(ae.getSource() == b3){
            String id = c1.getSelectedItem();
            conn c = new conn();
            try{
               ResultSet rs = c.s.executeQuery("select * from customer where number = '" +id+"'" );
               while(rs.next()){
                   t1.setText(rs.getString("roomNumber"));
               }
            } catch (Exception e) {
                
            }
        }
    }

    
    public static void main(String args[]){
        new Checkout().setVisible(true);
    }
    
}
