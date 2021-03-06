/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/main/java/project/domain/EntityMeta_.e.vm.java
 */
package com.jaxio.domain;

import java.util.Date;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.jaxio.domain.Civility;
import com.jaxio.domain.Role;

@StaticMetamodel(User.class)
public abstract class User_ {

    // Raw attributes
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> username;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, Boolean> isEnabled;
    public static volatile SingularAttribute<User, Civility> civility;
    public static volatile SingularAttribute<User, String> firstName;
    public static volatile SingularAttribute<User, String> lastName;
    public static volatile SingularAttribute<User, Date> creationDate;
    public static volatile SingularAttribute<User, String> creationAuthor;
    public static volatile SingularAttribute<User, Date> lastModificationDate;
    public static volatile SingularAttribute<User, String> lastModificationAuthor;
    public static volatile SingularAttribute<User, Integer> version;

    // Many to many
    public static volatile ListAttribute<User, Role> securityRoles;
}