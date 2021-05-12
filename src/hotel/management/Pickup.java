/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author yuvrajsingh
 */
public class Pickup  extends JFrame implements ActionListener{
    
    Choice c1;
    JCheckBox c2;
    JButton b1,b2;
    JTable t1;
    
    
    Pickup() {
        
        // Heading
        JLabel l1 = new JLabel("Pickup");
        l1.setBounds(400,30,100,30);
        l1.setFont(new Font("Tahoma" , Font.BOLD , 18));
        add(l1);
        
        
        // Type of car
        JLabel l2 = new JLabel("Type of car");
        l2.setBounds(50,100,100,20);
        add(l2);
        
        c1 = new Choice();
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from drivers");
            while(rs.next()) {
                c1.add(rs.getString("carCompany"));
            }
        } catch (Exception e) {
            
        }
        c1.setBounds(150,100,200,25);
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
        
        // Name
        JLabel l3 = new JLabel("Driver Name");
        l3.setBounds(10,160,100,20);
        add(l3);
        
        // Driver age
        JLabel l4 = new JLabel("Driver age");
        l4.setBounds(200,160,100,20);
        add(l4);

        
        // Gender
        JLabel l6 = new JLabel("Gender");
        l6.setBounds(500,160,100,20);
        add(l6);
        
         // Car type
        JLabel l7 = new JLabel("Car Type");
        l7.setBounds(750,160,100,20);
        add(l7);
        
        setLayout(null);
        setBounds(500,200, 1000, 650);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1) {
            try{
                String str = "select * from drivers where carCompany ='"+c1.getSelectedItem()+"'";

                conn c = new conn();
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception e) {
                   System.out.println(e);
            }
        } else if(ae.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    
     public static void main(String args[]){
        new Pickup().setVisible(true);
    }
}
