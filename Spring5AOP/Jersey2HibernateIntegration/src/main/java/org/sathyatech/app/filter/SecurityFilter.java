package org.sathyatech.app.filter;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.internal.util.Base64;

//@Provider
public class SecurityFilter implements ContainerRequestFilter {

	@Context
	private ResourceInfo resourceInfo;
	
	@Context
	private HttpHeaders headers;
	
	@Override
	public void filter(ContainerRequestContext req) throws IOException {
			
		Method method=resourceInfo.getResourceMethod();
		if(!method.isAnnotationPresent(PermitAll.class)) {
			if(method.isAnnotationPresent(DenyAll.class)) {
				req.abortWith(Response.ok("No one can access this..").status(Status.FORBIDDEN).build());
				return;
			}
			List<String> authHeader=headers.getRequestHeader("Authorization");
			if(authHeader==null || authHeader.isEmpty()) {
				req.abortWith(Response.ok("Provider Access Details..").status(Status.BAD_REQUEST).build());
				return;
			}
			List<String> userDtls=getUserNameAndPassword(authHeader.get(0));
			if(method.isAnnotationPresent(RolesAllowed.class)) {
				List<String> rolesAllowed=Arrays.asList(method.getAnnotation(RolesAllowed.class).value());
				if(!validUser(userDtls,rolesAllowed)) {
					req.abortWith(Response.ok("Invalid User Details provided").status(Status.UNAUTHORIZED).build());
					return;
				}
			}
			
		}

	}

	//need to verify with DB
	private boolean validUser(List<String> userDtls, List<String> rolesAllowed) {
		if("admin".equals(userDtls.get(0)) && "admin".equals(userDtls.get(1)) && rolesAllowed.contains("ADMIN"))
			return true;
		else if("sam".equals(userDtls.get(0)) && "sam".equals(userDtls.get(1)) && rolesAllowed.contains("EMPLOYEE"))
			return true;
		return false;
	}

	private List<String> getUserNameAndPassword(String auth) {
		auth=auth.replace("Basic ", "");
		auth=new String(Base64.decode(auth.getBytes()));
		StringTokenizer str=new StringTokenizer(auth, ":");
		return Arrays.asList(str.nextToken(),str.nextToken());
	}
	
}








