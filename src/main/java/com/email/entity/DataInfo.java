package com.email.entity;

import com.google.gson.annotations.SerializedName;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/2/18.
 */
@Entity
@Table(name = "e_data_info")
public class DataInfo implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SerializedName("id")
    private Integer id;
 /*   @OneToOne
    @JoinColumn(name="jobNum", referencedColumnName="Em_id")
    private Employees employees;*/
    @SerializedName("money")
    private Integer money;
    @SerializedName("crrateTime")
    private Integer crrateTime;
    @SerializedName("sendTime")
    private String sendTime;
    @SerializedName("sort")
    private Integer sort;
    @SerializedName("status")
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

/*    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }*/

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getCrrateTime() {
        return crrateTime;
    }

    public void setCrrateTime(Integer crrateTime) {
        this.crrateTime = crrateTime;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
