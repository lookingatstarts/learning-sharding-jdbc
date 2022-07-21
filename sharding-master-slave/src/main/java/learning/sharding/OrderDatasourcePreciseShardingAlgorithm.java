package learning.sharding;

import java.util.Collection;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

public class OrderDatasourcePreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

  @Override
  public String doSharding(Collection<String> collection,
      PreciseShardingValue<Long> preciseShardingValue) {
    String target = "m" + ((preciseShardingValue.getValue() % collection.size()) + 1);
    return target;
  }
}
