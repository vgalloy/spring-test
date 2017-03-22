package com.vgalloy.springtest.springproperties;

import com.vgalloy.springtest.springproperties.properties.SimpleProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Vincent Galloy on 22/03/17.
 *
 * @author Vincent Galloy
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(classes = GlobalConfig.class)
public class GlobalConfigTest {

    @Autowired
    private SimpleProperties simpleProperties;

    @Test
    public void ok() {
        Assert.assertEquals("test", simpleProperties.getUsername());
    }

    // Without spring boot wrapper properties can not be found in config/application.properties
    @Test
    public void wrong() {
        // GIVEN
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(GlobalConfig.class);

        // WHEN
        SimpleProperties simpleProperties = applicationContext.getBean(SimpleProperties.class);

        // THEN
        Assert.assertNull(simpleProperties.getUsername());
    }
}