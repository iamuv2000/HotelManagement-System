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

import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UpdateCheck extends JFrame implements ActionListener{
    
    JButton b1,b2,b3;
    Choice c1;
    JTextField t1,t2,t3,t4,t5;
    
    UpdateCheck(){
            
        // Heading
        JLabel l1 = new JLabel("Check-in Details");
        l1.setFont(new Font("Tahoma" , Font.BOLD , 20));
        l1.setBounds(50,30,200,30);
        add(l1);
        
        // Customer id
        JLabel l2 = new JLabel("Customer-ID");
        l2.setBounds(30,80,100,20);
        add(l2);
        
        c1 = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                c1.add(rs.getString("number"));
            }
        } catch (Exception e) {
            
        }
        c1.setBounds(200,80,150,25);
        add(c1);
        
        // Room number
        JLabel l3 = new JLabel("Room number");
        l3.setBounds(30,120,100,20);
        add(l3);
        
        t1 = new JTextField();
        t1.setBounds(200,120,150,25);
        add(t1);
        
        // Name
        JLabel l4 = new JLabel("Name");
        l4.setBounds(30,160,100,20);
        add(l4);
        
        t2 = new JTextField();
        t2.setBounds(200,160,150,25);
        add(t2);
        
        // CheckIN
        JLabel l5 = new JLabel("Check-In");
        l5.setBounds(30,200,100,20);
        add(l5);
        
        t3 = new JTextField();
        t3.setBounds(200,200,150,25);
        add(t3);
        
        // Amount paid
        JLabel l6 = new JLabel("Amount paid");
        l6.setBounds(30,240,100,20);
        add(l6);
        
        t4 = new JTextField();
        t4.setBounds(200,240,150,25);
        add(t4);
        
        
        // Pending amount
        JLabel l7 = new JLabel("Pending amount");
        l7.setBounds(30,300,100,20);
        add(l7);
        
        t5 = new JTextField();
        t5.setBounds(200,300,150,25);
        add(t5);
        
        
         //Check button
        b1 = new JButton("Check");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.setBounds(30,340,100,30);
        b1.addActionListener(this);
        add(b1);
        
        
        //Update button
        b2 = new JButton("Update");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.setOpaque(true);
        b2.setBorderPainted(false);
        b2.setBounds(150,340,100,30);
        b2.addActionListener(this);
        add(b2);
        
         //Back button
        b3 = new JButton("Back");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.white);
        b3.setOpaque(true);
        b3.setBorderPainted(false);
        b3.setBounds(270,340,100,30);
        b3.addActionListener(this);
        add(b3);
        
        setLayout(null);
        setBounds(500,200,1000,500);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1) {
            String roomNumber = null;
            int amountPaid;
            String deposit = null;
            String price = null;
            String id = c1.getSelectedItem();
            conn c = new conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from customer where number = '"+id+"'");
                while(rs.next()) {
                    t1.setText(rs.getString("number"));
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("checkin"));
                    t4.setText(rs.getString("deposit"));
                    roomNumber = rs.getString("roomNumber");
                    deposit = rs.getString("deposit");
                }
                ResultSet rs2 = c.s.executeQuery("select * from rooms where roomNumber = '"+roomNumber+"'");
                while(rs2.next()){
                  price = rs2.getString("price");
                  amountPaid = Integer.parseInt(price) - Integer.parseInt(deposit);
                  t5.setText(Integer.toString(amountPaid));
                }
                

            } catch(Exception e) {
                
            }
            
        } else if (ae.getSource() == b2) {
            try {
                
                conn c = new conn();
                String roomNumber = t1.getText();
                String availabilty = t2.getText();
                String cleaningStatus = t3.getText();
                
                String str = "update rooms set availabilty = '" + availabilty +"' , cleaningStatus = '" + cleaningStatus+ "' where roomNumber = '" + roomNumber+"'" ;
                
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Updated successfully!");
                new Reception().setVisible(true);
                this.setVisible(false);
            } catch(Exception e) {
                
            }
            
            
        } else if(ae.getSource() == b3) {
            new Reception().setVisible(true);
            this.setVisible(false); 
        }
    }
    
    public static void main(String args[]) {
        new UpdateCheck().setVisible(true);
    }
}
