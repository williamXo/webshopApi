package api.persistence;

import api.model.Product;
import api.model.User;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper  implements RowMapper<Product> {


    @Override
    public Product map(ResultSet rs, StatementContext ctx) throws SQLException {

            Product resultProduct = new Product();
            resultProduct.setId(rs.getInt("id"));
            resultProduct.setTitle(rs.getString("title"));
            resultProduct.setDescription(rs.getString("description"));
            resultProduct.setPrice(rs.getFloat("price"));
            resultProduct.setImage(rs.getString("image"));
            resultProduct.setThumb(rs.getString("thumb"));
            resultProduct.setStock(rs.getInt("stock"));
            resultProduct.setBrand(rs.getString("brand"));

            return resultProduct;
    }
}
