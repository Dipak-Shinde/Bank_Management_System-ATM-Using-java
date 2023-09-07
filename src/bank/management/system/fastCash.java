package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class fastCash extends JFrame implements ActionListener {
	JButton deposite,withdrawl,fastcash,balanceenquiry,pinchange,exit;
	String pinnumber;
	fastCash(String pinnumber){
		this.pinnumber  = pinnumber;
		setLayout(null);
		
		ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icon/icons/atm.jpg"));
		Image i2 =i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,900,730);
		add(image);
		
		JLabel text = new JLabel("SELECT WITHROL AMOUNT:");
		text.setBounds(210,220,700,35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System",Font.BOLD,16));
		image.add(text);
		
		 deposite = new JButton("RS 100");
		deposite.setBounds(170,320,150,30);
		deposite.addActionListener(this);
		image.add(deposite);
		
		withdrawl = new JButton(" RS 200");
		withdrawl.setBounds(355,320,150,30);
		withdrawl.addActionListener(this);
		image.add(withdrawl);
		
		 fastcash = new JButton(" RS 500");
		fastcash.setBounds(170,355,150,30);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		JButton ministatement = new JButton(" RS 1000");
		ministatement.setBounds(355,355,150,30);
		ministatement.addActionListener(this);
		image.add(ministatement);
		
		 pinchange = new JButton(" RS 2000");
		pinchange.setBounds(170,390,150,30);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		 balanceenquiry = new JButton(" RS 5000");
		balanceenquiry.setBounds(355,390,150,30);
		balanceenquiry.addActionListener(this);
		image.add(balanceenquiry);
		
		 exit = new JButton(" BACK ");
		exit.setBounds(355,425,150,30);
		exit.addActionListener(this);
		image.add(exit);
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
		
		
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== exit) {
			setVisible(false);
			new Transaction(pinnumber).setVisible(true);
		}else  {
			String amount = ((JButton)ae.getSource()).getText().substring(3);
			Conn c =new Conn();
			try {
				ResultSet rs = c.S.executeQuery("select * from bank where pin ='"+pinnumber+"'");
				int balance = 0;
				while(rs.next()) {
					if(rs.getString("type").equals("Deposite")) {
						balance +=Integer.parseInt (rs.getString("amount"));
					}else {
						balance -= Integer.parseInt(rs.getString("amount"));
					}
				}
				if(ae.getSource() != exit && balance < Integer.parseInt(amount) ) {
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
					return;
				}
				Date date = new Date();
				String query ="insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+amount+"')";
			
		        c.S.executeUpdate(query);
		        JOptionPane.showMessageDialog(null,"Rs"+amount+"Debeated Successfully");
	
		  setVisible(false);
		new Transaction(pinnumber).setVisible(true);
			}catch(Exception e) {
				System.out.println(e);
			}
		}
	}
	
	public static void main (String args[]) {
		new fastCash("");
		}
		
	}
