package learning.repository;

import com.learning.entity.Shop;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ShopMapper {

  @Insert(value = "INSERT INTO `shop`(shop_id,name,address,level) VALUE(#{shopId}, #{name}, #{address}, #{level});")
  @Options(useGeneratedKeys = true, keyProperty = "shopId", keyColumn = "shop_id")
  int insertProductBase(Shop shop);
}
