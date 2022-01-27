package com.learning.sharding;

import java.util.Collection;
import java.util.Properties;
import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;

public class TableSharingAlgorithm implements StandardShardingAlgorithm<Long> {

  @Override
  public String doSharding(Collection<String> availableTargetNames,
      PreciseShardingValue<Long> shardingValue) {
    Long value = shardingValue.getValue();
    return null;
  }

  @Override
  public Collection<String> doSharding(Collection<String> availableTargetNames,
      RangeShardingValue<Long> shardingValue) {
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
