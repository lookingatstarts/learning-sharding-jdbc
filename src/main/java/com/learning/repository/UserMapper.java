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
  @Insert(value = "INSERT INTO `user`(name) VALUE(#{name});")
  @Options(useGeneratedKeys = true, keyProperty = "userId", keyColumn = "user_id")
  int insetUser(User user);

  @Select("select * from user where user_id>#{userId}")
  List<User> selectByUserIdGt(Long userId);

  @Select("select * from user where user_id=#{userId}")
  User selectByUserId(Long userId);
}
