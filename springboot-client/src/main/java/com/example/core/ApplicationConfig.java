package com.example.core;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Description </br>
 * @Version Ver 1.0
 * @Author <a href="mailto:wangshuo@ebnew.com">admin</a>
 * @Date 2017/8/28
 */
@Component
public class ApplicationConfig implements ApplicationContextAware{

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static Object getBean(String param) {
        return context.getBean(param);
    }
}
