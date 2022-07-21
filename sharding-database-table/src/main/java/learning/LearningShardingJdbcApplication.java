package learning;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.learning.repository")
public class LearningShardingJdbcApplication {

  public static void main(String[] args) {
    SpringApplication.run(LearningShardingJdbcApplication.class, args);
  }
}
