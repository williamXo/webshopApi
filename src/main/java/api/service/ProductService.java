package api.service;

import api.model.Product;
import api.persistence.ProductDAO;
import org.jdbi.v3.core.Jdbi;

import java.util.List;

public class ProductService {
    private ProductDAO dao;

    public ProductService(Jdbi jdbi) {
        this.dao = jdbi.onDemand(ProductDAO.class);
    }

    public List<Product> getProducts(){
        return dao.getProducts();
    }

    public void updateProduct(Product product){
        dao.updateProduct(product);
    }

    public void addProduct(Product product){
    dao.addProduct(product);
    }

    public Product getProductById(int id){
        return dao.getProductById(id);
    }
}
