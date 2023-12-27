package co.com.bancolombia.api;

import co.com.bancolombia.model.products.Products;
import co.com.bancolombia.usecase.products.UseCaseProductsUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class Api {
    private final UseCaseProductsUseCase useCaseProductsUseCase;

    @GetMapping("/goty/products")
    public List<Products> getAllProducts() {
        return useCaseProductsUseCase.findAllProducts();
    }

    @GetMapping("/goty/similars/{id}")
    public List<Products> similarProducts(@PathVariable("id") int id) {
        return useCaseProductsUseCase.getSimilarProduct(id);
    }
}
