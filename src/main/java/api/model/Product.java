package api.model;

import api.View;
import com.fasterxml.jackson.annotation.JsonView;

public class Product {

    @JsonView(View.Public.class)
    private int id;

    @JsonView(View.Public.class)
    private String description;

    @JsonView(View.Public.class)
    private String title;

    @JsonView(View.Public.class)
    private float price;

    @JsonView(View.Public.class)
    private String image;

    @JsonView(View.Public.class)
    private String thumb;

    @JsonView(View.Public.class)
    private Integer stock;

    @JsonView(View.Public.class)
    private String brand;


    public Product (){}

    public Product(int id, String description, float price, String image, String thumb, Integer stock, String brand) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.image = image;
        this.thumb = thumb;
        this.stock = stock;
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
