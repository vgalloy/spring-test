package com.vgalloy.spring.jdkproxy.service.impl;

import com.vgalloy.spring.jdkproxy.service.MyService;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 19/02/16.
 */
public class MyServiceImpl implements MyService {

    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
