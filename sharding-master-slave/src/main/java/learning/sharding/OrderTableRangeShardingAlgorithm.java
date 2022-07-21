package learning.sharding;

import java.util.Collection;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

/**
 * 精确分表算法
 */
public class OrderTableRangeShardingAlgorithm implements RangeShardingAlgorithm<Long> {

  @Override
  public Collection<String> doSharding(Collection<String> collection,
      RangeShardingValue<Long> rangeShardingValue) {
    return collection;
  }
}
