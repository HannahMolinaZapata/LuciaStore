package storeapp.repository;

import storeapp.domain.Customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerRepository {

    List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(1, "John",  "Doe",   "jd@mail.com", "1234567890", true,  1000000.00, "Cliente Nuevo"),
            new Customer(2, "Jane",  "Smith", "js@mail.com", "1234567890", true,  2000000.00, "Cliente Antiguo")
    ));

    public Customer saveCustomer(Customer customer) {
        customers.add(customer);
        System.out.println(">>> Cliente guardado exitosamente.");
        return customer;
    }

    public List<Customer> findAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println(">>> No hay clientes registrados.");
            return customers;
        }
        System.out.println("------ Lista de Clientes ------");
        for (Customer c : customers) {
            System.out.println(
                "ID: " + c.getId() +
                " | Nombre: " + c.getName() + " " + c.getLastName() +
                " | Email: " + c.getEmail() +
                " | Estado: " + (c.isStatus() ? "Activo" : "Inactivo") +
                " | Cupo: $" + c.getQuote() +
                " | Tipo: " + c.getCustomerType()
            );
        }
        return customers;
    }

    public Customer findCustomerById(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                System.out.println(
                    "ID: " + customer.getId() +
                    " | Nombre: " + customer.getName() + " " + customer.getLastName() +
                    " | Email: " + customer.getEmail() +
                    " | Estado: " + (customer.isStatus() ? "Activo" : "Inactivo") +
                    " | Cupo: $" + customer.getQuote() +
                    " | Tipo: " + customer.getCustomerType()
                );
                return customer;
            }
        }
        System.out.println(">>> Cliente con ID " + id + " no encontrado.");
        return null;
    }

    public Customer updateCustomer(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    public void deleteCustomer(int id) {
        boolean removed = customers.removeIf(c -> c.getId() == id);
        if (removed) {
            System.out.println(">>> Cliente con ID " + id + " eliminado exitosamente.");
        } else {
            System.out.println(">>> Cliente con ID " + id + " no encontrado.");
        }
    }
}
