package com.learning.repository;

import com.learning.entity.Product;
import com.learning.vo.ProductTypeVo;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ProductMapper {

  @Insert(value = "INSERT INTO `product_base`(shop_id,name,price,origin_address) VALUE(#{shopId}, #{name}, #{price}, #{originAddress});")
  @Options(useGeneratedKeys = true, keyProperty = "productId", keyColumn = "product_id")
  int insertProductBase(Product product);

  @Insert(value = "INSERT INTO `product_description`(product_id,content,shop_id) VALUE(#{productId},#{content},#{shopId});")
  int insertProductDescribe(@Param("productId") Long productId, @Param("content") String content,
      @Param("shopId") Long shopId);

  @Select(value = "SELECT\n" +
      "\tpb.*,\n" +
      "\tpd.content\n" +
      "FROM\n" +
      "\tproduct_base pb\n" +
      "\tLEFT JOIN product_description pd ON pd.product_id = pb.product_id")
  Product selectByProductId(Long productId);


  @Select("select * from product_base where product_id>#{productId}")
  List<Product> selectByProductIdRange(Long productId);

  @Select("SELECT\n" +
      "\tpb.*,\n" +
      "\tpt.type_name \n" +
      "FROM\n" +
      "\tproduct_base pb\n" +
      "\tJOIN product_type pt ON pb.type = pt.type_id")
  List<ProductTypeVo> listType();
}
