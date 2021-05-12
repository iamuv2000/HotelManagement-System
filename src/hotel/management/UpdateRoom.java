/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

/**
 *
 * @author yuvrajsingh
 */
public class UpdateRoom  extends JFrame implements ActionListener{
    
    Choice c1;
    JTextField t1,t2,t3;
    JButton b1 , b2 , b3;
    
    UpdateRoom(){
          // Heading
          JLabel l1 = new JLabel("Update room status");
          l1.setFont(new Font("Tahoma" , Font.BOLD , 20));
          l1.setBounds(30,20,250,30);
          add(l1);
          
          // GUEST ID
          JLabel l2 = new JLabel("Guest ID");
          l2.setBounds(30,80,120,20);
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
          JLabel l3 = new JLabel("Room Number");
          l3.setBounds(30,130,120,20);
          add(l3);
          
          t1 = new JTextField();
          t1.setBounds(200,130,150,25);
          add(t1);
          
          // Availability
          JLabel l4 = new JLabel("Availability");
          l4.setBounds(30,180,250,30);
          add(l4);
          
          t2 = new JTextField();
          t2.setBounds(200,180,150,25);
          add(t2);
          
          // Clean status
          JLabel l5 = new JLabel("Clean status");
          l5.setBounds(30,230,250,30);
          add(l5);
          
          t3 = new JTextField();
          t3.setBounds(200,230,150,25);
          add(t3);
          
        //Check button
        b1 = new JButton("Check");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.setBounds(110,300,120,30);
        b1.addActionListener(this);
        add(b1);
        
        
        //Update button
        b2 = new JButton("Update");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.setOpaque(true);
        b2.setBorderPainted(false);
        b2.setBounds(40,350,120,30);
        b2.addActionListener(this);
        add(b2);
        
         //Back button
        b3 = new JButton("Back");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.white);
        b3.setOpaque(true);
        b3.setBorderPainted(false);
        b3.setBounds(220,350,120,30);
        b3.addActionListener(this);
        add(b3);
          
          setLayout(null);
          setBounds(500,200,1000,500);
          setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1) {
            String roomNumber = null;
            String s1 = c1.getSelectedItem();
            conn c = new conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from customer where number = '"+s1+"'");
                while(rs.next()) {
                    t1.setText(rs.getString("roomNumber"));
                    roomNumber = rs.getString("roomNumber");
                }
                ResultSet rs2 = c.s.executeQuery("select * from rooms where roomNumber = '"+roomNumber+"'");
                while(rs2.next()){
                   t2.setText(rs2.getString("availabilty"));
                   t3.setText(rs2.getString("cleaningStatus"));
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
    
    public static void main(String args[]){
        new UpdateRoom().setVisible(true);
    }

    
}
