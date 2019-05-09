package com.example.helloweb.basicServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "HttpServletTest", urlPatterns = "/httpServletTest")
public class HttpServletTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.getWriter().write("<html>\n" +
                "<body>\n" +
                "<h2>hello Servlet</h2>\n" +
                "</body>\n" +
                "</html>");
    }

}
