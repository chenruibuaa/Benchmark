package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16782")
public class BenchmarkTest16782 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		Object[] obj = { "a", "b" };
		
		response.getWriter().format(java.util.Locale.US,bar,obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a14475 = param; //assign
		StringBuilder b14475 = new StringBuilder(a14475);  // stick in stringbuilder
		b14475.append(" SafeStuff"); // append some safe content
		b14475.replace(b14475.length()-"Chars".length(),b14475.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map14475 = new java.util.HashMap<String,Object>();
		map14475.put("key14475", b14475.toString()); // put in a collection
		String c14475 = (String)map14475.get("key14475"); // get it back out
		String d14475 = c14475.substring(0,c14475.length()-1); // extract most of it
		String e14475 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d14475.getBytes() ) )); // B64 encode and decode it
		String f14475 = e14475.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f14475); // reflection
	
		return bar;	
	}
}