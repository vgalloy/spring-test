package com.vgalloy.springtest.initialization.failingcontext;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Vincent Galloy on 22/03/17.
 *
 * @author Vincent Galloy
 */
public class ComponentScanTest {

    @Configuration
    @ComponentScan("com.vgalloy.springtest.initialization")
    static class ScanConfig {

    }

    @Configuration
    static class CorrectBeanConfig {

        @Bean
        public Bean2 bean2() {
            return new Bean2();
        }

        @Bean
        public Bean1 bean1() {
            return new Bean1();
        }
    }

    @Configuration
    static class WrongBeanConfig {

        @Bean
        public Bean1 bean1() {
            return new Bean1();
        }

        @Bean
        public Bean2 bean2() {
            return new Bean2();
        }
    }

    /**
     * Spring conservant un cache sur ses configurations, il n'est pas possible d'activer les 3 tests en même temps
     */
    @Test(expected = Exception.class)
    public void testComponentScan() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanTest.ScanConfig.class);
    }

//    @Test
//    public void testCorrectBeanConfiguration() {
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanTest.CorrectBeanConfig.class);
//    }
//
//    @Test(expected = Exception.class)
//    public void testWrongBeanConfiguration() {
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanTest.WrongBeanConfig.class);
//    }
}