/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author yuvrajsingh
 */


public class Room extends JFrame implements ActionListener{
    
    
    JTable t1;
    JButton b1,b2;
    
    Room(){
        t1 = new JTable();
        t1.setBounds(0,40,500,400);
        add(t1);
        
         b1 = new JButton("Load Data");
        b1.setBounds(350,560,120,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(530,560,120,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.setOpaque(true);
        b2.setBorderPainted(false);
        b2.addActionListener(this);
        add(b2);
        
        // ROOM NUMBER LABEL
        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(10,10,70,20);
        add(l1);
        
        // AVAILABILITY LABEL
        JLabel l2 = new JLabel("Availability Status");
        l2.setBounds(100,10,70,20);
        add(l2);
        
        
        // STATUS LABEL
        JLabel l3 = new JLabel("Status");
        l3.setBounds(200,10,70,20);
        add(l3);
        
        // Price LABEL
        JLabel l4 = new JLabel("Price");
        l4.setBounds(300,10,70,20);
        add(l4);
        
        // TYPE LABEL
        JLabel l5 = new JLabel("Type");
        l5.setBounds(400,10,70,20);
        add(l5);
        
        getContentPane().setBackground(Color.white);
        
        setLayout(null);
        setBounds(450,200,1000,650);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
         if(ae.getSource() == b1) {
             try{
                 conn c = new conn();
                 String str = "select * from rooms";
                 ResultSet rs = c.s.executeQuery(str);
                 
                 t1.setModel(DbUtils.resultSetToTableModel(rs));
                 
             } catch (Exception e){
                 
             }
         } else if(ae.getSource() == b2){
             new Reception().setVisible(true);
             this.setVisible(false);
         }
    }
    
    public static void main(String args[]) {
        new Room().setVisible(true);
    }

}
