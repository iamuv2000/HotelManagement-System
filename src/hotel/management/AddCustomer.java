/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management;

import java.awt.Color;
import java.awt.Font;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

/**
 *
 * @author yuvrajsingh
 */
public class AddCustomer extends JFrame implements ActionListener{
    
    JTextField t1, t2, t3, t4, t5;
    JButton b1,b2;
    JComboBox c1;
    Choice c2;
    JRadioButton r1, r2;
   
    
    AddCustomer(){
        
        // HEADING
        JLabel l1  = new JLabel("New customer form");
        l1.setBounds(100,20,300,30);
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Tahoma" , Font.BOLD , 20));
        add(l1);
        
        // ID
        JLabel l2 = new JLabel("ID");
        l2.setBounds(35,80,100,20);
        add(l2);
        
        c1 = new JComboBox(new String[]{"Passport" , "Voter-id", "Driving License" , "Aadhar Card"});
        c1.setBounds(200,80,150,20);
        add(c1);
        
        // NUMBER
        JLabel l3 = new JLabel("Number");
        l3.setBounds(35,120,100,20);
        add(l3);
        
        t1 = new JTextField();
        t1.setBounds(200,120,150,25);
        add(t1);
        
        // Name
        JLabel l4 = new JLabel("Name");
        l4.setBounds(35,160,100,20);
        add(l4);
        
        t2 = new JTextField();
        t2.setBounds(200,160,150,25);
        add(t2);
        
        // Gender
        JLabel l5 = new JLabel("Gender");
        l5.setBounds(35,200,100,20);
        add(l5);
        
        r1 = new JRadioButton("M");
        r1.setBounds(200,200,60,25);
        add(r1);
        
        r2 = new JRadioButton("F");
        r2.setBounds(270,200,60,25);
        add(r2);
        
        
        
        // COUNTRY
        JLabel l6 = new JLabel("Country");
        l6.setBounds(35,240,100,20);
        add(l6);
        
        t3 = new JTextField();
        t3.setBounds(200,240,150,25);
        add(t3);
        
        // ALLOCATED ROOM NUMBER
        JLabel l7 = new JLabel("Allocated room number");
        l7.setBounds(35,280,150,20);
        add(l7);
        
        c2 = new Choice();
        try{
            conn c = new conn();
            String str = "select * from rooms";
            ResultSet rs = c.s.executeQuery(str);
            
            while(rs.next()){
                c2.add(rs.getString("roomNumber"));
            }
            
        } catch(Exception e) {
            
        }
        
        c2.setBounds(200,280,150,25);
        add(c2);
        
        
        // CHECKED IN 
        JLabel l8 = new JLabel("Checked In");
        l8.setBounds(35,320,150,20);
        add(l8);
        
        t4 = new JTextField();
        t4.setBounds(200,320,150,25);
        add(t4);
        
        // DEPOSIT
        JLabel l9 = new JLabel("Deposit");
        l9.setBounds(35,360,150,10);
        add(l9);
        
        t5 = new JTextField();
        t5.setBounds(200,360,150,25);
        add(t5);
        
        // ADD CUSTOMER BUTTON
        b1 = new JButton("Add customer");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.setBounds(50,410,120,25);
        b1.addActionListener(this);
        add(b1);
        
        // BACK BUTTON
        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.setOpaque(true);
        b2.setBorderPainted(false);
        b2.setBounds(200,410,120,25);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.WHITE);
        
        
        setLayout(null);
        setBounds(500,200,900,500);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        String id = (String) c1.getSelectedItem();
        String number =  t1.getText();
        String name =  t2.getText();
        String gender = null;
        if(r1.isSelected()){
            gender = "M";
        } else if(r2.isSelected()){
            gender = "F";
        }
        String country = t3.getText();
        String roomNumber = c2.getSelectedItem();
        String status = t4.getText();
        String deposit = t5.getText();
        
        conn c = new conn();
        String str = "insert into customer values('"+id+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+roomNumber+"', '"+status+"', '"+deposit+"')";
        String updateQuery = "update rooms set availabilty ='Occipied' where roomNumber = '"+roomNumber+"'";
        try{
           c.s.executeUpdate(str);
           c.s.executeUpdate(updateQuery);
           JOptionPane.showMessageDialog(null, "Successfully added customer");
           this.setVisible(false);
       } catch (Exception e) {
           System.out.println(e);
       }
        
    }
    
    public static void main(String args[]){
        new AddCustomer().setVisible(true);
    }

}
