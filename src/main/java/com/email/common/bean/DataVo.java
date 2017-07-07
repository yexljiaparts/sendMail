package com.email.common.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/2/18.
 */
public class DataVo<T> {
    private int draw; // Client request times
    private long iTotalRecords; // Total records number without conditions
    private long iTotalDisplayRecords; // Total records number with conditions
    private List<T> aaData;

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public long getiTotalRecords() {
        return iTotalRecords;
    }

    public void setiTotalRecords(long iTotalRecords) {
        this.iTotalRecords = iTotalRecords;
    }

    public long getiTotalDisplayRecords() {
        return iTotalDisplayRecords;
    }

    public void setiTotalDisplayRecords(long iTotalDisplayRecords) {
        this.iTotalDisplayRecords = iTotalDisplayRecords;
    }

    public List<T> getAaData() {
        return aaData;
    }

    public void setAaData(List<T> aaData) {
        this.aaData = aaData;
    }
}
