package com.email.common.query;

import org.apache.commons.lang.StringUtils;

/**
 * Created by HX-119 on 2014/5/5.
 */
public class Condition {

    private String fieldName;
    private Object value;
    private Match match;

    public Condition() {
    }

    public Condition(String fieldName, Object value, Match match) {
        this.fieldName = fieldName;
        this.value = value;
        this.match = match;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public boolean isValid(){
        return !StringUtils.isEmpty(fieldName) && null!=value && null!=match;
    }

}
