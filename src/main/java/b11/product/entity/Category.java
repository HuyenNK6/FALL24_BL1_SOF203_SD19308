package b11.product.entity;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Category {
    private Integer id;
    private String code;
    private String name;
}
