package com.email.common.bind.annotation;

import java.lang.annotation.*;

/**
 * Created by HX-119 on 2014/5/6.
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface QueryCondition {

    String prifix() default "Q";
    String delimiter() default "_";

}
