package api.resources;

import api.model.Order;
import api.model.User;
import api.service.OrderService;
import io.dropwizard.auth.Auth;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/order")
@Produces(MediaType.APPLICATION_JSON)
public class OrderResource {
    private  final OrderService service;

    public OrderResource(OrderService service) {
        this.service = service;
    }


    @GET
    @RolesAllowed("admin")
    public List<Order> getOrders(){
        return service.getOrders();
    }


    @GET
    @PermitAll
    @Path("/{id}")
    public Order getOrderById(@PathParam("id")int id)
    {
        return service.getOrderById(id);
    }

    @GET
    @RolesAllowed("admin")
    @Path("/user/{id}")
    public List<Order> GetOrderByUserId(@PathParam("id")int id)
    {
       return service.getOrdersByUser(id);
    }

    @GET
    @PermitAll
    @Path("/user")
    public List<Order> GetOrderByUserId( @Auth User user)
    {
        return service.getOrdersByUser(user.id);
    }


    @POST
    @PermitAll
    @Consumes(MediaType.APPLICATION_JSON)
    public void PlaceOrderByUserId(Order order, @Auth User user)
    {
        service.placeOrder(order, user.id);
    }

}