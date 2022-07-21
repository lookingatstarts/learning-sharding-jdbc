package learning.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductBase {

  private Long productId;
  private String name;
  private Long price;
  private Long shopId;
  private Long type;
}
