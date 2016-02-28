package http;
import java.io.*;
import java.util.Properties;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import adapter.BuildAuto;

@WebServlet("/")
public class HomeHandler extends HttpServlet {
	/**
	 * First Servlet
	 */
	@Override
    public void doGet(HttpServletRequest request,
        HttpServletResponse response)
        throws IOException, ServletException
    {
    	String auto1 = "../test1.properties";
		String auto2 = "../test2.properties";
		
		File file1 = new File(HomeHandler.class.getClassLoader().getResource(auto1).getPath());
		String auto1Path = file1.getAbsolutePath();
		Properties properties1 = new Properties();
		InputStream input1 = new FileInputStream(auto1Path);
		properties1.load(input1);
		
		File file2 = new File(HomeHandler.class.getClassLoader().getResource(auto2).getPath());
		String auto2Path = file2.getAbsolutePath();
		Properties properties2 = new Properties();
		InputStream input2 = new FileInputStream(auto2Path);
		properties2.load(input2);
		
        response.setContentType("text/html");
        BuildAuto auto = new BuildAuto();
        
		try {
			auto.buildAuto(properties1, "Properties");
			auto.buildAuto(properties2, "Properties");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        PrintWriter out = response.getWriter();


        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>");
        out.println("Car Configuration");
        out.println("</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");
        out.println("<H1>Basic Car Choice</H1>");
        out.println("<p>");
		out.println("please select available file");
		out.println("</p>");
		
		out.println("<form action=\"auto\" method=\"get\">");
		out.println("<select name = \"model\">");

		// display all available models on the server dynamically
		for (String name : auto.getAutoMobiles().keySet()) {
			out.println("  <option value =\"" + name + "\">" + name + "</option>");
		}

		out.println("<input type=\"submit\" value=\"Submit\">");
		out.println("</select>");
		out.println("</form>");
		
        out.println("</BODY>");
        out.println("</HTML>");
    }
}
