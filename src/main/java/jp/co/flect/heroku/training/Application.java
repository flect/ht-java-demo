package jp.co.flect.heroku.training;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;

import javax.ws.rs.ApplicationPath;

/**
 * Created by shimizu on 2014/06/18.
 */
@ApplicationPath("/demo")
public class Application extends ResourceConfig{
	public Application() {
		register(JspMvcFeature.class);
		property(JspMvcFeature.TEMPLATES_BASE_PATH, "/WEB-INF/jsp/");
		packages("jp.co.flect.heroku.training");
	}
}
