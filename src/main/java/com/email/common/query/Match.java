package com.email.common.query;

import org.apache.commons.lang.math.NumberUtils;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by HX-119 on 2014/5/6.
 */
public enum Match {

    EQ("="),LT("<"),GT(">"),LE("<="),GE(">="),IN("in"),LIKE("like");
    private String sqlCondition;
    Match(String sqlCondition) {
        this.sqlCondition = sqlCondition;
    }

    public String generateSql(String fieldName,Object sqlValue) {
        if(sqlValue instanceof Iterable){
            return generateInSql(fieldName, (Iterable) sqlValue);
        }else if(sqlValue.getClass().isArray()){
            return generateInArraySql(fieldName, (Object[]) sqlValue);
        }
        if(this==LIKE)return generateLikeSql(fieldName, sqlValue);
        if(!NumberUtils.isNumber(sqlValue.toString())){
            return fieldName+sqlCondition+"'"+sqlValue+"' ";
        }
        return " "+fieldName+sqlCondition+sqlValue+" ";
    }

    private String generateLikeSql(String fieldName, Object sqlValue) {
        return " "+fieldName+" "+sqlCondition+" '%"+sqlValue+"%'"+" ";
    }

    private String generateInSql(String fieldName,Iterable iterable) {
        if(this!=IN) throw new UnsupportedOperationException();
        StringBuilder sql = new StringBuilder(fieldName).append(" in (");
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()){
            sql.append(iterator.next().toString());
            if(iterator.hasNext()){
                sql.append(",");
            }
        }
        sql.append(") ");
        return sql.toString();
    }

    private String generateInArraySql(String fieldName,Object [] objects) {
        if(this!=IN) throw new UnsupportedOperationException();
        StringBuilder sql = new StringBuilder(fieldName).append(" in (");
        String arrayString = Arrays.toString(objects);
        sql.append(arrayString.substring(1, arrayString.length() - 1)).append(")");
        return sql.toString();
    }
}
