

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Inlab2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Inlab2() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String pass=request.getParameter("v1");
		out.print("<p>The password must contain an upper case,lower case and a number in it !!!</p>");
		int num=0,low=0,upp=0;
		
		for( int i=0;i<pass.length();i++)
		{
			if(pass.charAt(i) >='A' && pass.charAt(i) <= 'Z')
				upp=1;
			if(pass.charAt(i) >='a' && pass.charAt(i) <= 'z')
				low=1;
			if(Character.isDigit(pass.charAt(i)))
				num=1;
			
		}
	
		
		if(upp == 0 && low == 1 && num == 0) 
		{
			RequestDispatcher rd=request.getRequestDispatcher("Inlablow");
			rd.forward(request, response);
		}
		else if(upp == 1 && low == 0 && num == 0) 
		{
			RequestDispatcher rd=request.getRequestDispatcher("Inlabupp");
			rd.forward(request, response);
		}
		else if(upp == 0 && low == 0 && num == 1) 
		{
			RequestDispatcher rd=request.getRequestDispatcher("Inlabnum");
			rd.include(request, response);
		}
		else
			out.print("Strong Password :)");
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
