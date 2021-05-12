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

public class AddEmployee extends JFrame implements ActionListener{
    
    JTextField t1, t2, t3, t4, t5;
    JRadioButton r1, r2;
    JComboBox c1;
    JButton b1;
    
    AddEmployee(){  
        
        // TITLE
        JLabel title = new JLabel("Add employee details");
        title.setFont(new Font("Tohoma" , Font.PLAIN , 20));
        title.setBounds(80,0,500,100);
        add(title);
        
        // NAME
        JLabel name = new JLabel("Name");
        name.setFont(new Font("Tohoma" , Font.PLAIN , 17));
        name.setBounds(60,90,120,30);
        add(name);
        
        
        t1 = new JTextField();
        t1.setBounds(200,90,150,30);
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
          
        
        // JOB
        JLabel job = new JLabel("Job");
        job.setFont(new Font("Tohoma" , Font.PLAIN , 17));
        job.setBounds(60,180,120,30);
        add(job);
        
        
        String str[] = {"Receptionist" , "Waiter" , "Kitchen Staff" , "Room Cleaning staff" , "Accountant" , "Manager"};
        c1 = new JComboBox(str);
        c1.setBounds(200,180,120,30);
        add(c1);
        
        // SALARY
        JLabel salary = new JLabel("Salary");
        salary.setFont(new Font("Tohoma" , Font.PLAIN , 17));
        salary.setBounds(60,210,120,30);
        add(salary);
        
        t3 = new JTextField();
        t3.setBounds(200,210,150,30);
        add(t3);
        
        // PHONE
        JLabel phone = new JLabel("Phone");
        phone.setFont(new Font("Tohoma" , Font.PLAIN , 17));
        phone.setBounds(60,240,120,30);
        add(phone);
        
        t4 = new JTextField();
        t4.setBounds(200,240,150,30);
        add(t4);
        
        // EMAIL
        JLabel email = new JLabel("Email");
        email.setFont(new Font("Tohoma" , Font.PLAIN , 17));
        email.setBounds(60,270,120,30);
        add(email);
        
        t5 = new JTextField();
        t5.setBounds(200,270,150,30);
        add(t5);
        
        // BUTTON
        JButton b1 = new JButton("Add Employee");
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
       String salary = t3.getText();
       String phone = t4.getText();
       String email = t5.getText();
       String gender = null;
       if(r1.isSelected()) {
           gender = "M";
       } else if(r2.isSelected()){
            gender = "F";
       }
       String job = (String)c1.getSelectedItem();
       
       conn c = new conn();
       String str = "insert into employee values('"+name+"', '"+age+"', '"+salary+"', '"+phone+"', '"+email+"', '"+gender+"', '"+job+"')";
       try{
           c.s.executeUpdate(str);
           JOptionPane.showMessageDialog(null, "Successfully added employee");
           this.setVisible(false);
       } catch (Exception e) {
           System.out.println(e);
       }
    }
    
    public static void main(String[] args) {
        new AddEmployee().setVisible(true);
    }
}
