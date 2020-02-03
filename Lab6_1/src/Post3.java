

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Post3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public Post3() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		ServletContext application =getServletContext();
		String url=application.getInitParameter("Url");
		
		out.print("<a href='"+url+"'>This is our clg website</a>");
		
		ServletConfig app=getServletConfig();
		String s1=app.getInitParameter("username");
		String s2=app.getInitParameter("Password");
		out.print("<p>Username is "+s1+"</p> <p> Password is"+s2+"</p>" );
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
