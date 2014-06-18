package jp.co.flect.heroku.training;

import org.glassfish.jersey.server.ResourceConfig;
import javax.ws.rs.ApplicationPath;

/**
 * Created by shimizu on 2014/06/18.
 */
@ApplicationPath("/*")
public class Application extends ResourceConfig{
	public Application() {
		packages("jp.co.flect.heroku.training");
	}
}
