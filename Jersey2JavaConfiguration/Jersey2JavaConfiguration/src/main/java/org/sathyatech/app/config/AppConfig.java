package org.sathyatech.app.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("webapi")
public class AppConfig extends ResourceConfig {

	public AppConfig() {
		packages("org.sathyatech.app.resources");
	}
}
