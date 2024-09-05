/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame{
    
    String pin;
    
    MiniStatement(String pin){
        this.pin=pin;
        
        setTitle("Mini Statement");
        
        setLayout(null);
        
        JLabel mini=new JLabel();
        add(mini);
        
        JLabel bank=new JLabel("State Bank of India");
        bank.setBounds(150,20,150,20);
        add(bank);
        
        JLabel card=new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        JLabel balance=new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from login where pin='"+pin+"'");
            while(rs.next()){
                card.setText("Card number: "+rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardnumber").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        try{
            Conn c1=new Conn();
            int bal=0;
            ResultSet rs=c1.s.executeQuery("select * from bank where pin='"+pin+"'");
            while(rs.next()){
                mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
                balance.setText("Your current account balance is "+bal);
            }
            
        }catch (Exception e){
            System.out.println(e);
        }
        mini.setBounds(20,140,400,200);
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public static void main(String[] args){
        new MiniStatement("");
    }
}
