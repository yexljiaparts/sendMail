package com.email.common.query;

/**
 * Created by HX-119 on 2014/5/6.
 */
public class ConditionUtils {

    public static String toSql(Iterable<Condition> conditions){
        StringBuilder sql = new StringBuilder();
        for(Condition condition : conditions){
            if(condition.isValid()){
                sql.append(" and ").append(condition.getMatch().generateSql(condition.getFieldName(),condition.getValue()));
            }
        }
        return sql.toString();
    }

}
