package net.wanho.Test;

import net.wanho.mapper.PersonMapper;
import net.wanho.pojo.Person;
import net.wanho.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MybatisTest2 {
    @Test
    public void select(){
        SqlSession sqlSession= MybatisUtil.getSqlSession();
        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
        System.out.println(personMapper.queryPersons());
    }

    @Test
    public void select2(){
        SqlSession sqlSession= MybatisUtil.getSqlSession();
        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
        List<Person> personList = personMapper.queryPersonsLayzLoading();
        System.out.println(personList);

    }
}
