package com.vgalloy.springtest.initialization.context;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 01/02/17.
 */
@Service
@Lazy
public class SimpleComponent {

    public SimpleComponent() {
        System.out.println("Constructor::SimpleComponent");
    }
}
