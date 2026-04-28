package storeapp.userinterface;

import storeapp.utils.CustomerFormValidation;
import storeapp.view.AdminView;
import storeapp.view.CustomerView;
import storeapp.view.ProductView;

public class MenuApp {

    private final CustomerView customerView;
    private final AdminView adminView;
    private final ProductView productView;

    public MenuApp(CustomerView customerView, AdminView adminView, ProductView productView) {
        this.customerView = customerView;
        this.adminView = adminView;
        this.productView = productView;
    }

    public void showMainMenu() {
        System.out.println("========================================");
        System.out.println("   Bienvenido a la Tienda Online");
        System.out.println("========================================");

        while (true) {
            System.out.println("\n1. Registrar Usuario  2. Iniciar Sesion  3. Salir");
            int option = CustomerFormValidation.validateInt("Seleccione una opcion");

            switch (option) {
                case 1:
                    registrarUsuario();
                    break;
                case 2:
                    System.out.println("Seleccione perfil: 1. Administrador  2. Cliente");
                    int perfil = CustomerFormValidation.validateInt("Opcion");
                    if (perfil == 1) {
                        profileSelector("admin");
                    } else if (perfil == 2) {
                        profileSelector("customer");
                    } else {
                        System.out.println(">>> Opcion no valida.");
                    }
                    break;
                case 3:
                    System.out.println("Saliendo de la aplicacion. Hasta luego!");
                    return;
                default:
                    System.out.println(">>> Opcion no valida, por favor seleccione 1, 2 o 3.");
            }
        }
    }

    private void registrarUsuario() {
        System.out.println("Registrar Usuario:");
        System.out.println("1. Cliente  2. Administrador");
        int userType = CustomerFormValidation.validateInt("Opcion");
        if (userType == 1) {
            customerView.createCustomer();
        } else if (userType == 2) {
            adminView.createAdmin();
        } else {
            System.out.println(">>> Opcion no valida.");
        }
    }

    public void profileSelector(String profile) {
        if (profile.equals("admin")) {
            showMenuAdmin();
        } else if (profile.equals("customer")) {
            showMenuCustomer();
        }
    }

    public void showMenuAdmin() {
        while (true) {
            System.out.println("\n====== Menu Administrador ======");
            System.out.println("1. Gestionar Productos  2. Gestionar Clientes  3. Salir");
            int option = CustomerFormValidation.validateInt("Seleccione una opcion");

            switch (option) {
                case 1:
                    productMenuAdmin();
                    break;
                case 2:
                    customerMenuAdmin();
                    break;
                case 3:
                    System.out.println("Saliendo del menu de administrador.");
                    return;
                default:
                    System.out.println(">>> Opcion no valida.");
            }
        }
    }

    public void showMenuCustomer() {
        while (true) {
            System.out.println("\n====== Menu Cliente ======");
            System.out.println("1. Crear mi perfil  2. Ver mi perfil por ID  3. Modificar mi perfil  4. Salir");
            int option = CustomerFormValidation.validateInt("Seleccione una opcion");

            switch (option) {
                case 1:
                    customerView.createCustomer();
                    break;
                case 2:
                    int id = CustomerFormValidation.validateInt("Ingrese su ID para ver su perfil");
                    customerView.getCustumerById(id);
                    break;
                case 3:
                    customerView.updateCustumer();
                    break;
                case 4:
                    System.out.println("Saliendo del menu de cliente.");
                    return;
                default:
                    System.out.println(">>> Opcion no valida.");
            }
        }
    }

    public void customerMenuAdmin() {
        while (true) {
            System.out.println("\n--- Gestion de Clientes ---");
            System.out.println("1. Crear cliente  2. Buscar por ID  3. Actualizar  4. Ver todos  5. Eliminar  6. Volver");
            int option = CustomerFormValidation.validateInt("Seleccione una opcion");

            switch (option) {
                case 1:
                    customerView.createCustomer();
                    break;
                case 2:
                    int id = CustomerFormValidation.validateInt("Ingrese el ID del cliente a buscar");
                    customerView.getCustumerById(id);
                    break;
                case 3:
                    customerView.updateCustumer();
                    break;
                case 4:
                    adminView.getAllCustomers();
                    break;
                case 5:
                    customerView.deleteCustomer();
                    break;
                case 6:
                    return;
                default:
                    System.out.println(">>> Opcion no valida.");
            }
        }
    }

    public void productMenuAdmin() {
        while (true) {
            System.out.println("\n--- Gestion de Productos ---");
            System.out.println("1. Crear producto  2. Buscar por ID  3. Actualizar  4. Ver todos  5. Eliminar  6. Volver");
            int option = CustomerFormValidation.validateInt("Seleccione una opcion");

            switch (option) {
                case 1:
                    productView.createProduct();
                    break;
                case 2:
                    int id = CustomerFormValidation.validateInt("Ingrese el ID del producto a buscar");
                    productView.getProductById(id);
                    break;
                case 3:
                    productView.updateProduct();
                    break;
                case 4:
                    productView.getAllProducts();
                    break;
                case 5:
                    productView.deleteProduct();
                    break;
                case 6:
                    return;
                default:
                    System.out.println(">>> Opcion no valida.");
            }
        }
    }
}
