package com.example.helloweb.basicServlet;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "ServletTest", urlPatterns = "/servletTest", initParams = {
        @WebInitParam(name = "admin", value = "Harry Taciak"),
        @WebInitParam(name = "email", value = "admin@example.com")
})
public class ServletTest implements Servlet {

    private transient ServletConfig servletConfig;

    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
    }

    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        String servletName = servletConfig.getServletName();

        String admin = servletConfig.getInitParameter("admin");
        String email = servletConfig.getInitParameter("email");

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.write("<html><head></head><body>" +
                "<h1>Hello Servlet: " + servletName + "</h1>" +
                "Admin :" + admin + "<br/>" +
                "Email : " + email + "<br/>" +
                "</body></html>"
        );
    }

    public String getServletInfo() {
        return "hello basicServlet";
    }

    public void destroy() {

    }
}
