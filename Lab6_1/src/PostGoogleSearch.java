

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PostGoogleSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PostGoogleSearch() {
        super();
    }

	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		try
		{
			String driver,url,username,password;
			ServletConfig config=getServletConfig();
			ServletContext context=getServletContext();
			driver=context.getInitParameter("driver");
			url=context.getInitParameter("url");
			
		
			username=config.getInitParameter("username");
			password=config.getInitParameter("password");
			out.print("IN search servlet");
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,username,password);
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select *from log");
		    while(rs.next())
		    {
	              String name=rs.getString(1);
	              response.sendRedirect("https://www.google.com#q="+name);  
		    }
		}
		catch(Exception e)
		{
			out.print("Exception " +e);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
