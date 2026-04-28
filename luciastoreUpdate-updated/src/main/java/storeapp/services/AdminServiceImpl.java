package storeapp.services;

import storeapp.domain.Admin;
import storeapp.domain.Customer;
import storeapp.repository.CustomerRepository;
import storeapp.utils.CustomerFormValidation;

import java.util.List;
import java.util.Optional;

public class AdminServiceImpl implements AdminService, CustumerAdminService {

    private final CustomerRepository customerRepository;

    public AdminServiceImpl(Admin admin, CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Admin createAdmin(Admin admin) {
        System.out.println("--- Crear Administrador ---");
        admin.setName(CustomerFormValidation.validateString("Ingrese el nombre del administrador"));
        admin.setLastName(CustomerFormValidation.validateString("Ingrese el apellido del administrador"));
        admin.setEmail(CustomerFormValidation.validateString("Ingrese el email del administrador"));
        admin.setPassword(CustomerFormValidation.validateString("Ingrese la contrasena del administrador"));
        admin.setRol(CustomerFormValidation.validateString("Ingrese el rol del administrador"));
        admin.setStatus(true);
        System.out.println(">>> Administrador creado exitosamente: " + admin.getName() + " " + admin.getLastName());
        return admin;
    }

    @Override
    public Optional<Admin> getAdminById(int id) {
        return Optional.empty();
    }

    @Override
    public Optional<Admin> getAdminByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public List<Admin> getAllAdmins() {
        return List.of();
    }

    @Override
    public Admin updateAdmin(Admin admin) {
        return null;
    }

    @Override
    public void deleteAdmin(int id) {
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAllCustomers();
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepository.deleteCustomer(id);
    }
}
