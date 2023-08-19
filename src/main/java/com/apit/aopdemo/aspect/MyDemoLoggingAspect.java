package com.apit.aopdemo.aspect;

import com.apit.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)

public class MyDemoLoggingAspect {
    @AfterThrowing(
            pointcut = "execution(* com.apit.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountAdvise( JoinPoint theJoinPoint, Throwable theExc){
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=========> Executing @AfterReturning on method" + method);

    }


    @AfterReturning(
            pointcut = "execution(* com.apit.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result){

        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=========> Executing @AfterReturning on method" + method);
        System.out.println("\n=========> result is: " + result );

        if(!result.isEmpty()){
            Account tempAccount = result.get(0);
            tempAccount.setLevel("Daffy Duck");
        }

    }

    @Before("com.apit.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
        System.out.println("\n======> Executing @Before advice in method");
        // display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        // display the method arguments

        // get args
        Object[] args = theJoinPoint.getArgs();

        // loop

        for(Object tempArg : args){
            System.out.println(tempArg);
            if(tempArg instanceof Account){
                Account theAccount = (Account) tempArg;
                System.out.println("account name :" + theAccount.getName());
                System.out.println("account level: " + theAccount.getLevel());

            }
        }

    }



}
