package api.service;

import api.model.Order;
import api.model.Product;
import api.persistence.OrderDAO;
import api.persistence.ProductDAO;
import org.jdbi.v3.core.Jdbi;

import java.util.ArrayList;
import java.util.List;


public class OrderService {
    private ProductDAO productDAO;
    private OrderDAO orderDAO;

    public OrderService(Jdbi jdbi) {
        this.productDAO = jdbi.onDemand(ProductDAO.class);
        this.orderDAO = jdbi.onDemand(OrderDAO.class);
    }
    public List<Order> getOrdersByUser(int id){
    return  this.orderDAO.getOrdersByUserId(id);
    }

    public Order getOrderById(int id){
    Order result = this.orderDAO.getOrderById(id);
    result.setProducts(this.productDAO.getProductsByOrder(id));
    return result;
    }

    public void placeOrder(Order order, int userId){

        this.orderDAO.placeOrder(order, userId);
        int id = this.orderDAO.getOrderId(userId);
        for (Product product : order.getProducts()) {
            this.orderDAO.placeOrderProduct(product, id);
        }
    }

    public List<Order> getOrders() {
     return this.orderDAO.getOrders();
    }
}
