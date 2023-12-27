package co.com.bancolombia.model.products.gateways;


import co.com.bancolombia.model.products.Products;

import java.util.List;

public interface ProductsRepository {
    List<Products> findAllProducts();
    List<Integer> getSimilar(int id);
    List<Products> productsById(List<Integer> ids);

}
