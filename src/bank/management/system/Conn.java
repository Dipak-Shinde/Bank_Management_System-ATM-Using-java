package bank.management.system;
import java.sql.*;

public class Conn {
	
	Connection C;
	Statement S;
	public Conn() {
		try {
			C = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem","root","dipak123");
		    S = C.createStatement();
		    
		}catch(Exception e) {
			
			System.out.println(e);
			
		} 
	}

}
