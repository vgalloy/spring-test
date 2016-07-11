package com.vgalloy.springtest.rmi;

import com.vgalloy.springtest.rmi.service.Service;
import com.vgalloy.springtest.rmi.service.impl.Service1Impl;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 11/07/16.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        // Registry creation
        Registry registry = LocateRegistry.createRegistry(5649);

        // Bind the service on a name
        Remote service = new Service1Impl();
        registry.rebind("Service", service);

        // Client
        Registry clientRegistry = LocateRegistry.getRegistry(5649);
        Service clientStub = (Service) clientRegistry.lookup("Service");
        System.out.println(clientStub.add(1, 2));

        // JVM can not end before all object have been unexposed
        UnicastRemoteObject.unexportObject(service, false);
    }
}
