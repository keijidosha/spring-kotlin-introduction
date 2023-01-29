package com.example.demo.springiocaop.aspect

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.AfterThrowing
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Aspect
@Component
class LoginAspect {
    companion object {
        private val log = LoggerFactory.getLogger(LoginAspect::class.java)
    }

    @Before("execution(String com.example.demo.springiocaop.controller.HomeController.showList(..))")
    fun startLog(jp: JoinPoint) {
        log.info("{}: Before処理", jp.signature)
    }

    @After("execution(* com.example.demo.springiocaop.controller.HomeController.*(..))")
    fun endLog(jp: JoinPoint) {
        log.info("{}: After処理", jp.signature)
    }

    @Around("execution(* com.example.demo..*(..))")
    fun startAndEndLog(pjp: ProceedingJoinPoint): Any? {
        log.info("{} Around前処理", pjp.signature)
        val result = pjp.proceed()
        log.info("{} Around後処理", pjp.signature)

        return result
    }

    @AfterReturning(
        pointcut = "within(com.example.demo.springiocaop.controller.*Controller)",
        returning = "result"
    )
    fun afterReturning(jp: JoinPoint, result: Any) {
        log.info("{}: return結果 = {}", jp.signature, result)
    }

    @AfterThrowing(
        pointcut = "bean(homeController)",
        throwing = "e"
    )
    fun afterThrowing(jp: JoinPoint, e: Throwable) {
        log.error("{}: 処理中に例外が発生しました: {}", jp.signature, e.message)
    }
}