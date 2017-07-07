package com.email.common.bind.resolver;

import com.email.common.bind.annotation.QueryCondition;
import com.email.common.query.Condition;
import com.email.common.query.Match;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by HX-119 on 2014/5/6.
 */
public class QueryConditionArgumentResolver implements HandlerMethodArgumentResolver {


    //@Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterAnnotation(QueryCondition.class) != null;
    }

    //@Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        QueryCondition queryCondition = methodParameter.getParameterAnnotation(QueryCondition.class);
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);

        // 把reqeust的body读取到StringBuilder
        Map<String,String[]> paramMap = request.getParameterMap();
        List<Condition> conditionList = new ArrayList<Condition>();
        for(Map.Entry<String,String[]> entry : paramMap.entrySet()){
            String key = entry.getKey();
            if(!key.startsWith(queryCondition.prifix()+queryCondition.delimiter()))continue;
            String [] values = entry.getValue();
            String [] conditionNameArray = key.split(queryCondition.delimiter());
            if(values.length==0){
                //do nothing
            }else if(values.length==1){
                if(!StringUtils.isEmpty(values[0]))
                    conditionList.add(new Condition(conditionNameArray[1],values[0], Match.valueOf(conditionNameArray[2].toUpperCase())));
            }else {
                conditionList.add(new Condition(conditionNameArray[1],values[0], Match.valueOf(conditionNameArray[2].toUpperCase())));
            }
        }
        return conditionList;
//        return new ConditionWrapper(conditionList);
    }
}
