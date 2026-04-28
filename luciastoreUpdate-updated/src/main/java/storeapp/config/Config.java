package storeapp.config;

import storeapp.domain.Admin;
import storeapp.repository.CustomerRepository;
import storeapp.repository.ProductRepository;
import storeapp.services.AdminServiceImpl;
import storeapp.services.CustumerService;
import storeapp.services.CustumerServiceImpl;
import storeapp.services.ProductService;
import storeapp.services.ProductServiceImpl;
import storeapp.userinterface.MenuApp;
import storeapp.view.AdminView;
import storeapp.view.CustomerView;
import storeapp.view.ProductView;

public class Config {

    public static MenuApp createMenuApp(){

        Admin admin = new Admin();
        CustomerRepository customerRepository = new CustomerRepository();
        CustumerService customerService = new CustumerServiceImpl(customerRepository);
        CustomerView customerView = new CustomerView(customerService);
        AdminServiceImpl adminService = new AdminServiceImpl(admin, customerRepository);
        AdminView adminView = new AdminView(adminService, admin);

        // Producto - mismo patron que Customer
        ProductRepository productRepository = new ProductRepository();
        ProductService productService = new ProductServiceImpl(productRepository);
        ProductView productView = new ProductView(productService);

        return new MenuApp(customerView, adminView, productView);
    }
}
