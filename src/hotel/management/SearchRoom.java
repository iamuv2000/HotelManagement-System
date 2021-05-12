/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author yuvrajsingh
 */
public class SearchRoom  extends JFrame implements ActionListener{
    
    JComboBox c1;
    JCheckBox c2;
    JButton b1,b2;
    JTable t1;
    
    
    SearchRoom() {
        
        // Heading
        JLabel l1 = new JLabel("Search for room");
        l1.setBounds(400,30,100,30);
        l1.setFont(new Font("Tahoma" , Font.BOLD , 18));
        add(l1);
        
        
        // Room bed type
        JLabel l2 = new JLabel("Room bed type");
        l2.setBounds(50,100,100,20);
        add(l2);
        
        c1 = new JComboBox(new String[]{"Single" , "Double"});
        c1.setBounds(150,100,150,25);
        add(c1);
        
        c2 = new JCheckBox("Only Display Available");
        c2.setBounds(650,100,200,25);
        add(c2);
        
        t1 = new JTable();
        t1.setBounds(0,200,1000,200);
        add(t1);
        
        b1 = new JButton("Submit");
        b1.setBounds(300,520,120,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(550,520,120,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.setOpaque(true);
        b2.setBorderPainted(false);
        b2.addActionListener(this);
        add(b2);
        
        // TABLE LABELS
        JLabel l3 = new JLabel("Room number");
        l3.setBounds(10,160,100,20);
        add(l3);
        
        // AVAILABLE
        JLabel l4 = new JLabel("Availability");
        l4.setBounds(200,160,100,20);
        add(l4);
        
        // Cleaning status
        JLabel l5 = new JLabel("Cleaned");
        l5.setBounds(400,160,100,20);
        add(l5);
        
        // Price
        JLabel l6 = new JLabel("Price");
        l6.setBounds(600,160,100,20);
        add(l6);
        
         // Bed type
        JLabel l7 = new JLabel("Bed type");
        l7.setBounds(800,160,100,20);
        add(l7);
        
        setLayout(null);
        setBounds(500,200, 1000, 650);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1) {
            try{
                String str = "select * from rooms where bedType ='"+c1.getSelectedItem()+"'";
                String str2 = "select * from rooms where availabilty = 'Available' AND bedType ='"+c1.getSelectedItem()+"'";

                conn c = new conn();
               
                
                if(c2.isSelected()){
                    ResultSet rs2 = c.s.executeQuery(str2);
                    t1.setModel(DbUtils.resultSetToTableModel(rs2));
                } else {
                     ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
                }
                
            } catch (Exception e) {
                   System.out.println(e);
            }
        } else if(ae.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    
     public static void main(String args[]){
        new SearchRoom().setVisible(true);
    }
}
