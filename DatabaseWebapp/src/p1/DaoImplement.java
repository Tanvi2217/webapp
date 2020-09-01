package p1;
import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoImplement{
	
	Connection con; // holds connection in between java & database
	PreparedStatement ps; // executes SQL queries

	public void DaoImplement1() throws SQLException, ClassNotFoundException {
		String path = "jdbc:oracle:thin:@localhost:1521:XE";
		String username = "system";
		String password = "Oracle_1998";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(path, username, password);
		System.out.println(" Connection Establish ----->> " + con);}

	public ArrayList<String> validate() throws SQLException  {
		// TODO Auto-generated method stub
		String uname = null;
		String pswd = null;
		ArrayList<String> list1 = new ArrayList<String>();
		String selectquery = "select name,pwd from Users";
		ps = con.prepareStatement(selectquery);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			uname = rs.getString("name");
			 pswd = rs.getString("pwd");
			list1.add(uname);
			list1.add(pswd);
			System.out.println(list1);
			
		
		}
		return list1;
		
	
}}
