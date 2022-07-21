package learning.sharding;

import java.util.List;
import java.util.Properties;
import org.apache.shardingsphere.spi.masterslave.MasterSlaveLoadBalanceAlgorithm;

/**
 * 自定义负责均衡算法: 强制走主库
 */
public class OnlyMasterLoadBalanceAlgorithm implements MasterSlaveLoadBalanceAlgorithm {

  @Override
  public String getDataSource(String name, String masterDataSourceName,
      List<String> slaveDataSourceNames) {
    return masterDataSourceName;
  }

  @Override
  public String getType() {
    return "only_master";
  }

  @Override
  public Properties getProperties() {
    return null;
  }

  @Override
  public void setProperties(Properties properties) {

  }
}
