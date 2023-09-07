package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
	long random;
	JTextField nameTextField,fnameTextField,dobTextField,emailTextField,addressTextField,cityTextField,stateTextField,pincodeField;
	JButton next;
	JRadioButton male,female,other,marrid,unmarrid;
	JDateChooser dateChooser;
	
	 SignupOne(){
		
		setLayout(null);
		
		Random ran =new Random();
		long random = Math.abs((ran.nextLong() % 9000L) +1000L);
		
		JLabel formno =new JLabel("APPLICATION FORM NO."+ random );
		formno.setFont(new Font("Raleway",Font.BOLD,38));
		formno.setBounds(140,20,600,40);
		add(formno);
		
		JLabel personDetails =new JLabel("Page 1: Personal Details");
		personDetails.setFont(new Font("Raleway",Font.BOLD,22));
		personDetails.setBounds(290,80,400,30);
		add(personDetails);
		
		JLabel name =new JLabel("Name:");
		name.setFont(new Font("Raleway",Font.BOLD,20));
		name.setBounds(100,140,100,30);
		add(name);
		 nameTextField =new JTextField();
		nameTextField.setFont(new Font("Ralwey",Font.BOLD,14));
		nameTextField.setBounds(300,140,400,30);
		add(nameTextField);
		
		
		
		JLabel fname =new JLabel("father Name:");
	    fname.setFont(new Font("Raleway",Font.BOLD,20));
	    fname.setBounds(100,190,200,30);
		add (fname);
		 fnameTextField =new JTextField();
		fnameTextField.setFont(new Font("Ralwey",Font.BOLD,14));
		fnameTextField.setBounds(300,190,400,30);
		add(fnameTextField);
		
		JLabel dob =new JLabel("Date of Birth:");
	    dob.setFont(new Font("Raleway",Font.BOLD,20));
	    dob.setBounds(100,240,300,30);
		add (dob);
		
		 dateChooser = new JDateChooser();
		dateChooser.setBounds(300,240,400,30);
		dateChooser.setForeground(new Color(105,105,105));
		add(dateChooser);
	
		
		JLabel gender =new JLabel("Gender:");
	    gender.setFont(new Font("Raleway",Font.BOLD,20));
	    gender.setBounds(100,290,200,30);
		add (gender);
		
		 male = new JRadioButton("MALE");
		male.setBounds(300,290,60,30);
		male.setBackground(Color.WHITE);
		add(male);
		
		 female = new JRadioButton("FEMALE");
		female.setBounds(450,290,120,30);
		female.setBackground(Color.WHITE);
		add(female);
		
		ButtonGroup gendergroup =new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);
				
		
		
		JLabel email =new JLabel("Email address:");
	    email.setFont(new Font("Raleway",Font.BOLD,20));
	    email.setBounds(100,340,200,30);
		add (email);
		 emailTextField =new JTextField();
		emailTextField.setFont(new Font("Ralwey",Font.BOLD,14));
		emailTextField.setBounds(300,340,400,30);
		add(emailTextField);
		
		JLabel marital =new JLabel("Marital Status:");
	    marital.setFont(new Font("Raleway",Font.BOLD,20));
	    marital.setBounds(100,390,200,30);
		add (marital);
		
		 marrid = new JRadioButton("Marrid");
		marrid.setBounds(300,390,100,30);
		marrid.setBackground(Color.WHITE);
		add(marrid);
		
		 unmarrid = new JRadioButton("UNMARRID");
		unmarrid.setBounds(450,390,100,30);
		unmarrid.setBackground(Color.WHITE);
		add(unmarrid);
		
		 other = new JRadioButton("Other");
		other.setBounds(630,390,100,30);
		other.setBackground(Color.WHITE);
		add(other);
		
		ButtonGroup maritalgroup =new ButtonGroup();
		maritalgroup.add(marrid);
		maritalgroup.add(unmarrid);
		maritalgroup.add(other);
		
		
		JLabel address =new JLabel("Address:");
	    address.setFont(new Font("Raleway",Font.BOLD,20));
	    address.setBounds(100,440,200,30);
		add (address);
		 addressTextField =new JTextField();
		addressTextField.setFont(new Font("Ralwey",Font.BOLD,14));
		addressTextField.setBounds(300,440,400,30);
		add(addressTextField);

		
		JLabel city =new JLabel("City:");
	    city.setFont(new Font("Raleway",Font.BOLD,20));
	    city.setBounds(100,490,200,30);
		add (city);
		 cityTextField =new JTextField();
		cityTextField.setFont(new Font("Ralwey",Font.BOLD,14));
		cityTextField.setBounds(300,490,400,30);
		add(cityTextField);

		
		JLabel state =new JLabel("State:");
	    state.setFont(new Font("Raleway",Font.BOLD,20));
	    state.setBounds(100,540,200,30);
		add (state);
		 stateTextField =new JTextField();
		stateTextField.setFont(new Font("Ralwey",Font.BOLD,14));
		stateTextField.setBounds(300,540,400,30);
		add(stateTextField);

		
		JLabel pincode =new JLabel("Pin Code:");
	    pincode.setFont(new Font("Raleway",Font.BOLD,20));
	    pincode.setBounds(100,590,200,30);
		add (pincode);
		 pincodeField =new JTextField();
		pincodeField.setFont(new Font("Ralwey",Font.BOLD,14));
		pincodeField.setBounds(300,590,400,30);
		add(pincodeField);
       
		 next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setBounds(650,660,80,30);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
}
	public void actionPerformed(ActionEvent ae) {
    	String formno ="" + random;
		String name = nameTextField.getText();
		String fname = fnameTextField.getText();
		String dob =((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
		String gender =null;
	    if(male.isSelected()) {
			gender="Male";
			
		}else if(female.isSelected()) {
			gender="female";
		}
		String email = emailTextField.getText();
		String marital =null;
		if(marrid.isSelected()) {
			marital = "Married";
		}else if(unmarrid.isSelected()) {
			marital = "Unmarried";
		}else if (other.isSelected()) {
			marital = "other";
		}
		String address =addressTextField.getText();
		String city = cityTextField.getText();
		String state = stateTextField.getText();
		String pin = pincodeField.getText();
		try {
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null, "Name is Required");
			}else {
				Conn C =new Conn();
				String query ="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
			    C.S.executeUpdate(query);	
			    setVisible(false);
			    new signupTwo(formno).setVisible(true);
			}
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
public static void main (String args[]) {
	new SignupOne();
}
}