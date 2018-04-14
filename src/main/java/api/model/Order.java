package api.model;

import api.View;
import com.fasterxml.jackson.annotation.JsonView;
import org.joda.time.DateTime;

import java.lang.reflect.Array;
import java.sql.Date;
import java.util.List;

public class Order {

    @JsonView(View.Public.class)
    private int order_id;

    @JsonView(View.Public.class)
    private int user_id;

    @JsonView(View.Public.class)
    private Date date;

    @JsonView(View.Public.class)
    private float total_amount;

    @JsonView(View.Public.class)
    private List<Product> products;


    public Order (){}

    public Order(int id, int user_id, Date date, float total_amount, List<Product> products) {
        this.order_id = id;
        this.user_id = user_id;
        this.date = date;
        this.total_amount = total_amount;
        this.products = products;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(float total_amount) {
        this.total_amount = total_amount;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
