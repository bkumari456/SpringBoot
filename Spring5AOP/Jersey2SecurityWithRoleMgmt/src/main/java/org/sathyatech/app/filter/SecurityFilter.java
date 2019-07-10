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

public class SecurityFilter implements ContainerRequestFilter {


	@Context
	private ResourceInfo resource;
	@Context
	private HttpHeaders head;

	@Override
	public void filter(ContainerRequestContext req) throws IOException {
		Method m=resource.getResourceMethod();
		if(!m.isAnnotationPresent(PermitAll.class)) {

			if(m.isAnnotationPresent(DenyAll.class)) {
				req.abortWith(Response.ok("This Request can be processed").status(Status.FORBIDDEN).build());
				return;
			}

			List<String> reqHeaders=head.getRequestHeaders().get("Authorization");

			if(reqHeaders==null || reqHeaders.isEmpty()) {
				req.abortWith(Response.ok("Provide Authorization Header in Request").status(Status.UNAUTHORIZED).build());
				return ;
			}

			List<String> userDetails=getUserNameAndPwd(reqHeaders.get(0));
			if(m.isAnnotationPresent(RolesAllowed.class)){
				List<String> roles=Arrays.asList(m.getAnnotation(RolesAllowed.class).value());
				if(!isValidUser(userDetails,roles)) {
					req.abortWith(Response.ok("Invalid User Details Provided").status(Status.UNAUTHORIZED).build());
					return;
				}
			}else {
				if(!isValidUser(userDetails,Arrays.asList("ALLPERMIT"))) {
					req.abortWith(Response.ok("Invalid User Details Provided").status(Status.UNAUTHORIZED).build());
					return;
				}
			}

		}
	}

	private boolean isValidUser(List<String> userDetails, List<String> roles) {
		boolean flag=false;
		if(userDetails!=null && roles!=null) {
			if("admin".equals(userDetails.get(0)) && "sathya".equals(userDetails.get(1)) 
					&& (roles.contains("ALLPERMIT") || roles.contains("ADMIN")))
				flag=true;
			else if("emp".equals(userDetails.get(0)) && "sathya".equals(userDetails.get(1)) 
					&& (roles.contains("ALLPERMIT") || roles.contains("EMP")))
				flag=true;

		}
		return flag;
	}

	private List<String> getUserNameAndPwd(String auth) {
		auth=auth.replace("Basic ", "");
		byte[] arr=Base64.decode(auth.getBytes());
		auth=new String(arr);
		StringTokenizer str=new StringTokenizer(auth, ":");
		return Arrays.asList(str.nextToken(),str.nextToken());
	}

}
