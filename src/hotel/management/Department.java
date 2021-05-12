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
public class Department  extends JFrame implements ActionListener{
    
    JButton b1,b2;
    JTable t1;
    
    
    Department() {
        
//        // Heading
//        JLabel l1 = new JLabel("Department");
//        l1.setBounds(400,30,100,30);
//        l1.setFont(new Font("Tahoma" , Font.BOLD , 18));
//        add(l1);
        
        
        t1 = new JTable();
        t1.setBounds(0,50,700,350);
        add(t1);
        
        b1 = new JButton("Load Data");
        b1.setBounds(180,400,120,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(380,400,120,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.setOpaque(true);
        b2.setBorderPainted(false);
        b2.addActionListener(this);
        add(b2);
        
        JLabel l3 = new JLabel("Department");
        l3.setBounds(180,10,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Budget");
        l4.setBounds(380,10,100,20);
        add(l4);
        
        setLayout(null);
        setBounds(500,200, 700, 550);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1) {
            try{
                String str = "select * from department";

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
        new Department().setVisible(true);
    }
}
