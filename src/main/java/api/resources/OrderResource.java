package api.resources;

import api.model.Order;
import api.service.OrderService;

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
    public List<Order> getOrders(){
        return service.getOrders();
    }


    @GET
    @Path("/{id}")
    public Order getOrderById(@PathParam("id")int id)
    {
        return service.getOrderById(id);
    }

    @GET
    @Path("/user/{id}")
    public List<Order> GetOrderByUserId(@PathParam("id")int id)
    {
       return service.getOrdersByUser(id);
    }

    @POST
    @Path("/user/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void PlaceOrderByUserId(Order order, @PathParam("id")int id)
    {
        service.placeOrder(order, id);
    }

}