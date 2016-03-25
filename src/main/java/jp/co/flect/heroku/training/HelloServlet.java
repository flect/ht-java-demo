package jp.co.flect.heroku.training;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(name="HelloServlet", urlPatterns={"/"})
public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("TEST_VARIABLE   : " + System.getenv("TEST_VARIABLE"));
		res.getWriter().println("Hello World!");
		res.getWriter().println("Hello Every one!");
		res.getWriter().println("Hello Every one!");
	}
}
