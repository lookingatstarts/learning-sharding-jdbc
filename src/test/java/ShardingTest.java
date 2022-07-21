import com.learning.LearningShardingJdbcApplication;
import com.learning.entity.Order;
import com.learning.entity.ProductBase;
import com.learning.entity.ProductDescription;
import com.learning.entity.ProductType;
import com.learning.entity.User;
import com.learning.repository.OrderMapper;
import com.learning.repository.ProductBaseMapper;
import com.learning.repository.ProductDescriptionMapper;
import com.learning.repository.ProductTypeMapper;
import com.learning.repository.UserMapper;
import com.learning.vo.ProductTypeVo;
import java.util.List;
import java.util.Random;
import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LearningShardingJdbcApplication.class)
public class ShardingTest {

  private final static SnowflakeShardingKeyGenerator generator = new SnowflakeShardingKeyGenerator();
  @Autowired
  private ProductBaseMapper productBaseMapper;
  @Autowired
  private ProductDescriptionMapper productDescriptionMapper;
  @Autowired
  private ProductTypeMapper productTypeMapper;
  @Autowired
  private UserMapper userMapper;
  @Autowired
  private OrderMapper orderMapper;

  @Test
  public void OrderTest7() {
    // 没有分片键，全库路由
    List<Order> selectLimit = orderMapper.selectLimit(1, 2);
    Order order = orderMapper.selectByOrderId(7568258194598789132L);
    List<Order> orderGtList= orderMapper.selectByOrderIdGt(7568258194598789132L);
    List<Order> orders = orderMapper.selectByUserId(756825787356676096L);
    List<Order> ordersGtList2 = orderMapper.selectByUserIdGt(756825787356676096L);
  }

  @Test
  public void OrderTest6() {
    // order表有10个库
    for (int i = 0; i < 10; i++) {
      Order order = new Order();
      Long userId = (Long) generator.generateKey();
      Long orderId = (Long) generator.generateKey();
      // 使得他们取模是一样的
      order.setUserId(userId);
      order.setOrderId(orderId*10+userId%10);
      orderMapper.insert(order);
    }
  }

  @Test
  public void test5() {
    for (int i = 0; i < 10; i++) {
      User user = new User();
      user.setUsername("zbb"+i);
      userMapper.insetUser(user);
    }
  }

  @Test
  public void test3() {
    ProductType productType = new ProductType();
    productType.setTypeId(1L);
    productType.setTypeName("电子产品");
    productTypeMapper.insert(productType);
  }

  @Test
  public void test4() {
    List<ProductTypeVo> productTypeVos = productBaseMapper.listType();
    System.out.println(productTypeVos);
  }

  @Test
  public void test() {
    for (int i = 0; i < 10; i++) {
      ProductBase productBase = ProductBase.builder()
          .name("Spring Cloud Alibaba实战课程")
          .price(159L)
          .shopId((long) (new Random().nextInt(100) + 1))
          .build();
      productBaseMapper.insertProductBase(productBase);
      ProductDescription description = new ProductDescription();
      description.setProductId(productBase.getProductId());
      description.setContent("内容");
      description.setShopId(1L);
      productDescriptionMapper.insertProductDescribe(description);
    }
  }
}
