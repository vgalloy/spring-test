package com.vgalloy.springtest.jdkproxy;

import java.lang.reflect.Proxy;

import com.vgalloy.springtest.jdkproxy.proxy.LogExecutionTimeProxy;
import com.vgalloy.springtest.jdkproxy.service.MyService;
import com.vgalloy.springtest.jdkproxy.service.impl.MyServiceImpl;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 19/02/16.
 */
public class Main {

    public static void main(String[] args) {
        MyService myService = new MyServiceImpl();

        MyService myServiceProxy = (MyService) Proxy.newProxyInstance(
                Main.class.getClassLoader(),
                myService.getClass().getInterfaces(),
                (proxy, method, arguments) -> {

                    // Start time
                    long startTime = System.nanoTime();

                    // Invoke the method on the target instance
                    Object result = method.invoke(myService, arguments);

                    // Print the execution time
                    System.out.println("Executed method " + method.getName()
                            + " in " + (System.nanoTime() - startTime)
                            + " nanoseconds.");

                    // Return the result to the caller
                    return result;

                });
        myServiceProxy.add(1, 2);

        MyService proxy = (MyService)
                Proxy.newProxyInstance(MyService.class.getClassLoader(),
                        myService.getClass().getInterfaces(),
                        new LogExecutionTimeProxy(myService));

        proxy.add(1, 2);
    }
}
