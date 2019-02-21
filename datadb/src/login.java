

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datadb.POJO;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username=request.getParameter("username");
		String pass=request.getParameter("pass");
		String usertype = request.getParameter("usertype");
		int ut=Integer.parseInt(usertype);

		
		POJO p=new POJO();
		p.setUsername(username);
		p.setUsertype(usertype);
		p.setPass(pass);
		p.setPass(pass);
		Connection con = null;

if( ut  ==2 && username!=null && pass!=null)
{
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sih?autoReconnect=true&useSSL=false","root","password");
			
			String q="select username , pass  from sih1 where username=? and pass=?";
			
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1, p.getUsername());
			ps.setString(2, p.getPass());
			ResultSet rs =ps.executeQuery();

			if(rs.next()) {
				HttpSession session=request.getSession();
				session.setAttribute("uname", username);
				RequestDispatcher rd= request.getRequestDispatcher("register.html");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("message","Data Not Found");
				request.getRequestDispatcher("login.html").forward(request, response);
				con.close();
				response.sendRedirect("login.html");
			}	
			
		}catch (Exception e1) {
		System.out.println(e1);
		}
	}
else if(ut==3 && username!=null && pass!=null){
	try
	{
		
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sih?autoReconnect=true&useSSL=false","root","password");
		
		String q="select * from sih where username=? and pass = ?";
		
		PreparedStatement ps=con.prepareStatement(q);
		ps.setString(1, p.getUsername());
		ps.setString(2, p.getPass());
		ResultSet rs =ps.executeQuery();

		if(rs.next()) {
			HttpSession session=request.getSession();
			session.setAttribute("uname", username);
	RequestDispatcher rd= request.getRequestDispatcher("register.html");
			rd.forward(request, response);
			con.close();
		}
		else {
			request.setAttribute("message","Data Not Found");
			request.getRequestDispatcher("login.html").forward(request, response);
	//	response.sendRedirect("login.jsp");
			con.close();
		}	
		
	}catch (Exception e1) {
	System.out.println(e1);
	}
}
else {
	request.setAttribute("message","Please Enter the Details");
	request.getRequestDispatcher("login.html").forward(request, response);
	
		}
	



	}

}
