package com.learning.repository;

import com.learning.entity.User;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {

  /**
   * userId让sharding-jdbc生成
   */
  @Insert(value = "INSERT INTO `t_user`(f_username) VALUE(#{username});")
  @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "f_id")
  int insetUser(User user);

  @Select("select * from t_user where f_id>#{userId}")
  List<User> selectByUserIdGt(Long userId);

  @Select("select * from t_user where f_id>=#{userId}")
  List<User> selectByUserIdGe(Long userId);

  @Select("select * from t_user where f_id>=#{from} and f_id<=#{to}")
  List<User> selectByUserIdBetween(Long from,Long to);

  @Select("select * from t_user where f_id=#{userId}")
  User selectByUserId(Long userId);
}
