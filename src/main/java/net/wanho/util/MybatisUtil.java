package net.wanho.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MybatisUtil {
    private static ThreadLocal<SqlSession> threadLocal=new ThreadLocal<>();
    private static SqlSessionFactory sqlSessionFactory;
    static {
        InputStream is = MybatisUtil.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
    }
    public static SqlSession getSqlSession(){
        SqlSession sqlSession = threadLocal.get();
        if(sqlSession==null){
            sqlSession = sqlSessionFactory.openSession();
            threadLocal.set(sqlSession);
        }
        return sqlSession;
    }

    public static void closeAndCommit(){
        SqlSession sqlSession = threadLocal.get();
        if(sqlSession!=null){
            sqlSession.commit();
            sqlSession.close();
            threadLocal.remove();
        }
    }
}
