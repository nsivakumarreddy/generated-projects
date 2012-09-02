/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-primefaces-sd:src/main/java/flow/SimpleExceptionHandler.p.vm.java
 */
package com.jaxio.demo.web.flow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.webflow.engine.FlowExecutionExceptionHandler;
import org.springframework.webflow.engine.RequestControlContext;
import org.springframework.webflow.execution.FlowExecutionException;

import com.jaxio.demo.util.ResourcesUtil;
import com.jaxio.demo.web.util.MessageUtil;

@Service
public class SimpleExceptionHandler implements FlowExecutionExceptionHandler {

    @Autowired
    private MessageUtil messageUtil;

    @Autowired
    private ResourcesUtil resourcesUtil;

    @Override
    public void handle(final FlowExecutionException exception, final RequestControlContext context) {
        // no op!
    }

    @Override
    public boolean canHandle(final FlowExecutionException e) {
        // prepare error message
        Throwable t = e.getCause();

        if (isCausedBy(t, DataIntegrityViolationException.class)) {
            messageUtil.error("error_unique_constraint_violation");
            return false;
        }

        if (isCausedBy(t, OptimisticLockingFailureException.class)) {
            messageUtil.error("error_concurrent_modification");
            return false;
        }

        String msg = null;
        if (t != null) {
            msg = t.getMessage();
        } else {
            msg = e.getMessage();
        }

        messageUtil.error("status_exception_ko", msg);

        // Some bug or weird behavior in webflow's way to handle error during ajax request force us to
        // handle the error elsewhere (that's why we return false).
        // Webflow will bubble up the exception and we will catch it and handle it properly in ExceptionFilter.
        return false;
    }

    private boolean isCausedBy(Throwable e, Class<?> cause) {
        Throwable current = e;
        while (current != null) {
            if (cause.isAssignableFrom(current.getClass())) {
                return true;
            }
            current = current.getCause();
        }
        return false;
    }
}