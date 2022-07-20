import com.learning.LearningShardingJdbcApplication;
import com.learning.entity.Order;
import com.learning.entity.Product;
import com.learning.entity.ProductType;
import com.learning.entity.User;
import com.learning.repository.OrderMapper;
import com.learning.repository.ProductMapper;
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
  private ProductMapper productMapper;
  @Autowired
  private ProductTypeMapper productTypeMapper;
  @Autowired
  private UserMapper userMapper;
  @Autowired
  private OrderMapper orderMapper;

  @Test
  public void test6() {
    for (int i = 0; i < 10; i++) {
      Order order = new Order();
      Long userId = (Long) generator.generateKey();
      order.setUserId(userId);
      //唯一ID+userId后1位
      order.setOrderId(((Long) generator.generateKey()) * 3 + (userId % 3));
      orderMapper.insert(order);
    }
  }

  @Test
  public void test5() {
    User user = new User();
    user.setName("zbb");
    userMapper.insetUser(user);
    System.out.println();
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
    List<ProductTypeVo> productTypeVos = productMapper.listType();
    System.out.println(productTypeVos);
  }

  @Test
  public void test() {
    for (int i = 0; i < 10; i++) {
      Product product = Product.builder()
          .name("Spring Cloud Alibaba实战课程")
          .price(159L)
          .originAddress("码猿技术专栏")
          .shopId((long) (new Random().nextInt(100) + 1))
          .build();
      productMapper.insertProductBase(product);
      productMapper.insertProductDescribe(product.getProductId(), "内容", product.getShopId());
    }
  }
}
