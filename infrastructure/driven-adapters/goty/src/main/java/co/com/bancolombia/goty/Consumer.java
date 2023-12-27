package co.com.bancolombia.goty;

import co.com.bancolombia.model.products.Products;
import co.com.bancolombia.model.products.gateways.ProductsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class Consumer implements ProductsRepository {
    @SneakyThrows
    @Override
    public List<Products> findAllProducts() {
        HttpResponse<String> response = configureConnection("http://localhost:3100/api/products");
        ObjectMapper objectMapper = new ObjectMapper();
        List<Response> responseProductList = objectMapper.readValue(response.body(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, Response.class));
        return mapperProduct(responseProductList);
    }

    @SneakyThrows
    private HttpResponse<String> configureConnection(String s) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(s))
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    @Override
    public List<Integer> getSimilar(int id) {
        return null;
    }

    @Override
    public List<Products> productsById(List<Integer> ids) {
        return null;
    }

    private List<Products> mapperProduct(List<Response> responseProductList) {
        ModelMapper modelMapper = new ModelMapper();
        return responseProductList.stream().map(responseProductOrigin ->
                        modelMapper.map(responseProductOrigin, Products.class))
                .collect(Collectors.toList());
    }
}
