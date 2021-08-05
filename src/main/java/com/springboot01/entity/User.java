package com.springboot01.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Data
@Entity
@Table(name = "springboot01")
//@Setter
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
public class User {

    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    private String id;

    @Column(name = "userName",length = 10)
    private String name;

    @Column(name = "age",length = 3)
    private int age;

    @Column(name = "passWord",length = 20)
    private String passWord;

    public User(String name, int age,String passWord) {
        this.name = name;
        this.age = age;
        this.passWord = passWord;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
