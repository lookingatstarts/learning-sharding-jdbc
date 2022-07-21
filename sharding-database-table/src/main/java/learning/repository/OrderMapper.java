package learning.repository;

import java.util.List;
import learning.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface OrderMapper {

  @Insert(value = "insert into `order` (order_id,user_id) value (#{orderId},#{userId})")
  int insert(Order order);

  @Select("select * from `order` where order_id>#{orderId}")
  List<Order> selectByOrderIdGt(Long orderId);

  @Select("select * from `order` where order_id=#{orderId}")
  Order selectByOrderId(Long orderId);

  @Select("select * from `order` where user_id=#{userId}")
  List<Order> selectByUserId(Long userId);

  @Select("select * from `order` where user_id>#{userId}")
  List<Order> selectByUserIdGt(Long userId);

  @Select("select * from `order` order by order_id desc limit #{offset},#{limit}")
  List<Order> selectLimit(Integer offset, Integer limit);
}
