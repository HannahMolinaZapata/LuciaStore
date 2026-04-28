package storeapp.repository;

import storeapp.domain.Category;
import storeapp.domain.Product;
import storeapp.domain.enums.ProductState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductRepository {

    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1, "Camiseta Blanca",  35000.00, 10, ProductState.AVAILABLE,  new Category(1, "Ropa", true)),
            new Product(2, "Zapatos Negros",  120000.00, 5, ProductState.AVAILABLE,  new Category(2, "Calzado", true)),
            new Product(3, "Bolso de Cuero",  85000.00, 0, ProductState.OUT_OF_STOCK, new Category(3, "Accesorios", true))
    ));

    public Product saveProduct(Product product) {
        products.add(product);
        return product;
    }

    public List<Product> findAllProducts() {
        for (Product product : products) {
            System.out.println(product.getIdProduct() + " | " + product.getDescription()
                    + " | $" + product.getPrice()
                    + " | Stock: " + product.getStock()
                    + " | Estado: " + product.getProductState()
                    + " | Categoria: " + product.getCategory().getDescription());
        }
        return products;
    }

    public Product findProductById(int id) {
        for (Product product : products) {
            if (product.getIdProduct() == id) {
                System.out.println(product.getIdProduct() + " | " + product.getDescription()
                        + " | $" + product.getPrice()
                        + " | Stock: " + product.getStock()
                        + " | Estado: " + product.getProductState()
                        + " | Categoria: " + product.getCategory().getDescription());
                return product;
            }
        }
        System.out.println("Producto no encontrado");
        return null;
    }

    public Product updateProduct(int id) {
        for (Product product : products) {
            if (product.getIdProduct() == id) {
                return product;
            }
        }
        return null;
    }

    public void deleteProduct(int id) {
        products.removeIf(product -> product.getIdProduct() == id);
    }
}
