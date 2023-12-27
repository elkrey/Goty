package co.com.bancolombia.usecase.products;

import co.com.bancolombia.model.products.Products;
import co.com.bancolombia.model.products.gateways.ProductsRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UseCaseProductsUseCase {
    private final ProductsRepository productsRepository;

    public List<Products> findAllProducts() {
        return productsRepository.findAllProducts();
    }

    public List<Products> getSimilarProduct(int id) {
        return productsRepository.productsById(productsRepository.getSimilar(id));
    }
}
