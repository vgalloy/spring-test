package com.vgalloy.springtest.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 30/01/17.
 */
@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
public class Server {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(Server.class)
                .properties("server.port=8081")
                .run(args);
    }
}
