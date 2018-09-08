
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet
{
	Connection con = null;
	PreparedStatement pstmt = null;
	
	String connectionDriver_class = "com.mysql.cj.jdbc.Driver";
	String connectionUrl = "jdbc:mysql://localhost:3306/";
	String dbName = "employee";
	String connectionUsername = "root";
	String connectionPassword = "iit2014006";
	String sql = "INSERT INTO LOGIN VALUES(?, ?)";
	
	public void init(ServletConfig config) throws ServletException
	{
		try{
			Class.forName(connectionDriver_class);
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		try{
			con = DriverManager.getConnection(connectionUrl+dbName, connectionUsername, connectionPassword);
			pstmt = con.prepareStatement(sql);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = (String)request.getAttribute("un");
		String pass = (String)request.getAttribute("ps");
		try
		{
			
			pstmt.setString(1, name);
			pstmt.setString(2, pass);
			int k = pstmt.executeUpdate();
			if(k != 0)
			{
				out.println("Successfully Registerred");
				RequestDispatcher rd = request.getRequestDispatcher("SignIn.jsp");
				rd.include(request, response);
			}
			else
			{
				out.println("UnSuccessfully Registerred");
				RequestDispatcher rd = request.getRequestDispatcher("NewUserRegistration.jsp");
				rd.include(request, response);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void destroy()
	{
		try{
			if(pstmt != null)
			{
				pstmt.close();
			}
			if(con != null)
			{
				con.close();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
