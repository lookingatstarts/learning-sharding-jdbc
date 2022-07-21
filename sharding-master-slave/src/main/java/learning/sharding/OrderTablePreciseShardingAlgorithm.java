package learning.sharding;

import java.util.Collection;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

/**
 * 精确分表算法
 */
public class OrderTablePreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

  /**
   * @param collection           可用库或表
   * @param preciseShardingValue 分片键
   * @return
   */
  @Override
  public String doSharding(Collection<String> collection,
      PreciseShardingValue<Long> preciseShardingValue) {
    return preciseShardingValue.getLogicTableName()+"_"+ (preciseShardingValue.getValue() % collection.size());
  }
}
