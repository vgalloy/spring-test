package com.vgalloy.springtest.initialization;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vgalloy.springtest.initialization.bean.SimpleBean;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 19/02/16.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/spring-context.xml");
        SimpleBean simpleBean = applicationContext.getBean(SimpleBean.class);
        System.out.println(simpleBean);
	    /*
	    1. Constructor
	    2. setValue (with Autowired)
	    3. setValue (with method)
	    4. postProcessBeforeInitialization
	    5. @PostConstruct
	    6. afterPropertiesSet
	    7. init method
        8. postProcessAfterInitialization
	     */
    }
}
