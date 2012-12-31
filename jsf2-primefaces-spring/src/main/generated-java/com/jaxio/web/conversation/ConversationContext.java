/*
 * (c) Copyright 2005-2012 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-spring:src/main/java/conversation/ConversationContext.p.vm.java
 */
package com.jaxio.web.conversation;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.NotImplementedException;

import com.jaxio.domain.Identifiable;
import com.jaxio.util.ResourcesUtil;
import com.jaxio.web.domain.support.SelectableListDataModel;

/**
 * Context holding variables and 'conversation' scoped beans so they can be accessed from the view it supports.
 */
public class ConversationContext<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    // support for 'conversation' scope
    private Map<String, Object> beans = new HashMap<String, Object>();
    private Map<String, Object> vars = new HashMap<String, Object>();

    private String conversationId;
    private ConversationCallBack<T> callBack = new ConversationCallBack<T>();
    private String label;
    private String uri;

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    /**
     * Sets the label displayed in the conversation menu.
     * @param labelKey the property key.
     */
    public void setLabelWithKey(String labelKey) {
        this.label = ResourcesUtil.getInstance().getProperty(labelKey);
    }

    /**
     * Sets the label displayed in the conversation menu.
     * @param label the label.
     */
    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    /**
     * Sets the URI attached to this context. Must be called only once, why? Simply because a context is attached to a single view.
     * The view (i.e. url) must not change during the life of the context. 
     */
    public void setUri(String uri) {
        if (this.uri == null) {
            this.uri = uri;
        } else {
            throw new IllegalStateException("setUri method MUST be called once only");
        }
    }

    /**
     * The uri attached to this context.
     */
    public String getUri() {
        return uri;
    }

    /**
     * Sets the 'sub' variable.
     */
    public void setSub(boolean sub) {
        setVar("sub", sub);
    }

    public boolean isSub() {
        return getVar("sub") != null ? (Boolean) getVar("sub") : false;
    }

    /**
     * Sets the 'readonly' variable.
     */
    public void setReadonly(boolean readonly) {
        setVar("readonly", readonly);
    }

    public boolean isReadOnly() {
        return getVar("readonly") != null ? (Boolean) getVar("readonly") : false;
    }

    public T getEntity() {
        throw new NotImplementedException("sub class should implement it as needed");
    }

    public void setCallBack(ConversationCallBack<T> callBack) {
        this.callBack = callBack;
    }

    public ConversationCallBack<T> getCallBack() {
        return callBack;
    }

    public <E extends Identifiable<?>> void setDataModel(String name, List<E> list) {
        setVar(name, new SelectableListDataModel<E>(list));
    }

    @SuppressWarnings("unchecked")
    public <E extends Identifiable<?>> SelectableListDataModel<E> getDataModel(String name, Class<E> type) {
        return getVar(name, SelectableListDataModel.class);
    }

    public String getMenuUrl() {
        checkUriAndConversationId();
        return uri + "?_cid_=" + conversationId;
    }

    public String outcome() {
        checkUriAndConversationId();
        return uri + "?faces-redirect=true&_cid_=" + conversationId;
    }

    private void checkUriAndConversationId() {
        if (uri == null) {
            throw new IllegalStateException("Developer! uri is null, it must be setbefore calling outcome() or getMenuUrl() methods");
        }

        if (conversationId == null) {
            throw new IllegalStateException("Developer! conversationId is null, it must be set before calling outcome() or getMenuUrl() methods");
        }
    }

    // ----------------------------------
    // Support for conversation scope
    // ----------------------------------

    void addBean(String name, Object bean) {
        beans.put(name, bean);
    }

    Object getBean(String name) {
        return beans.get(name);
    }

    protected void setVar(String name, Object var) {
        vars.put(name, var);
    }

    protected Object getVar(String name) {
        return vars.get(name);
    }

    @SuppressWarnings("unchecked")
    protected <E> E getVar(String name, Class<E> type) {
        return (E) vars.get(name);
    }
}