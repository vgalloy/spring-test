package com.vgalloy.springtest.jdkproxy.service.impl;

import com.vgalloy.springtest.jdkproxy.service.MyService;

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
