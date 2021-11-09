/**
 * Copyright (c) 2018  All rights reserved.
 *
 * https://www.hbgj.io
 *
 * 版权所有，侵权必究！
 */

package io.hbgj.datasource.annotation;

import java.lang.annotation.*;

/**
 * 多数据源注解
 *
 * @author Mark sunlightcs@gmail.com
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DataSource {
    String value() default "";
}
