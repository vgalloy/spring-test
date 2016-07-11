package com.vgalloy.springtest.rmi.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 11/07/16.
 */
public interface Service extends Remote {

    int add(int a, int b) throws RemoteException;
}
