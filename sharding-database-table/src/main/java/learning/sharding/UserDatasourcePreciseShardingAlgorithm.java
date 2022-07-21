package learning.sharding;

import java.util.Collection;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

public class UserDatasourcePreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

  @Override
  public String doSharding(Collection<String> collection,
      PreciseShardingValue<Long> preciseShardingValue) {
    return "user_" + (preciseShardingValue.getValue() % collection.size());
  }
}
