package learning.repository;

import learning.entity.ProductDescription;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ProductDescriptionMapper {

  @Insert(value = "INSERT INTO `product_description`(product_id,content,shop_id) VALUE(#{productId},#{content},#{shopId});")
  int insertProductDescribe(ProductDescription description);
}
