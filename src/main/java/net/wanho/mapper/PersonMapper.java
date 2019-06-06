package net.wanho.mapper;

import net.wanho.pojo.Address;
import net.wanho.pojo.Card;
import net.wanho.pojo.Person;

import java.util.List;

public interface PersonMapper {
    List<Person> queryPersons();
    List<Person> queryPersonsLazyLoading();
    Card selectCardById(Integer cid);
    List<Address> selectAddressByPid(Integer id);
}
