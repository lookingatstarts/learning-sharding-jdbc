package com.learning.sharding;

import java.util.Collection;
import java.util.Properties;
import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;

public class TableSharingAlgorithm implements StandardShardingAlgorithm<Integer> {

  @Override
  public String doSharding(Collection<String> availableTargetNames,
      PreciseShardingValue<Integer> shardingValue) {
    String month = shardingValue.getValue() + "";
    if (month.length() == 1) {
      return "t_order_20220" + month;
    } else {
      return "t_order_2022" + month;
    }
  }

  @Override
  public Collection<String> doSharding(Collection<String> availableTargetNames,
      RangeShardingValue<Integer> shardingValue) {
    return null;
  }

  @Override
  public void init() {

  }

  @Override
  public Properties getProps() {
    return new Properties();
  }

  @Override
  public void setProps(Properties props) {

  }

  @Override
  public String getType() {
    return "CLASS_BASED";
  }
}
