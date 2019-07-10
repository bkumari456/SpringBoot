package org.sathyatech.app.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("api")
public class AppConfig extends ResourceConfig {

	public AppConfig() {
		packages("org.sathyatech.app.resources"
				//,"org.sathyatech.app.filter"
				);
		//register(SecurityFilter.class);
	}
}
