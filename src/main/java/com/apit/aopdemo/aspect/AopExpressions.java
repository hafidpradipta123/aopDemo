package com.apit.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* com.apit.aopdemo.dao.*.*(..))")
    public void forDaoPackage(){}


    //pointcut for getter
    @Pointcut("execution(* com.apit.aopdemo.dao.*.get*(..))")
    public void getter(){}

    // pointcut for setter
    @Pointcut("execution(* com.apit.aopdemo.dao.*.set*(..))")
    public void setter(){}

    // pointcut for exclude

    @Pointcut("forDaoPackage() && !(getter() || setter()) ")
    public void forDaoPackageNoGetterSetter(){}

}
