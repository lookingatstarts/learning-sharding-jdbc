package com.learning.repository;

import com.learning.entity.Order;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface OrderMapper {

  @Insert(value = "insert into t_order(order_id,user_id) value(#{orderId},#{userId})")
  int insert(Order order);

  @Select("select * from t_order where order_id>#{orderId}")
  Order selectByOrderIdGt(Long orderId);

  @Select("select * from t_order where order_id=#{orderId}")
  Order selectByOrderId(Long orderId);

  @Select("select * from t_order where user_id=#{userId}")
  List<Order> selectByUserId(Long userId);

  @Select("select * from t_order where user_id>#{userId}")
  List<Order> selectByUserIdGt(Long userId);
}
