package cn.hhm.worklogcollect.aop;

import java.lang.annotation.*;

/**
 * 定义Log收集注解
 * @author Ming
 * @create 2018-04-04 8:42
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ITest {
    String desc() default "";//描述业务操作
}
