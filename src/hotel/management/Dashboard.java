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


public class Dashboard extends JFrame implements ActionListener{
    
    JMenuBar mb;
    JLabel l1;
    JMenu m1, m2;
    JMenuItem i1,i2,i3,i4;
    
    Dashboard() {
        
        JLabel l1 = new JLabel("HOTEL TRANSYLVANIA WELCOMES YOU");
        l1.setBounds(250,50,600,70);
        l1.setFont(new Font("Tahoma",Font.PLAIN, 25));
        add(l1);
        
        JButton b1 = new JButton("Add Employees");
        b1.setOpaque(true);
        b1.setBounds(250,120,130,50);
        b1.addActionListener(this);
        add(b1);
        
        JButton b2 = new JButton("Add Rooms");
        b2.setOpaque(true);
        b2.setBounds(250,170,130,50);
        b2.addActionListener(this);
        add(b2);
        
        JButton b3 = new JButton("Add Drivers");
        b3.setOpaque(true);
        b3.setBounds(250,210,130,50);
        b3.addActionListener(this);
        add(b3);
        
        JButton b4 = new JButton("Reception");
        b4.setOpaque(true);
        b4.setBounds(250,250,130,50);
        b4.addActionListener(this);
        add(b4);
        
        
        
        setLayout(null);
        setBounds(0,0,1000,1000);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand() == "Add Employees"){
                new AddEmployee().setVisible(true);
        }
        else if(ae.getActionCommand() == "Add Rooms"){
                new AddRooms().setVisible(true);
        } else if(ae.getActionCommand() == "Add Drivers"){
            new AddDriver().setVisible(true);
        }
        else if(ae.getActionCommand() == "Reception"){
            new Reception().setVisible(true);
        }
    }

    
    public static void main(String args[]){
        new Dashboard().setVisible(true);
    }
    
}
