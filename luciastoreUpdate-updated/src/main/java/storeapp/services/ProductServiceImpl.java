package storeapp.services;

import storeapp.domain.Category;
import storeapp.domain.Product;
import storeapp.domain.enums.ProductState;
import storeapp.repository.ProductRepository;
import storeapp.utils.CustomerFormValidation;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct() {
        Product product = new Product();

        product.setIdProduct(CustomerFormValidation.validateInt("Ingrese el id del producto"));
        product.setDescription(CustomerFormValidation.validateString("Ingrese el nombre del producto"));
        product.setPrice(CustomerFormValidation.validateDouble("Ingrese el precio del producto"));
        product.setStock(CustomerFormValidation.validateInt("Ingrese el stock del producto"));
        product.setProductState(ProductStateSelector.selectProductState());

        Category category = new Category();
        category.setIdCategory(CustomerFormValidation.validateInt("Ingrese el id de la categoria"));
        category.setDescription(CustomerFormValidation.validateString("Ingrese el nombre de la categoria"));
        category.setState(true);
        product.setCategory(category);

        return productRepository.saveProduct(product);
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.findProductById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAllProducts();
    }

    @Override
    public Product updateProduct(int id) {
        Product product = productRepository.findProductById(id);

        if (product == null) {
            System.out.println(">>> Producto con ID " + id + " no encontrado.");
            return null;
        }

        System.out.println("Que desea actualizar?");
        System.out.println("1. Nombre  2. Precio  3. Stock  4. Estado");
        int option = CustomerFormValidation.validateInt("Opcion");

        switch (option) {
            case 1:
                product.setDescription(CustomerFormValidation.validateString("Nuevo nombre"));
                break;
            case 2:
                product.setPrice(CustomerFormValidation.validateDouble("Nuevo precio"));
                break;
            case 3:
                product.setStock(CustomerFormValidation.validateInt("Nuevo stock"));
                break;
            case 4:
                product.setProductState(ProductStateSelector.selectProductState());
                break;
            default:
                System.out.println(">>> Opcion no valida. No se realizo ninguna actualizacion.");
                return product;
        }

        System.out.println(">>> Producto actualizado exitosamente.");
        return product;
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteProduct(id);
    }
}
