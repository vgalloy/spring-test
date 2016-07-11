package com.vgalloy.springtest.rmi.service.impl;

import com.vgalloy.springtest.rmi.service.Service;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 11/07/16.
 */
public class Service2Impl implements Service {

    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
