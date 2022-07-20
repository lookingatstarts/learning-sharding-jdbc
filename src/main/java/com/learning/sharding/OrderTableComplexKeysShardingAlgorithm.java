package com.learning.sharding;

import com.google.common.collect.Range;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

/**
 * 复合分片算法，支持多个分片键
 */
public class OrderTableComplexKeysShardingAlgorithm implements ComplexKeysShardingAlgorithm<Long> {

  public final static String LOGIC_ORDER_ID = "order_id";
  public final static String LOGIC_USER_ID = "user_id";

  /**
   * @param availableTargetNames 可用的数据源或者表
   * @param shardingValue        分片键的值，分为两类 1. columnNameAndRangeValuesMap(范围查询的值)
   *                             2.columnNameAndShardingValuesMap（精确查询的值）
   */
  @Override
  public Collection<String> doSharding(Collection<String> availableTargetNames,
      ComplexKeysShardingValue<Long> shardingValue) {
    //范围查询的分片键值集合:userId/orderId
    Map<String, Range<Long>> shardingRangeMaps = shardingValue.getColumnNameAndRangeValuesMap();
    if (!shardingRangeMaps.isEmpty()) {
      // 进行全路由查询
      return availableTargetNames;
    }
    //精确查询的分片键值集合:userId/orderId
    Map<String, Collection<Long>> shardingMaps = shardingValue.getColumnNameAndShardingValuesMap();
    if (shardingMaps.isEmpty()) {
      return availableTargetNames;
    }
    String logicTableName = shardingValue.getLogicTableName();
    //orderIds：订单编号分片键值的集合
    Collection<Long> orderIds = shardingMaps.getOrDefault(LOGIC_ORDER_ID, Collections.emptyList());
    //userIds：用户id分片键值的集合
    Collection<Long> userIds = shardingMaps.getOrDefault(LOGIC_USER_ID, Collections.emptyList());
    Set<Long> ids = new HashSet<>();
    ids.addAll(orderIds);
    ids.addAll(userIds);
    Set<String> collect = ids.stream().map(
            id -> logicTableName + "_" + id % availableTargetNames.size())
        .collect(Collectors.toSet());
    return collect;
  }
}
