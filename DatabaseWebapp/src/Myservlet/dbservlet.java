package Myservlet;
import p1.DaoInteraface;
import p1.DaoImplement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class dbservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DaoImplement obj = new DaoImplement();
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		ArrayList<String> dblist = new  ArrayList<String>();
		try {
			obj.DaoImplement1();
			dblist = obj.validate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (String i : dblist) {
			if(username.equals(i) && password.equals(i) ) {
				PrintWriter out = resp.getWriter();
				out.print("Welcome......"+username);
				out.print("\nValid account");
			}
			else {
				PrintWriter out = resp.getWriter();
				out.print("Invalid User.....");
			}
}}}
