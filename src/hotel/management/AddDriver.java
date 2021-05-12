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
import javax.swing.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener{
    
    JTextField t1, t2, t3;
    JRadioButton r1, r2;

    
    AddDriver(){  
        // TITLE
        JLabel title = new JLabel("Add driver details");
        title.setFont(new Font("Tohoma" , Font.PLAIN , 20));
        title.setBounds(80,0,500,100);
        add(title);
        
        // NAME
        JLabel name = new JLabel("Name");
        name.setFont(new Font("Tohoma" , Font.PLAIN , 17));
        name.setBounds(60,90,120,30);
        add(name);
        
        t1 = new JTextField();
        t1.setBounds(200, 90,150,30);
        add(t1);
        
        // AGE
        JLabel age = new JLabel("Age");
        age.setFont(new Font("Tohoma" , Font.PLAIN , 17));
        age.setBounds(60,120,120,30);
        add(age);
        
        t2 = new JTextField();
        t2.setBounds(200, 120,150,30);
        add(t2);
        
        // GENDER
        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Tohoma" , Font.PLAIN , 17));
        gender.setBounds(60,150,120,30);
        add(gender);
        
        r1 = new JRadioButton("M");
        r1.setFont(new Font("Tohoma" , Font.PLAIN , 14));
        r2 = new JRadioButton("F");
        r2.setFont(new Font("Tohoma" , Font.PLAIN , 14));
        
        
        r1.setBounds(200,150,70,30);
        add(r1);
        
        r2.setBounds(270,150,70,30);
        add(r2);
        
        // CAR COMPANY
        JLabel car = new JLabel("Car Company");
        car.setFont(new Font("Tohoma" , Font.PLAIN , 17));
        car.setBounds(60,190,120,30);
        add(car);
        
        t3 = new JTextField();
        t3.setBounds(200, 190,150,30);
        add(t3);
        
        
         // BUTTON
        JButton b1 = new JButton("Add Driver");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.setBounds(200, 300, 150, 30);
        b1.addActionListener(this);
        add(b1);
        
        setLayout(null);
        setBounds(400,200,600,550);
        setVisible(true);
        
    }

    
    public void actionPerformed(ActionEvent ae) {
       String name = t1.getText();
       String age = t2.getText();

       String gender = null;
       if(r1.isSelected()) {
           gender = "M";
       } else if(r2.isSelected()){
            gender = "F";
       }
       String carCompany = t3.getText();
       conn c = new conn();
       String str = "insert into drivers values('"+name+"', '"+age+"', '"+gender+"', '"+carCompany+"')";
       try{
           c.s.executeUpdate(str);
           JOptionPane.showMessageDialog(null, "Successfully added driver");
           this.setVisible(false);
       } catch (Exception e) {
           System.out.println(e);
       }
    }
    
    
    public static void main(String[] args) {
        new AddDriver().setVisible(true);
    }
    
}
