

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datadb.POJO;


@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String mblno=request.getParameter("mblno");
		String address=request.getParameter("address");
		String pass=request.getParameter("pass");

		
		POJO p=new POJO();
		p.setUsername(username);
		p.setEmail(email);
		p.setAddress(address);
		p.setMblno(mblno);
		p.setPass(pass);
		
		 PrintWriter out = response.getWriter();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sih?autoReconnect=true&useSSL=false","root","password");
			
			String q="insert into sih1 (username,email,mblno,address,pass) values(?,?,?,?,?);";
			
			PreparedStatement ps=con.prepareStatement(q);
			
		//	ps.setInt(1, p.getId());
			ps.setString(1, p.getUsername());
			ps.setString(2, p.getEmail());
			ps.setString(3, p.getMblno());
			ps.setString(4, p.getAddress());
			ps.setString(5, p.getPass());
			
			int i=ps.executeUpdate();
		response.sendRedirect("register.html");
			con.close();
			
		}catch (Exception e1) {
			
			System.out.println("Error During Connection to the Database" +e1.getMessage());
		}
		
	/*	Database db=new Database();
		db.saveData(p);
		response.sendRedirect("UserLogin.html");*/
		
	}


	}

