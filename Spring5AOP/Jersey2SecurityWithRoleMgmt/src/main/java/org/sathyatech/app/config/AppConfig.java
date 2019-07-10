package org.sathyatech.app.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.sathyatech.app.filter.SecurityFilter;



@ApplicationPath("/rest")
public class AppConfig extends ResourceConfig{

	public AppConfig() {
		packages("org.sathyatech.app.resource");
		register(new SecurityFilter());
	}
}
