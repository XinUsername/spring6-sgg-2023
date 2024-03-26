package com.cjx.core.linster;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.time.Duration;


/**
 * SpringBoot应用生命周期监听：
 * Listener先从 META-INF/spring.factories 读到
 * 1、引导：利用 BootstrapContext 引导整个项目启动
 *      starting：               应用开始，SpringApplication的run方法一调用，只要有了 BootstrapContext 就执行
 *      environmentPrepared:    环境准备好（把启动参数等绑定到环境变量中），但是ioc容器还没有创建；【调一次】
 * 2、启动：
 *      contextPrepared：        ioc容器创建并准备好，但是sources（主配置类）没加载。并关闭引导上下文；组件没创建【调一次】
 *      contextLoaded：          ioc容器加载。主配置类加载进去了。但是ioc容器还没刷新（bean没创建）。
 *      ======截止以前，ioc容器里面还没有造bean======
 *      started：                ioc容器刷新了（所有bean造好了），但是runner没调用
 *      ready：                  ioc容器刷新了（所有bean造好了），所有runner调用完了
 * 3、运行：
 * */
public class MyAppListener implements SpringApplicationRunListener {
    @Override
    public void starting(ConfigurableBootstrapContext bootstrapContext) {
        System.out.println("======starting======正在启动======");
    }

    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
        System.out.println("======environmentPrepared======环境准备完成======");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("======contextPrepared======ioc容器准备完成======");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("======contextLoaded======ioc容器加载完成======");
    }

    @Override
    public void started(ConfigurableApplicationContext context, Duration timeTaken) {
        System.out.println("======started======启动完成======");
    }

    @Override
    public void ready(ConfigurableApplicationContext context, Duration timeTaken) {
        System.out.println("======ready======准备就绪======");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("======failed======启动失败======");
    }
}
