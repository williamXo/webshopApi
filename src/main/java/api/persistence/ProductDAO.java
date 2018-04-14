package api.persistence;

import api.model.Product;
import api.model.User;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public  interface ProductDAO {

    @SqlQuery("select * from product")
    @RegisterRowMapper(ProductMapper.class)
    List<Product> getProducts();

    @SqlUpdate("UPDATE product SET title= :title, description= :description, price= :price, image= :image, thumb= :thumb, stock= :stock, brand= :brand WHERE id = :id")
    void updateProduct(@BindBean Product product);

    @SqlUpdate("INSERT INTO product (title, description, price, image, thumb, stock, brand) VALUES ( :title,  :description, :price, :image, :thumb, :stock, :brand )")
    void addProduct(@BindBean Product product);

    @SqlQuery("select * from product where id= :id")
    @RegisterRowMapper(ProductMapper.class)
    Product getProductById(@Bind("id") int id);

    @SqlQuery("select * from product JOIN order_product on product.id = product_id where order_id = :id")
    @RegisterRowMapper(ProductMapper.class)
    List<Product> getProductsByOrder(@Bind("id") int id);
}
