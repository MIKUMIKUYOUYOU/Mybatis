package net.wanho.mapper;

import net.wanho.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    void addUser(User user);
    void delUser(Integer id);
    List<User> selectAll();
    User selectUserById(Integer id);
    List<User> selectUserByName(String name);
    List<User> selectUserByName2(User user);
    Integer addUser2(User user);
    void updateUser(@Param("username") String username,@Param("password") String password,@Param("sex") String sex,@Param("position") String position,@Param("id") Integer id);
    void updateUser2(@Param("user") User user,@Param("id") Integer id);
    @Select("SELECT * FROM user")
    List<User> selectAll2();
    List<User> selectUser(User user);
    List<User> selectUserBychoose(User user);
    List<User> selectUserByWhere(User user);
    List<User> selectUserByTrim(User user);
    Integer updateUserSet(User user);
}
