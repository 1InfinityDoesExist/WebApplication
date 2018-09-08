import java.io.*;
import java.sql.*;

public class LoginDao 
{
	public boolean validte(String un, String ps)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		
		String connectionDriver_class = "com.mysql.cj.jdbc.Driver";
		String connectionUrl = "jdbc:mysql://localhost:3306/";
		String dbName = "employee";
		String connectionUsername = "root";
		String connectionPassword = "iit2014006";
		String sql = "select *from login where uname=? and pass = ? ";
		
		try
		{
			Class.forName(connectionDriver_class);
			
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		try{
			con = DriverManager.getConnection(connectionUrl+dbName, connectionUsername, connectionPassword);
			pstmt = con.prepareStatement(sql);
			
			
			pstmt.setString(1, un);
			pstmt.setString(2, ps);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				return true;
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
