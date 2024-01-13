package edu.test;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CalcServlet extends GenericServlet {
	public void service(ServletRequest request, ServletResponse response)throws ServletException, IOException {
		response.setContentType("text/HTML");
		PrintWriter out = response.getWriter();

		String numOne = request.getParameter("numone");
		String numTwo = request.getParameter("numtwo");
		String opr = request.getParameter("operation");
		Integer x=0, y=0,result=0;
		try {
			x = Integer.parseInt(numOne);
			y = Integer.parseInt(numTwo);
			if("ADD".equalsIgnoreCase(opr))
				result = x + y;
			else if("SUB".equalsIgnoreCase(opr))
				result = x - y;
			else if("MUL".equalsIgnoreCase(opr))
				result = x * y;
			else if("DIV".equalsIgnoreCase(opr))
				result = x / y;
			
			out.print("<h1>Result: "+result+"</h1>");
			
		}catch(ArithmeticException e){
			out.print("<h1>Cant divide by zero</h1");		
		}
		catch (Exception e) {
			out.print("<h1>Please enter valid number</h1");
		}
		//out.println("<h2><a href='home.html'>Go Home</a><h2>");
		request.getRequestDispatcher("Home.html").include(request, response);
	}
}
