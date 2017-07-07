package com.email.entity;

import javax.persistence.*;
import java.awt.print.Book;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/2/22.
 */
@Entity
@Table(name = "e_department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer parentId;

/*    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)/*///*级联保存、更新、删除、刷新;延迟加载*/
/*    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="e_employees_departmentID")//在Employees表增加一个外键列来实现一对多的单向关联
    private Set<Employees> employees = new HashSet<Employees>();*/


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

/*    public Set<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employees> employees) {
        this.employees = employees;
    }*/
}
