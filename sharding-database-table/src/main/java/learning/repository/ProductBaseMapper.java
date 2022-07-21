package learning.repository;

import java.util.List;
import learning.entity.ProductBase;
import learning.vo.ProductTypeVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ProductBaseMapper {

  @Insert(value = "INSERT INTO `product_base`(shop_id,name,price,origin_address) VALUE(#{shopId}, #{name}, #{price}, #{originAddress});")
  @Options(useGeneratedKeys = true, keyProperty = "productId", keyColumn = "product_id")
  int insertProductBase(ProductBase productBase);

  @Select(value = "SELECT\n" +
      "\tpb.*,\n" +
      "\tpd.content\n" +
      "FROM\n" +
      "\tproduct_base pb\n" +
      "\tLEFT JOIN product_description pd ON pd.product_id = pb.product_id")
  ProductBase selectByProductId(Long productId);


  @Select("select * from product_base where product_id>#{productId}")
  List<ProductBase> selectByProductIdRange(Long productId);

  @Select("SELECT\n" +
      "\tpb.*,\n" +
      "\tpt.type_name \n" +
      "FROM\n" +
      "\tproduct_base pb\n" +
      "\tJOIN product_type pt ON pb.type = pt.type_id")
  List<ProductTypeVo> listType();
}
