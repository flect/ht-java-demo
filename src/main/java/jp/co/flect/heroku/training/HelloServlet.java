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
		System.out.println("Heroku App PORT   : " + System.getenv("PORT"));
		res.getWriter().print("Hello World!");
		res.getWriter().print("By review app 1!");
	}
}
