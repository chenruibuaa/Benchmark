package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15889")
public class BenchmarkTest15889 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}

		String bar = doSomething(param);
		
		String sql = "{call verifyUserPassword('foo','"+bar+"')}";
				
		try {
			java.sql.Connection connection = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlConnection();
			java.sql.CallableStatement statement = connection.prepareCall( sql, java.sql.ResultSet.TYPE_FORWARD_ONLY, 
							java.sql.ResultSet.CONCUR_READ_ONLY );
			statement.execute();
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a1447 = param; //assign
		StringBuilder b1447 = new StringBuilder(a1447);  // stick in stringbuilder
		b1447.append(" SafeStuff"); // append some safe content
		b1447.replace(b1447.length()-"Chars".length(),b1447.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map1447 = new java.util.HashMap<String,Object>();
		map1447.put("key1447", b1447.toString()); // put in a collection
		String c1447 = (String)map1447.get("key1447"); // get it back out
		String d1447 = c1447.substring(0,c1447.length()-1); // extract most of it
		String e1447 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d1447.getBytes() ) )); // B64 encode and decode it
		String f1447 = e1447.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g1447 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g1447); // reflection
	
		return bar;	
	}
}