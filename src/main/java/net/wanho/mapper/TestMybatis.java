package net.wanho.mapper;

import net.wanho.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class TestMybatis {
    public static void main(String[] args) {
        InputStream is = TestMybatis.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user=new User(null,"hahaha","hahaha","1","3");
        sqlSession.insert("net.wanho.mapper.UserMapper.addUser",user);
        sqlSession.commit();
        sqlSession.close();
    }
}
