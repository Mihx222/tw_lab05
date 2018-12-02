package com.lab05;
import java.io.*;
import java.util.Enumeration;

@javax.servlet.annotation.WebServlet(name = "validate")
public class validate extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        PrintWriter out = response.getWriter();

        out.println("<div style=\"margin-left: 10%; margin-right: 10%;\">");
        out.println("<table class=\"w3-table-all w3-hoverable\" style=\"margin-top:2%;\">");
        out.println("<th>Rezultatele</th>");
        Enumeration<String> paramNames = request.getParameterNames();
        int count = 0;
        while(paramNames.hasMoreElements()) {
            String[] inputValues = request.getParameterValues(paramNames.nextElement());
            out.println("<tr>");
            for (int i = 0; i < inputValues.length; i++, count++) {
                if (inputValues[i].equals(Integer.toString(0)))
                    out.print("<td><p style=\"color: red; font-size: 20px;\">" + (count + 1) + " - Gresit!" + "</p></td>");
                else
                    out.print("<td><p style=\"color: green; font-size: 20px;\">" + (count + 1) + " - Corect" + "</p></td>");
            }
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</div>");
    }
}
