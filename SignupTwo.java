/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    
    JComboBox rel,cat,inc,edu,occ;
    JTextField pan,aadhar;
    JButton next;
    JRadioButton yes,no,eyes,eno;
    String formno;
    
    
    
    SignupTwo(String formno){
        this.formno=formno;
        
        setLayout(null); 
        
        setTitle("NEW ACCOUNT APPLICATION FORM-PAGE 2");
        
        
        JLabel additionalDetails =new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        JLabel name =new JLabel("Religion :");
        name.setFont(new Font("Raleway",Font.BOLD,22));
        name.setBounds(100,140,130,30);
        add(name);
        
        String varReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        rel=new JComboBox(varReligion);
        rel.setBounds(300,140,400,30);
        rel.setBackground(Color.WHITE);
        add(rel);
        
        
        JLabel fname =new JLabel("Category :");
        fname.setFont(new Font("Raleway",Font.BOLD,22));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        String varcat[] = {"General","OBC","SC","ST","Other"};
        cat=new JComboBox(varcat);
        cat.setBounds(300,190,400,30);
        cat.setBackground(Color.WHITE);
        add(cat);
        
        JLabel dob =new JLabel("Income :");
        dob.setFont(new Font("Raleway",Font.BOLD,22));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        String varinc[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
        inc=new JComboBox(varinc);
        inc.setBounds(300,240,400,30);
        inc.setBackground(Color.WHITE);
        add(inc);
        
        JLabel gender =new JLabel("Educational");
        gender.setFont(new Font("Raleway",Font.BOLD,22));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        
        JLabel email =new JLabel("Qualifaction :");
        email.setFont(new Font("Raleway",Font.BOLD,22));
        email.setBounds(100,315,200,30);
        add(email);
        
        String eduval[] = {"Non Graduation","Under Grad","Post Graduation","Doctorate","Others"};
        edu=new JComboBox(eduval);
        edu.setBounds(300,315,400,30);
        edu.setBackground(Color.WHITE);
        add(edu);
       
        
        JLabel maritalStatus =new JLabel("Occupation :");
        maritalStatus.setFont(new Font("Raleway",Font.BOLD,22));
        maritalStatus.setBounds(100,390,200,30);
        add(maritalStatus);
        
        String occval[] = {"Salaried","Self-Employed","Business","Student","Retired","Others"};
        occ=new JComboBox(occval);
        occ.setBounds(300,390,400,30);
        occ.setBackground(Color.WHITE);
        add(occ);
        
        
        JLabel address =new JLabel("PAN Number :");
        address.setFont(new Font("Raleway",Font.BOLD,22));
        address.setBounds(100,440,200,30);
        add(address);
        
        pan=new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300,440,400,30);
        add(pan);
        
        JLabel city =new JLabel("Aadhar Number :");
        city.setFont(new Font("Raleway",Font.BOLD,22));
        city.setBounds(100,490,200,30);
        add(city);
        
        aadhar=new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);
        
        JLabel state =new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway",Font.BOLD,22));
        state.setBounds(100,540,200,30);
        add(state);
        
        yes=new JRadioButton("Yes");
        yes.setBounds(300,540,60,30);
        yes.setBackground(Color.WHITE);
        add(yes);
        
        no=new JRadioButton("No");
        no.setBounds(450,540,120,30);
        no.setBackground(Color.WHITE);
        add(no);
        
        ButtonGroup seniorgroup=new ButtonGroup();
        seniorgroup.add(yes);
        seniorgroup.add(no);
        
        JLabel pincode =new JLabel("Existing Account");
        pincode.setFont(new Font("Raleway",Font.BOLD,22));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        eyes=new JRadioButton("Yes");
        eyes.setBounds(300,590,60,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno=new JRadioButton("No");
        eno.setBounds(450,590,120,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup existingaccgroup=new ButtonGroup();
        existingaccgroup.add(eyes);
        existingaccgroup.add(eno);
        
        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,20);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        
        String sreligion=(String)rel.getSelectedItem();
        String scategory=(String)cat.getSelectedItem();
        String sincome=(String)inc.getSelectedItem();
        String soccupation=(String)occ.getSelectedItem();
        String seducation=(String)edu.getSelectedItem();
        String seniorcitizen=null;
        if(yes.isSelected()){
            seniorcitizen="Yes";
        }
        else if(no.isSelected()){
            seniorcitizen="No";
        }
        
        String existingaccount=null;
        if(eyes.isSelected()){
            existingaccount="Yes";
        }
        else if(eno.isSelected()){
            existingaccount="No";
        }
        
        String saadhar=aadhar.getText();
       
        
        String span=pan.getText();
        
        try {
            Conn c=new Conn();
            String query="insert into signuptwo values ('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
            c.s.executeUpdate(query);
            
            setVisible(false);
            new SignupThree(formno).setVisible(true);
        }catch ( Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String[] args){
        new SignupTwo("");
    }
}

