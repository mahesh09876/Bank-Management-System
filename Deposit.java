/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    
    JLabel l1;
    JButton b1,b2;
    JTextField t1;
    String pinnumber;
    Deposit(String pinnumber){
        
        this.pinnumber=pinnumber;
        
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l3=new JLabel(i3);
        l3.setBounds(0,0,900,900);
        add(l3);
        
        l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        
        b1 = new JButton("DEPOSIT");
        b2 = new JButton("BACK");
        
        setLayout(null);
        
        l1.setBounds(170,300,400,20);
        l3.add(l1);
        
        t1.setBounds(170,350,320,20);
        l3.add(t1);
        
        b1.setBounds(355,485,150,30);
        l3.add(b1);
        
        b2.setBounds(355,520,150,30);
        l3.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String amt=t1.getText();
            Date date=new Date();
            if(amt.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposit");
            }
            else{
                try{
                   Conn c=new Conn();
                String query="insert into bank values ('"+pinnumber+"', '"+date+"', 'Deposit', '"+amt+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amt+"Deposited Successful");
                 setVisible(false);
                 new Transactions(pinnumber).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                }
                
            }
        }
        else if(ae.getSource()==b2){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
            
        }
    }
    
    public static void main(String[] args){
        
        new Deposit("");
        
    }
    
}
