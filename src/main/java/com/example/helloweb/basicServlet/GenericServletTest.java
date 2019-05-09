package com.example.helloweb.basicServlet;


import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * servlet类继承GenericServlet，只用实现service方法
 */
@WebServlet(name = "GenericServletTest", urlPatterns = "/genericServletTest", initParams = {
        @WebInitParam(name = "admin", value = "John Smith"), @WebInitParam(name = "email", value = "admin@email.com")})
public class GenericServletTest extends GenericServlet {

    public void service(ServletRequest request, ServletResponse response) throws IOException {
        ServletConfig servletConfig = getServletConfig();
        String admin = servletConfig.getInitParameter("admin");
        String email = servletConfig.getInitParameter("email");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print("<html><body><h1>GenericServlet Test</h1>" +
                "Admin : " + admin + "<br/>Email : " + email + "<br/>" +
                "</body></html>");
    }

}
