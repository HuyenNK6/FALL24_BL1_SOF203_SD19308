package b11.product.entity;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    private Integer id;
    private Category category;
    private String name;
    private String code;
    private Float price;
    private String description;
}
