package storeapp.view;

import storeapp.domain.Admin;
import storeapp.services.AdminServiceImpl;

public class AdminView {

    private final AdminServiceImpl adminService;
    private final Admin admin;

    public AdminView(AdminServiceImpl adminService, Admin admin) {
        this.adminService = adminService;
        this.admin = admin;
    }

    public void createAdmin() {
        adminService.createAdmin(admin);
    }

    public void getAllCustomers() {
        System.out.println("--- Lista de Clientes ---");
        adminService.getAllCustomers().forEach(c ->
            System.out.println(
                "ID: " + c.getId() +
                " | " + c.getName() + " " + c.getLastName() +
                " | " + c.getEmail() +
                " | Estado: " + (c.isStatus() ? "Activo" : "Inactivo") +
                " | Cupo: $" + c.getQuote() +
                " | Tipo: " + c.getCustomerType()
            )
        );
    }
}
