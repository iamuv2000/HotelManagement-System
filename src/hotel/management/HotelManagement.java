/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author yuvrajsingh
 */

package hotel.management;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class HotelManagement extends JFrame implements ActionListener{
    
    HotelManagement(){
        setBounds(400,400,800,800);
        setSize(800,800);
       
        setLocation(300,300);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./hotel/management/icons/hotel-1.png")); 
        JLabel l1 = new JLabel(i1);
        
        l1.setBounds(0,0,1000,1000);
        add(l1);
        
        JLabel l2 = new JLabel("Hotel Management System");
        l2.setForeground(Color.white);
        l2.setFont(new Font("serif" , Font.BOLD , 50));
        l2.setBounds(10,520, 1000, 70);
        l1.add(l2);
        
        JButton b1 = new JButton("Next");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.setBounds(590, 540, 110, 50);
        b1.addActionListener(this);
        l1.add(b1);
        
        setLayout(null);
        setVisible(true);
       
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        new Login().setVisible(true);
        this.setVisible(false);
    }
    
    public static void main(String[] args) {
        new HotelManagement();
    }
}