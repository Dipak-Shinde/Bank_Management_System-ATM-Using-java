package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class pinChange extends JFrame implements ActionListener {
	
	JPasswordField pin,rpin;
	JButton change,back;
	String pinnumber;
	
	pinChange(String pinnumber){
		this.pinnumber = pinnumber;
	ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/icons/atm.jpg"));
	Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
	ImageIcon i3=new ImageIcon(i2);
	JLabel image =new JLabel(i3);
	image.setBounds(0,0,900,730);
	add(image);

	JLabel name = new JLabel("ENTER YOUR PIN");
	name.setForeground(Color.WHITE);
	name.setFont(new Font("System",Font.BOLD,16));
	name.setBounds(250,230,180,25);
	image.add(name);
	
	JLabel pintext = new JLabel("New PIN");
	pintext.setForeground(Color.WHITE);
	pintext.setFont(new Font("System",Font.BOLD,16));
	pintext.setBounds(165,300,180,25);
	image.add(pintext);
	
	 pin= new JPasswordField();
	pin.setFont(new Font("Raleway",Font.BOLD,25));
	pin.setBounds(280,300,180,25);
	image.add(pin);
	
	JLabel retext = new JLabel("New rePIN");
	retext.setForeground(Color.WHITE);
	retext.setFont(new Font("System",Font.BOLD,16));
	retext.setBounds(165,340,180,25);
	image.add(retext);
	
	 rpin= new JPasswordField();
	rpin.setFont(new Font("Raleway",Font.BOLD,25));
	rpin.setBounds(280,340,180,25);
	image.add(rpin);
	
	 change=new JButton("CHANGE");
	change.setBounds(350,395,150,30);
	change.addActionListener(this);
	image.add(change);
	
	 back=new JButton("BACK");
	back.setBounds(350,435,150,30);
	back.addActionListener(this);
	image.add(back);
	
	setSize(900,900);
	setLocation(300,0);
	setUndecorated(true);
	setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== change) {
		try {
			String npin = pin.getText();
			String repin = rpin.getText();
			if(!npin.equals(rpin)) {
			JOptionPane.showMessageDialog(null, "Enter Pin Does Not Match");	
			return;
			}
			
		if(npin.equals("")) {
			JOptionPane.showMessageDialog(null, "PLEASE REENTER PIN");
		return;
		}
		Conn conn = new Conn();
		String query1="update bank set pin='"+rpin+"'where pin='"+pinnumber+"'";
		String query2="update login set pin='"+rpin+"'where pin='"+pinnumber+"'";
		String query3="update signupthree set pin='"+rpin+"'where pin='"+pinnumber+"'";

		conn.S.executeUpdate(query1);
		conn.S.executeUpdate(query2);
		conn.S.executeUpdate(query3);

		JOptionPane.showMessageDialog(null, "Pin Change Successfully");
		
		setVisible(false);
		new Transaction(repin).setVisible(true);
		
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}else {
		setVisible(false);
		new Transaction(pinnumber).setVisible(true);
	}
	}
	public static void main(String args[]) {
		new pinChange("").setVisible(true);
}
}