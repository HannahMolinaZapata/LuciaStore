package storeapp.services;

import storeapp.domain.Customer;
import storeapp.repository.CustomerRepository;
import storeapp.utils.CustomerFormValidation;

import java.util.Optional;

public class CustumerServiceImpl implements CustumerService {

    private final CustomerRepository customerRepository;

    public CustumerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer createCustomer() {
        Customer customer = new Customer();

        customer.setId(CustomerFormValidation.validateInt("Ingrese el id del cliente"));
        customer.setName(CustomerFormValidation.validateString("Ingrese el nombre del cliente"));
        customer.setLastName(CustomerFormValidation.validateString("Ingrese el apellido del cliente"));
        customer.setEmail(CustomerFormValidation.validateString("Ingrese el email del cliente"));
        customer.setPassword(CustomerFormValidation.validateString("Ingrese la contrasena del cliente"));
        customer.setStatus(CustomerStateSelector.selectCustomerState());
        customer.setQuote(CustomerFormValidation.validateDouble("Ingrese el cupo del cliente"));
        customer.setCustomerType(CustomerTypeSelector.selectTypeCustomer());

        return customerRepository.saveCustomer(customer);
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerRepository.findCustomerById(id);
    }

    @Override
    public Optional<Customer> getCustomerByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Customer updateCustomer(int id) {
        Customer customer = customerRepository.findCustomerById(id);

        if (customer == null) {
            System.out.println(">>> Cliente con ID " + id + " no encontrado.");
            return null;
        }

        System.out.println("Que desea actualizar?");
        System.out.println("1. Nombre  2. Apellido  3. Correo  4. Contrasena  5. Estado  6. Cupo  7. Tipo de cliente");
        int option = CustomerFormValidation.validateInt("Opcion");

        switch (option) {
            case 1:
                customer.setName(CustomerFormValidation.validateString("Nuevo nombre"));
                break;
            case 2:
                customer.setLastName(CustomerFormValidation.validateString("Nuevo apellido"));
                break;
            case 3:
                customer.setEmail(CustomerFormValidation.validateString("Nuevo email"));
                break;
            case 4:
                customer.setPassword(CustomerFormValidation.validateString("Nueva contrasena"));
                break;
            case 5:
                customer.setStatus(CustomerStateSelector.selectCustomerState());
                break;
            case 6:
                customer.setQuote(CustomerFormValidation.validateDouble("Nuevo cupo"));
                break;
            case 7:
                customer.setCustomerType(CustomerTypeSelector.selectTypeCustomer());
                break;
            default:
                System.out.println(">>> Opcion no valida. No se realizo ninguna actualizacion.");
                return customer;
        }

        System.out.println(">>> Cliente actualizado exitosamente.");
        return customer;
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepository.deleteCustomer(id);
    }
}
