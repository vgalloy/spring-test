package com.vgalloy.springtest.rmi.service;

import com.vgalloy.springtest.rmi.service.impl.Service1Impl;
import com.vgalloy.springtest.rmi.service.impl.Service2Impl;
import org.junit.Test;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import static org.junit.Assert.assertEquals;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 11/07/16.
 */
public class ServiceTest {

    @Test
    public void testOkForService1() throws Exception {
        // GIVEN
        Registry registry = LocateRegistry.createRegistry(5650);
        registry.bind("Service", new Service1Impl());

        // WHEN
        Registry clientRegistry = LocateRegistry.getRegistry(5650);
        Service clientStub = (Service) clientRegistry.lookup("Service");

        // THEN
        assertEquals(3, clientStub.add(1, 2));
    }

    @Test
    public void testOkForService2() throws Exception {
        // GIVEN
        Registry registry = LocateRegistry.createRegistry(5651);
        Remote stub = UnicastRemoteObject.exportObject(new Service2Impl(), 5651);
        registry.bind("Service", stub);

        // WHEN
        Registry clientRegistry = LocateRegistry.getRegistry(5651);
        Service clientStub = (Service) clientRegistry.lookup("Service");

        // THEN
        assertEquals(3, clientStub.add(1, 2));
    }

    @Test(expected = AlreadyBoundException.class)
    public void testDoubleBindError() throws Exception {
        // GIVEN
        Registry registry = LocateRegistry.createRegistry(5652);
        registry.bind("Service", new Service1Impl());

        // WHEN
        registry.bind("Service", new Service1Impl());
    }

    @Test
    public void testOkDoubleReBind() throws Exception {
        // GIVEN
        Registry registry = LocateRegistry.createRegistry(5653);
        registry.bind("Service", new Service1Impl());

        // WHEN
        registry.rebind("Service", new Service1Impl());
        Registry clientRegistry = LocateRegistry.getRegistry(5653);
        Service clientStub = (Service) clientRegistry.lookup("Service");

        // THEN
        assertEquals(3, clientStub.add(1, 2));
    }

    @Test(expected = NotBoundException.class)
    public void testUnbindError() throws Exception {
        // GIVEN
        Registry registry = LocateRegistry.createRegistry(5654);
        registry.bind("Service", new Service1Impl());
        registry.unbind("Service");

        // WHEN
        Registry clientRegistry = LocateRegistry.getRegistry(5654);
        Service clientStub = (Service) clientRegistry.lookup("Service");
    }
}