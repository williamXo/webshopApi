package api.persistence;

import api.model.Order;
import api.model.Product;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;




public class OrderMapper  implements RowMapper<Order> {


    @Override
    public Order map(ResultSet rs, StatementContext ctx) throws SQLException {

        Order resultOrder = new Order();
        resultOrder.setOrder_id(rs.getInt("order_id"));
        resultOrder.setUser_id(rs.getInt("user_id"));
        resultOrder.setDate(rs.getDate("date"));
        resultOrder.setTotal_amount(rs.getFloat("total_amount"));
        return resultOrder;
    }
}
