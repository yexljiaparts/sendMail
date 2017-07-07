package com.email.common.bind.resolver;

import com.email.common.bind.annotation.DataTableModel;
import com.email.common.query.Condition;
import org.springframework.core.MethodParameter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HX-119 on 2014/5/6.
 */
public class DataTableModelArgumentResolver implements HandlerMethodArgumentResolver {


   // @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterAnnotation(DataTableModel.class) != null && Pageable.class.equals(methodParameter.getParameterType());
    }

  //  @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        DataTableModel dataTableModel = methodParameter.getParameterAnnotation(DataTableModel.class);
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);

        // 把reqeust的body读取到StringBuilder
        Map<String,String[]> paramMap = request.getParameterMap();
        List<Condition> conditionList = new ArrayList<Condition>();

        Map<Integer,String> columnMap = new HashMap<Integer,String>();
        int sortIndex = 0;
        String sortDir = "asc";
        int iDisplayStart = 0;
        int iDisplayLength = 20;

        for(Map.Entry<String,String[]> entry : paramMap.entrySet()){
            String key = entry.getKey();
            if("iDisplayStart".equals(key)){
                iDisplayStart=Integer.parseInt(entry.getValue()[0]);
            }else if("iDisplayLength".equals(key)){
                iDisplayLength=Integer.parseInt(entry.getValue()[0]);
            }else if(key.startsWith("iSortCol_")){
                sortIndex=Integer.valueOf(entry.getValue()[0]);
            }else if(key.startsWith("sSortDir_")){
                sortDir=entry.getValue()[0];
            }else if(key.startsWith("mDataProp_")){
                columnMap.put(Integer.valueOf(key.substring("mDataProp_".length())),entry.getValue()[0]);
            }
        }
        String sort_column="id";
        if(columnMap.size()!=0){
            sort_column=columnMap.get(sortIndex);
        }
        return new PageRequest(iDisplayStart/iDisplayLength,iDisplayLength,new Sort(Sort.Direction.fromString(sortDir),sort_column));
    }
}
