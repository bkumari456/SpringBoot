package org.sathyatech.app;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.sathyatech.app.model.Employee;

@Path("/product/source")
public class ProductResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/info/{empId}/{empName}/{empSal}")
	public String viewProduct(@BeanParam Employee emp,
			@Context UriInfo uriInfo,
			@Context HttpServletRequest req,
			@Context ServletContext ctx,
			@Context HttpHeaders header
			) {
		System.out.println(uriInfo.getPath());
		System.out.println(uriInfo.getQueryParameters());
		System.out.println(uriInfo.getAbsolutePath());
		System.out.println(uriInfo.getBaseUri());
		System.out.println(uriInfo.getPathSegments());
		System.out.println(uriInfo.getRequestUri());
		System.out.println(req.getRequestURI());
		System.out.println(req.getRequestURL());
		System.out.println(ctx.getContextPath());
		System.out.println(header.getAcceptableMediaTypes());
	
		return "Hello:"+emp.getEmpId()+",NAME:"+emp.getEmpName()+",SAL:"+emp.getEmpSal();
	}
}
