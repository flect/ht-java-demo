package jp.co.flect.heroku.training;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(name="DatabaseServlet", urlPatterns={"/db"})
public class DatabaseServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			res.getWriter().print("Hello " + getString(1));
		} catch (SQLException | URISyntaxException e) {
			throw new ServletException(e);
		}
	}

	private static String getString(int id) throws SQLException, URISyntaxException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(e);
		}
		String databaseUrl = System.getenv("DATABASE_URL");
		URI uri = new URI(databaseUrl);
		String host = uri.getHost();
		int port = uri.getPort();
		if (port > 0) {
			host += ":" + port;
		}
		String db = uri.getPath();
		String username = uri.getUserInfo();
		String password = null;
		int idx = username.indexOf(":");
		if (idx != -1) {
			password = username.substring(idx + 1);
			username = username.substring(0, idx);
		}
		Connection con = DriverManager.getConnection(
			"jdbc:postgresql://" + host + db, username, password);
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT name FROM test WHERE id = ?");
			try {
				stmt.setInt(1, id);
				ResultSet rs = stmt.executeQuery();
				try {
					if (rs.next()) {
						return rs.getString(1);
					} else {
						return "Not found!";
					}
				} finally {
					rs.close();
				}
			} finally {
				stmt.close();
			}
		} finally {
			con.close();
		}
	}
}
