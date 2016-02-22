package com.vgalloy.spring.initialization;

import com.vgalloy.spring.initialization.bean.SimpleBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 19/02/16.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/spring-context.xml");
        SimpleBean simpleBean = applicationContext.getBean(SimpleBean.class);
        System.out.println(simpleBean.getValue());
    }
}
