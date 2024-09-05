/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JLabel text;
    JButton b1, b2, b3, b4, b5, b6, b7;
    String pinnumber;

    FastCash(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 900, 900);
        add(l2);

        text = new JLabel("Select Withdrawal amount:");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        l2.add(text);

        b1 = new JButton("Rs 100");
        b2 = new JButton("Rs 500");
        b3 = new JButton("Rs 1000");
        b4 = new JButton("Rs 2000");
        b5 = new JButton("Rs 5000");
        b6 = new JButton("Rs 10000");
        b7 = new JButton("Back");

        b1.setBounds(170, 415, 150, 30);
        l2.add(b1);

        b2.setBounds(355, 415, 150, 30);
        l2.add(b2);

        b3.setBounds(170, 450, 150, 30);
        l2.add(b3);

        b4.setBounds(355, 450, 150, 30);
        l2.add(b4);

        b5.setBounds(170, 485, 150, 30);
        l2.add(b5);

        b6.setBounds(355, 485, 150, 30);
        l2.add(b6);

        b7.setBounds(355, 520, 150, 35);
        l2.add(b7);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String amt = ((JButton) ae.getSource()).getText().substring(3);
            Conn c = new Conn();

            ResultSet rs = c.s.executeQuery("select * from bank where pin='" + pinnumber + "'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            if (ae.getSource() != b7 && balance < Integer.parseInt(amt)) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }
            if (ae.getSource() == b7) {
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            } else {
                Date dt = new Date();
                String query1 = "insert into bank values('" + pinnumber + "','" + dt + "','Withdrawal','" + amt + "')";
                c.s.executeUpdate(query1);
                JOptionPane.showMessageDialog(null, "Rs " + amt + " Withdrawn Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new FastCash("").setVisible(true);
    }
}

