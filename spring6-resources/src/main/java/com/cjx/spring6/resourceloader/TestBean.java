package com.cjx.spring6.resourceloader;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

public class TestBean implements ResourceLoaderAware {

    private ResourceLoader resourceLoader;

    //实现ResourceLoaderAware接口必须实现的方法
    //如果把该Beanbushu在Spring容器中，改方法将会有Spring容器负责调用
    //Spring容器调用该方法时，Spring会将自身作为参数传递给该方法
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
