package learning.sharding;

import java.util.Collection;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

public class UserTableRangeShardingAlgorithm implements RangeShardingAlgorithm<Long> {

  @Override
  public Collection<String> doSharding(Collection<String> collection,
      RangeShardingValue<Long> rangeShardingValue) {
    return collection;
  }
}
