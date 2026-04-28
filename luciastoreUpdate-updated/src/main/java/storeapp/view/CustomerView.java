package storeapp.view;

import storeapp.services.CustumerService;
import storeapp.utils.CustomerFormValidation;

public class CustomerView {

    private final CustumerService customerService;

    public CustomerView(CustumerService customerService) {
        this.customerService = customerService;
    }

    public void createCustomer() {
        System.out.println("--- Crear Cliente ---");
        customerService.createCustomer();
    }

    public void getCustumerById(int id) {
        System.out.println("--- Buscar Cliente ---");
        customerService.getCustomerById(id);
    }

    public void updateCustumer() {
        System.out.println("--- Actualizar Cliente ---");
        int id = CustomerFormValidation.validateInt("Ingrese el ID del cliente a actualizar");
        customerService.updateCustomer(id);
    }

    public void deleteCustomer() {
        System.out.println("--- Eliminar Cliente ---");
        int id = CustomerFormValidation.validateInt("Ingrese el ID del cliente a eliminar");
        customerService.deleteCustomer(id);
    }
}
