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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author yuvrajsingh
 */
public class CustomerInfo extends JFrame implements ActionListener {
    JTable t1;
    JButton b1, b2;
    
    
    CustomerInfo(){
        t1 = new JTable();
        t1.setBounds(0,40,1000,500);
        add(t1);
        
        // Document type LABEL
        JLabel l1 = new JLabel("Document Type");
        l1.setBounds(0,10,100,20);
        add(l1);
        
        // Number LABEL
        JLabel l2 = new JLabel("Number");
        l2.setBounds(140,10,70,20);
        add(l2);
        
        
        // Name LABEL
        JLabel l3 = new JLabel("Name");
        l3.setBounds(250,10,70,20);
        add(l3);
        
        // Gender LABEL
        JLabel l4 = new JLabel("Gender");
        l4.setBounds(380,10,70,20);
        add(l4);
        
        // Country LABEL
        JLabel l5 = new JLabel("Country");
        l5.setBounds(500,10,70,20);
        add(l5);
        
        // Room number LABEL
        JLabel l6 = new JLabel("RoomNumber");
        l6.setBounds(600,10,70,20);
        add(l6);
        
        // Check in LABEL
        JLabel l7 = new JLabel("Checked In");
        l7.setBounds(700,10,70,20);
        add(l7);
        
         // Deposit LABEL
        JLabel l8 = new JLabel("Deposit");
        l8.setBounds(860,10,70,20);
        add(l8);
        
        
        
        
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
        
        getContentPane().setBackground(Color.white);
        
        setLayout(null);
        setBounds(450,200,1000,650);
        setVisible(true);
    } 
    
     public void actionPerformed(ActionEvent ae) {
         if(ae.getSource() == b1) {
             try{
                 conn c = new conn();
                 String str = "select * from customer";
                 ResultSet rs = c.s.executeQuery(str);
                 
                 t1.setModel(DbUtils.resultSetToTableModel(rs));
                 
             } catch (Exception e){
                 
             }
         } else if(ae.getSource() == b2){
             new Reception().setVisible(true);
             this.setVisible(false);
         }
     }
    
    public static void main(String args[]){
        new CustomerInfo().setVisible(true);
    }
    
}
