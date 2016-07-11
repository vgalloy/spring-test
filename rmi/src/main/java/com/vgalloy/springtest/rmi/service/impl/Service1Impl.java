package com.vgalloy.springtest.rmi.service.impl;

import com.vgalloy.springtest.rmi.service.Service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 11/07/16.
 */
public class Service1Impl extends UnicastRemoteObject implements Service {

    public Service1Impl() throws RemoteException {
    }

    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
