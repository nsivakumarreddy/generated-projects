/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-spring:src/main/java/conversation/PersistenceContextConversationListener.p.vm.java
 */
package com.jaxio.web.conversation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.log4j.Logger;
import org.springframework.orm.jpa.EntityManagerHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * Responsible for creating/binding the entity manager used during the conversation.
 */
public class PersistenceContextConversationListener implements ConversationListener {
    private static final Logger log = Logger.getLogger(PersistenceContextConversationListener.class);

    private EntityManagerFactory entityManagerFactory;

    public PersistenceContextConversationListener(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void conversationCreated(Conversation conversation) {
        if (conversation.getCurrentContext().isPersistenceContext()) {
            EntityManager em = entityManagerFactory.createEntityManager();
            conversation.setEntityManager(em);
            if (log.isDebugEnabled()) {
                log.debug("conversation " + conversation.getId() + ": entity manager created");
            }
        }
    }

    @Override
    public void conversationResuming(Conversation conversation) {
        if (conversation.getCurrentContext().isPersistenceContext()) {
            if (conversation.getEntityManager() == null) {
                EntityManager em = entityManagerFactory.createEntityManager();
                conversation.setEntityManager(em);
                if (log.isDebugEnabled()) {
                    log.debug("conversation " + conversation.getId() + ": entity manager created");
                }
            }

            bind(conversation.getEntityManager());
        }
    }

    @Override
    public void conversationPausing(Conversation conversation) {
        unbind(conversation.getEntityManager());
    }

    @Override
    public void conversationContextPopped(Conversation conversation, ConversationContext<?> contextRemoved) {
        if (!contextRemoved.isPersistenceContext() && conversation.getCurrentContext().isPersistenceContext()) {
            // tricky case: we  bind the entity manager as the callback method (which is executed just after the context is popped) 
            // could rely on it.
            bind(conversation.getEntityManager());
        }
    }

    @Override
    public void conversationEnding(Conversation conversation) {
        EntityManager em = conversation.getEntityManager();
        if (em != null) {
            boolean unbinded = unbind(em);
            em.close();

            if (log.isDebugEnabled()) {
                if (unbinded) {
                    log.debug("conversation " + conversation.getId() + ": entity manager unbinded and closed");
                } else {
                    log.debug("conversation " + conversation.getId() + ": entity manager closed");
                }
            }
        }
    }

    // --------------------------------------------
    // Extended Persistence related
    // (same code as in spring web flow)
    // --------------------------------------------

    private void bind(EntityManager em) {
        TransactionSynchronizationManager.bindResource(entityManagerFactory, new EntityManagerHolder(em));
    }

    private boolean unbind(EntityManager em) {
        if (TransactionSynchronizationManager.hasResource(entityManagerFactory)) {
            TransactionSynchronizationManager.unbindResource(entityManagerFactory);
            return true;
        }
        return false;
    }
}
