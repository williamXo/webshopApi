package api.persistence;

import api.model.Order;
import api.model.Product;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
public  interface OrderDAO {

    @SqlQuery("select * from `order` where order_id= :id")
    @RegisterRowMapper(OrderMapper.class)
    Order getOrderById(@Bind("id") int id);

    @SqlQuery("select * from `order` where user_id= :id")
    @RegisterRowMapper(OrderMapper.class)
    List<Order> getOrdersByUserId(@Bind("id") int id);


    @SqlUpdate("INSERT INTO `order` (user_id, date, total_amount) VALUES (:id, CURDATE(), total_amount)")
    void placeOrder(@BindBean Order order, @Bind("id") int id);

    @SqlUpdate("INSERT INTO order_product (order_id, product_id, price) VALUES (:order_id, :id, :price)")
    void placeOrderProduct(@BindBean Product product, @Bind("order_id") int id);

    @SqlQuery("SELECT order_id FROM `order` where user_id = :id order by order_id desc limit 1")
    int getOrderId(@Bind("id") int id);

    @SqlQuery("select * from `order`")
    @RegisterRowMapper(OrderMapper.class)
    List<Order> getOrders();
}