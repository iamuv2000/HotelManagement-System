/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author yuvrajsingh
 */
public class Reception  extends JFrame implements ActionListener{
    
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
    
    Reception(){
        
        // NEW CUSTOMER FORM
        b1 = new JButton("New customer form");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.setBounds(10, 30,200, 30);
        b1.addActionListener(this);
        add(b1);
        
        // ROOM
        b2 = new JButton("Room");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.setOpaque(true);
        b2.setBorderPainted(false);
        b2.setBounds(10, 80,200, 30);
        b2.addActionListener(this);
        add(b2);
        
        
        // DEPARTMENT
        b3 = new JButton("Department");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.white);
        b3.setOpaque(true);
        b3.setBorderPainted(false);
        b3.setBounds(10, 130 ,200, 30);
        b3.addActionListener(this);
        add(b3);
        
        // All employee info
        b4 = new JButton("All empolyee info");
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.white);
        b4.setOpaque(true);
        b4.setBorderPainted(false);
        b4.setBounds(10, 180,200, 30);
        b4.addActionListener(this);
        add(b4);
        
        
        // Customer info
        b5 = new JButton("Customer info");
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.white);
        b5.setOpaque(true);
        b5.setBorderPainted(false);
        b5.setBounds(10, 230 , 200, 30);
        b5.addActionListener(this);
        add(b5);
        
        
        // Manager info
        b6 = new JButton("Manager info");
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.white);
        b6.setOpaque(true);
        b6.setBorderPainted(false);
        b6.setBounds(10, 280 , 200, 30);
        b6.addActionListener(this);
        add(b6);
        
        // Checkout
        b7 = new JButton("Checkout");
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.white);
        b7.setOpaque(true);
        b7.setBorderPainted(false);
        b7.setBounds(10, 330 , 200, 30);
        b7.addActionListener(this);
        add(b7);
        
        // Update check status
        b8 = new JButton("Update check status");
        b8.setBackground(Color.BLACK);
        b8.setForeground(Color.white);
        b8.setOpaque(true);
        b8.setBorderPainted(false);
        b8.setBounds(10, 380 , 200, 30);
        b8.addActionListener(this);
        add(b8);
        
        // Update room status
        b9 = new JButton("Update room status");
        b9.setBackground(Color.BLACK);
        b9.setForeground(Color.white);
        b9.setOpaque(true);
        b9.setBorderPainted(false);
        b9.setBounds(10, 430 , 200, 30);
        b9.addActionListener(this);
        add(b9);
        
        // Pick up service
        b10 = new JButton("Pick up service");
        b10.setBackground(Color.BLACK);
        b10.setForeground(Color.white);
        b10.setOpaque(true);
        b10.setBorderPainted(false);
        b10.setBounds(10, 480 , 200, 30);
        b10.addActionListener(this);
        add(b10);
        
        
        // Search room
        b11 = new JButton("Search room");
        b11.setBackground(Color.BLACK);
        b11.setForeground(Color.white);
        b11.setOpaque(true);
        b11.setBorderPainted(false);
        b11.setBounds(10, 530 , 200, 30);
        b11.addActionListener(this);
        add(b11);
        
        // Logout
        b12 = new JButton("Logout");
        b12.setBackground(Color.BLACK);
        b12.setForeground(Color.white);
        b12.setOpaque(true);
        b12.setBorderPainted(false);
        b12.setBounds(10, 580 , 200, 30);
        b12.addActionListener(this);
        add(b12);
        
//        getContentPane().setBackground(color.WHITE)
        
        setLayout(null);
        setBounds(400,200,800,650);
        setVisible(true);
        
    }
    
    
    public void actionPerformed(ActionEvent ae) {
        if(b1 == ae.getSource()){
             new AddCustomer().setVisible(true);
            this.setVisible(false); 
        } else if (b2 == ae.getSource()){
            new Room().setVisible(true);
            this.setVisible(false);
        } else if (b3 == ae.getSource()){
            new Department().setVisible(true);
            this.setVisible(false);
        } else if (b4 == ae.getSource()){
            new EmployeeInfo().setVisible(true);
            this.setVisible(false);
        } else if (b5 == ae.getSource()){
            new CustomerInfo().setVisible(true);
            this.setVisible(false);
        } else if (b6 == ae.getSource()){
            new ManagerInfo().setVisible(true);
            this.setVisible(false);
        } else if (b7 == ae.getSource()){
            new Checkout().setVisible(true);
            this.setVisible(false);
        } else if (b8 == ae.getSource()){
            new UpdateCheck().setVisible(true);
            this.setVisible(false);
        } else if (b9 == ae.getSource()){
            new UpdateRoom().setVisible(true);
            this.setVisible(false);
        } else if (b10 == ae.getSource()){
            new Pickup().setVisible(true);
            this.setVisible(false);
        } else if (b11 == ae.getSource()){
            new SearchRoom().setVisible(true);
            this.setVisible(false);
        } else if (b12 == ae.getSource()){
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new Reception().setVisible(true);
    }
    
}
