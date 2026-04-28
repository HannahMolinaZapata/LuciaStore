package storeapp.domain;

import storeapp.domain.enums.ProductState;

public class Product {

    private int idProduct;
    private String description;
    private double price;
    private int stock;
    private ProductState productState;
    Category category;

    public Product(int idProduct, String description, double price, int stock, ProductState productState, Category category) {
        this.idProduct = idProduct;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.productState = productState;
        this.category = category;
    }

    public Product() {
    }

    public int getIdProduct() { return idProduct; }
    public void setIdProduct(int idProduct) { this.idProduct = idProduct; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public ProductState getProductState() { return productState; }
    public void setProductState(ProductState productState) { this.productState = productState; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", productState=" + productState +
                ", category=" + (category != null ? category.getDescription() : "N/A") +
                '}';
    }
}
