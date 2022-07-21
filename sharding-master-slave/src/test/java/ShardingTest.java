import java.util.List;
import learning.MasterSlaveApplication;
import learning.entity.Order;
import learning.repository.OrderMapper;
import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MasterSlaveApplication.class)
public class ShardingTest {

  private final static SnowflakeShardingKeyGenerator generator = new SnowflakeShardingKeyGenerator();
  @Autowired
  private OrderMapper orderMapper;

  @Test
  public void OrderTest7() {
    // 没有分片键，全库路由
    List<Order> selectLimit = orderMapper.selectLimit(1, 2);
    Order order = orderMapper.selectByOrderId(7568258194598789132L);
    List<Order> orderGtList = orderMapper.selectByOrderIdGt(7568258194598789132L);
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
      order.setOrderId(orderId);
      orderMapper.insert(order);
    }
  }
}
