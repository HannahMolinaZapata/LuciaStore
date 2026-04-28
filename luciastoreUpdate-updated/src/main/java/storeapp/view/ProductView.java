package storeapp.view;

import storeapp.services.ProductService;
import storeapp.utils.CustomerFormValidation;

public class ProductView {

    private final ProductService productService;

    public ProductView(ProductService productService) {
        this.productService = productService;
    }

    public void createProduct() {
        productService.createProduct();
    }

    public void getProductById(int id) {
        productService.getProductById(id);
    }

    public void getAllProducts() {
        productService.getAllProducts().forEach(System.out::println);
    }

    public void updateProduct() {
        productService.updateProduct(CustomerFormValidation.validateInt("Ingrese el id del producto a actualizar"));
    }

    public void deleteProduct() {
        productService.deleteProduct(CustomerFormValidation.validateInt("Ingrese el id del producto a eliminar"));
    }
}
