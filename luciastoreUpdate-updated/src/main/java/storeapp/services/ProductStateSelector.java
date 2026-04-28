package storeapp.services;

import storeapp.domain.enums.ProductState;
import storeapp.utils.CustomerFormValidation;

public class ProductStateSelector {

    public static ProductState selectProductState() {

        System.out.println("Seleccione el estado del producto:");
        System.out.println("1. Disponible  2. Sin stock  3. Descontinuado");

        int option = CustomerFormValidation.validateInt("Opcion");

        switch (option) {
            case 1:
                return ProductState.AVAILABLE;
            case 2:
                return ProductState.OUT_OF_STOCK;
            case 3:
                return ProductState.DISCONTINUED;
            default:
                System.out.println("Opcion no valida, se asignara Disponible por defecto");
                return ProductState.AVAILABLE;
        }
    }
}
