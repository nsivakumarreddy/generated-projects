/*
 * (c) Copyright 2005-2012 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-spring:src/main/java/domain/Context.e.vm.java
 */
package com.jaxio.web.domain;

import com.jaxio.domain.Legacy;
import com.jaxio.web.conversation.ConversationContext;

/**
 * The context for {@link Account} edit/select views.
 */
public class LegacyContext extends ConversationContext<Legacy> {
    private static final long serialVersionUID = 1L;
    public final static String editUri = "/domain/legacyEdit.faces";
    public final static String selectUri = "/domain/legacySelect.faces";

    public LegacyContext() {
    }

    public LegacyContext(Legacy legacy) {
        setVar("legacy", legacy);
    }

    /**
     * Developer friendly method to get the entity. Use it from Java code for better clarity.
     */
    public Legacy getLegacy() {
        return getEntity();
    }

    @Override
    public Legacy getEntity() {
        return getVar("legacy", Legacy.class);
    }
}