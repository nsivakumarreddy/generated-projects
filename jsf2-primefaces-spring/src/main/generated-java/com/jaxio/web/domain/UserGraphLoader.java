/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-jsf2-spring-conversation:src/main/java/domain/GraphLoader.e.vm.java
 */
package com.jaxio.web.domain;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import com.jaxio.domain.User;
import com.jaxio.repository.UserRepository;
import com.jaxio.repository.support.EntityGraphLoader;

/**
 * Preloads the {@link User} associations required by the view layer.
 */
@Named
@Singleton
public class UserGraphLoader extends EntityGraphLoader<User, Integer> {
    // required by cglib to create a proxy around the object as we are using the @Transactional annotation
    protected UserGraphLoader() {
        super();
    }

    @Inject
    public UserGraphLoader(UserRepository userRepository) {
        super(userRepository);
    }

    @Override
    public void loadGraph(User user) {
        loadCollection(user.getSecurityRoles());
    }
}