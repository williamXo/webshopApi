package api.resources;

import api.model.Product;
import api.service.ProductService;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {
    private  final ProductService service;

    public ProductResource(ProductService service) {
        this.service = service;
    }


    @GET
    @Path("/{id}")
    public Product getProductById(@PathParam("id")int id)
    {
        return service.getProductById(id);
    }

    @GET
    public List<Product> getProducts()
    {
        return service.getProducts();
    }



    @PUT
    @RolesAllowed("admin")
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateUser(Product product){
        service.updateProduct(product);
    }

    @POST
    @RolesAllowed("admin")
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addProduct(Product product){
        service.addProduct(product);
    }



}