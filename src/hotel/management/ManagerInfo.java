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
public class ManagerInfo extends JFrame implements ActionListener {
    JTable t1;
    JButton b1, b2;
    
    
    ManagerInfo(){
        t1 = new JTable();
        t1.setBounds(0,40,1000,500);
        add(t1);
        
        // NAME LABEL
        JLabel l1 = new JLabel("Name");
        l1.setBounds(40,10,70,20);
        add(l1);
        
        // AGE LABEL
        JLabel l2 = new JLabel("Age");
        l2.setBounds(170,10,70,20);
        add(l2);
        
        
        // SALARY LABEL
        JLabel l3 = new JLabel("Salary");
        l3.setBounds(290,10,70,20);
        add(l3);
        
        // PHONE LABEL
        JLabel l4 = new JLabel("PHONE");
        l4.setBounds(450,10,70,20);
        add(l4);
        
        // EMAIL LABEL
        JLabel l5 = new JLabel("Email");
        l5.setBounds(590,10,70,20);
        add(l5);
        
        // GENDER LABEL
        JLabel l6 = new JLabel("Gender");
        l6.setBounds(700,10,70,20);
        add(l6);
        
        // Job LABEL
        JLabel l7 = new JLabel("Job");
        l7.setBounds(820,10,70,20);
        add(l7);
        
        
        
        
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
                 String str = "select * from employee where job='Manager'";
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
        new ManagerInfo().setVisible(true);
    }
    
}
