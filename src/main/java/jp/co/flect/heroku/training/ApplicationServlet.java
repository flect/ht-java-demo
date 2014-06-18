package jp.co.flect.heroku.training;

import org.glassfish.jersey.server.mvc.Viewable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/")
public class ApplicationServlet {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String get(@Context HttpServletRequest req) {
		HttpSession session = req.getSession();
		return "Hello World!";
	}

	@GET
	@Path("jsp")
	@Produces(MediaType.TEXT_HTML)
	public Viewable jsp(@Context HttpServletRequest req) {
		return new Viewable("/index.jsp");
	}
}
