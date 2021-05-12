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
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AddRooms extends JFrame implements ActionListener{
    
    JTextField t1, t2, t3, t4, t5;
    JComboBox c1, c2 , c3;

    AddRooms(){
        
        // TITLE
        JLabel title = new JLabel("Add rooms");
        title.setFont(new Font("Tohoma" , Font.PLAIN , 20));
        title.setBounds(80,0,500,100);
        add(title);
        
        // Room number
        JLabel name = new JLabel("Room number");
        name.setFont(new Font("Tohoma" , Font.PLAIN , 17));
        name.setBounds(60,90,120,30);
        add(name);
        
        
        t1 = new JTextField();
        t1.setBounds(200,90,150,30);
        add(t1);
        
        // Availability
        JLabel availability = new JLabel("Availability");
        availability.setFont(new Font("Tohoma" , Font.PLAIN , 17));
        availability.setBounds(60,130,120,30);
        add(availability);
        
        
        String avaliableOptions[] = {"Available" , "Not Available"};
        c1 = new JComboBox(avaliableOptions);
        c1.setBounds(200,130,120,30);
        add(c1);
        
        // Cleaning status
        JLabel cleaningStatus = new JLabel("Cleaning Status");
        cleaningStatus.setFont(new Font("Tohoma" , Font.PLAIN , 17));
        cleaningStatus.setBounds(60,160,120,30);
        add(cleaningStatus);
        
        
        String status[] = {"Clean" , "Dirty"};
        c2 = new JComboBox(status);
        c2.setBounds(200,160,120,30);
        add(c2);
        
        // Price
        JLabel price = new JLabel("Price");
        price.setFont(new Font("Tohoma" , Font.PLAIN , 17));
        price.setBounds(60,190,120,30);
        add(price);
        
        
        t2 = new JTextField();
        t2.setBounds(200,190,150,30);
        add(t2);
        
        // Bed type
        JLabel bedType = new JLabel("Bed Type");
        bedType.setFont(new Font("Tohoma" , Font.PLAIN , 17));
        bedType.setBounds(60,220,120,30);
        add(bedType);
        
        
        String bed[] = {"Single" , "Double" , "Queen" , "King"};
        c3 = new JComboBox(bed);
        c3.setBounds(200,220,120,30);
        add(c3);
        
        JButton b1 = new JButton("Add room");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.setBounds(200,270,120,30);
        b1.addActionListener(this);
        add(b1);
        
        setLayout(null);
        setBounds(400,200,600,400);
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae) {
        System.out.println("Adding room...");
        String roomNumber = t1.getText();
        String availability = (String)c1.getSelectedItem();
        String cleaningStatus = (String)c2.getSelectedItem();
        String price = t2.getText();
        String bedType = (String)c3.getSelectedItem();
       conn c = new conn();
        String str = "insert into rooms values('"+roomNumber+"', '"+availability+"', '"+cleaningStatus+"', '"+price+"','"+bedType+"')";
       try{
           c.s.executeUpdate(str);
           JOptionPane.showMessageDialog(null, "Successfully added room");
           this.setVisible(false);
       } catch (Exception e) {
           System.out.println(e);
       }
    }
    
    public static void main(String args[]){
        new AddRooms().setVisible(true);
}
    
}
