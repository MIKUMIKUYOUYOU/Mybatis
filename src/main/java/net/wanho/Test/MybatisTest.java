package net.wanho.Test;

import net.wanho.mapper.TestMybatis;
import net.wanho.mapper.UserMapper;
import net.wanho.pojo.User;
import net.wanho.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MybatisTest {
//    private SqlSession sqlSession;
//    @Before
//    public void getConn() {
//        InputStream is = TestMybatis.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
//        sqlSession = sqlSessionFactory.openSession();
//    }
    @Test
    public void add(){
        User user=new User(null,"hahaha","hahaha","1","3");
        SqlSession sqlSession= MybatisUtil.getSqlSession();
        SqlSession sqlSession2= MybatisUtil.getSqlSession();
        System.out.println(sqlSession==sqlSession2);
        sqlSession.insert("net.wanho.mapper.UserMapper.addUser",user);
        MybatisUtil.closeAndCommit();
    }



    @Test
    public void del(){
        SqlSession sqlSession= MybatisUtil.getSqlSession();
        sqlSession.delete("net.wanho.mapper.UserMapper.delUser",153);
        MybatisUtil.closeAndCommit();
    }
    @Test
    public void selectAll(){
        SqlSession sqlSession= MybatisUtil.getSqlSession();
        List<User> users = sqlSession.selectList("net.wanho.mapper.UserMapper.selectAll");
        System.out.println(users);
        MybatisUtil.closeAndCommit();
    }

    @Test
    public void selectOne(){
        SqlSession sqlSession= MybatisUtil.getSqlSession();
        User u = sqlSession.selectOne("net.wanho.mapper.UserMapper.selectUserById", 1);
        System.out.println(u);
        MybatisUtil.closeAndCommit();
    }

    @Test
    public void add2(){
        User user=new User(null,"hahaha","hahaha","1","3");
        SqlSession sqlSession= MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.addUser(user);
        MybatisUtil.closeAndCommit();
    }
    @Test
    public void updateUser(){
        User user=new User(null,"hahaha","hahaha","1","3");
        SqlSession sqlSession= MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.updateUser("www","www","1","3",157);
        MybatisUtil.closeAndCommit();
    }

    @Test
    public void updateUser2(){
        User user=new User(null,"哈哈哈","hahaha","1","3");
        SqlSession sqlSession= MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.updateUser2(user,157);
        MybatisUtil.closeAndCommit();
    }
    @Test
    public void addReturnPk(){
        User user=new User(null,"hahaha","hahaha","1","3");
        SqlSession sqlSession= MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        if(userMapper.addUser2(user)>0){
            System.out.println("插入成功");
        }
        System.out.println("PK为"+user.getId());
        MybatisUtil.closeAndCommit();
    }

    @Test
    public void del2(){
        SqlSession sqlSession= MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.delUser(154);
        MybatisUtil.closeAndCommit();
    }

    @Test
    public void selectAll2(){
        SqlSession sqlSession= MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.selectAll());
        MybatisUtil.closeAndCommit();
    }

    @Test
    public void selectAll3(){
        SqlSession sqlSession= MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.selectAll2());
        MybatisUtil.closeAndCommit();
    }
    @Test
    public void selectOne2(){
        SqlSession sqlSession= MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User u = userMapper.selectUserById(1);
        System.out.println(u);
        MybatisUtil.closeAndCommit();
    }

    @Test
    public void like(){
        SqlSession sqlSession= MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectUserByName("w");
        System.out.println(users);
        MybatisUtil.closeAndCommit();
    }

    @Test
    public void like2(){
        SqlSession sqlSession= MybatisUtil.getSqlSession();
        User user=new User();
        user.setUsername("h");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectUserByName2(user);
        System.out.println(users);
        MybatisUtil.closeAndCommit();
    }
}
