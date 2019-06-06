package net.wanho.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Person {
    private Integer id;
    private String name;
    private Integer cid;
    private Card card;
    private List<Address> addresses;
}
