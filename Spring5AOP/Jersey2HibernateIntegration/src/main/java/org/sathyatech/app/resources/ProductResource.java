package org.sathyatech.app.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.sathyatech.app.model.Product;
import org.sathyatech.app.repo.ProductReposiroty;

@Path("/product")
public class ProductResource {
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("/create")
	public Response saveProduct(Product p) {
		int prodId=ProductReposiroty.saveProduct(p);
		return Response.ok("product saved with id:"+prodId).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/all")
	public Response getProducts() {
		List<Product> prodsList=ProductReposiroty.getAllProducts();
		return Response.ok(prodsList).build();
		
	}
}
