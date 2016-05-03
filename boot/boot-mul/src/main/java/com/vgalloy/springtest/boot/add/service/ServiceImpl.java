package com.vgalloy.springtest.boot.add.service;

import com.vgalloy.springtest.boot.api.service.Service;
/**
 * Created by Vincent Galloy on 03/05/16.
 */
public class ServiceImpl implements Service {

    @Override
    public String getName() {
        return "mul";
    }

    @Override
    public int apply(int a, int b) {
        return a * b;
    }
}
