package co.com.bancolombia.model.products;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Products {
    private int id;
    private String name;
    private String url;
    private int price;
}
