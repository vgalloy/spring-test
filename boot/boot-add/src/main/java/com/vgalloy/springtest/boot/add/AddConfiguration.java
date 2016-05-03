package com.vgalloy.springtest.boot.add;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vgalloy.springtest.boot.add.service.ServiceImpl;
import com.vgalloy.springtest.boot.api.service.Service;

/**
 * Created by Vincent Galloy on 02/05/16.
 */
@Configuration
@ConditionalOnMissingBean(Service.class)
public class AddConfiguration {

    @Bean
    public Service service() {
        return new ServiceImpl();
    }
}
