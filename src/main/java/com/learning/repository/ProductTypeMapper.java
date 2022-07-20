package com.learning.repository;

import com.learning.entity.ProductType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface ProductTypeMapper {

  @Insert(value = "INSERT INTO `product_type`(type_id,type_name) VALUE(#{typeId}, #{typeName});")
  int insert(ProductType productType);
}
