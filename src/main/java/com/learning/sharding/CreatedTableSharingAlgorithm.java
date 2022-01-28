package com.learning.sharding;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Properties;
import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;

public class CreatedTableSharingAlgorithm implements StandardShardingAlgorithm<Long> {

  @Override
  public String doSharding(Collection<String> availableTargetNames,
      PreciseShardingValue<Long> shardingValue) {
    String logicTableName = shardingValue.getLogicTableName();
    String yearMonth = ZonedDateTime.ofInstant(Instant.ofEpochMilli(shardingValue.getValue()),
        ZoneId.of("GMT+8")).toLocalDateTime().format(
        DateTimeFormatter.ofPattern("yyyyMM"));
    String tableName = logicTableName + "_" + yearMonth;
    if (!availableTargetNames.contains(tableName)) {
      throw new IllegalArgumentException();
    }
    return tableName;
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
