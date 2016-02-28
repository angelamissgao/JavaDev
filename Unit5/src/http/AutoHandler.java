package http;
import java.io.*;
import java.util.Properties;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import adapter.BuildAuto;
import model.Automobile;

@WebServlet("/auto")
public class AutoHandler extends HttpServlet {
	/**
	 * First Servlet
	 */
	@Override
    public void doGet(HttpServletRequest request,
        HttpServletResponse response)
        throws IOException, ServletException
    {
   
        response.setContentType("text/html");	
        PrintWriter out = response.getWriter();


        out.println("<!DOCTYPE HTML>");
        out.println("<HEAD>");
        out.println("<title> Basic Car Choice </title>");
        out.println("</HEAD>");
        out.println("<BODY>");
        out.println("<H1>Basic Car Choice</H1>");
		
        out.println("<table border= \"1\">");
		out.println("<form action=\"price.jsp\" method=\"get\">");

		String name = request.getParameter("model");
		out.println("<p>name " + name +"</p>");
        BuildAuto auto = new BuildAuto();
		Automobile model = auto.getAutoMobile(name);
		
		// 1th Row, showing the name of the model
		out.println("<tr>");
		out.println("<td>        Name      </td>");
		out.println("<td><input type=\"text\" name=\"model\" value=\"" + name + "\"readonly=\"readonly\"></td>");
		out.println("</tr>");

		// 2th Row, showing the  choice
		out.println("<tr>");
		out.println("<td>        Transmission      </td>");
		out.println("<td>");
		out.println("<select name = \"Transmission\">");
		for (String eachOptName : model.getOptionSetOptions("Transmission")) {
			out.println("  <option value =\"" + eachOptName + "\">" + eachOptName + "</option>");
		}
		out.println("</select>");
		out.println("</td>");
		out.println("</tr>");

		// 3th Row, showing the  choice
		out.println("<tr>");
		out.println("<td>       Brakes    </td> ");
		out.println("<td>");
		out.println("<select name = \"Brakes\">");
		for (String eachOptName : model.getOptionSetOptions("Brakes")) {
			out.println("  <option value =\"" + eachOptName + "\">" + eachOptName + "</option>");
		}
		out.println("</select>");
		out.println("</td>");
		out.println("</tr>");

		// 4th Row, showing the Brakes/Traction Control choice
		out.println("<tr>");
		out.println("	<td> Color </td> ");
		out.println("<td>");
		out.println("<select name = \"Color\">");
		for (String eachOptName : model.getOptionSetOptions("Color")) {
			out.println("  <option value =\"" + eachOptName + "\">" + eachOptName + "</option>");
		}
		out.println("</select>");
		out.println("</td>");
		out.println("</tr>");

		// 5th Row, showing the Side Impact Air Bags Control choice
		out.println("<tr>");
		out.println("	  <td>SideImpactAirBags</td>   ");
		out.println("<td>");
		out.println("<select name = \"SideImpactAirBags\">");
		for (String eachOptName : model.getOptionSetOptions("SideImpactAirBags")) {
			out.println("  <option value =\"" + eachOptName + "\">" + eachOptName + "</option>");
		}
		out.println("</select>");
		out.println("</td>");
		out.println("</tr>");

		// 6th Row, showing the Power Moonroof choice
		out.println("<tr>");
		out.println("	 <td>PowerMoonroof</td>  ");
		out.println("<td>");
		out.println("<select name = \"PowerMoonroof\">");
		for (String eachOptName : model.getOptionSetOptions("PowerMoonroof")) {
			out.println("  <option value =\"" + eachOptName + "\">" + eachOptName + "</option>");
		}
		out.println("</select>");
		out.println("</td>");
		out.println("</tr>");
		
		//7th
		out.println("<tr>");
		out.println("	 <td>ABS</td>  ");
		out.println("<td>");
		out.println("<select name = \"ABS\">");
		for (String eachOptName : model.getOptionSetOptions("ABS")) {
			out.println("  <option value =\"" + eachOptName + "\">" + eachOptName + "</option>");
		}
		out.println("</select>");
		out.println("</td>");
		out.println("</tr>");

		out.println("</table>");
		out.println("  <input type=\"submit\" value=\"Submit\">");
		
		out.println("</form>");
        out.println("</BODY>");
        out.println("</HTML>");
    }
}
