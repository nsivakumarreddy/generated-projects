/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/test/java/domain/ModelTest.e.vm.java
 */
package com.jaxio.domain;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.LAZY;
import static org.fest.assertions.Assertions.assertThat;

import java.io.*;
import java.io.Serializable;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jaxio.domain.Account;
import com.jaxio.domain.Address;
import com.jaxio.util.*;

/**
 * Basic tests for Customer
 */
@SuppressWarnings("unused")
public class CustomerTest {

    // test unique primary key
    @Test
    public void newInstanceHasNoPrimaryKey() {
        Customer model = new Customer();
        assertThat(model.isIdSet()).isFalse();
    }

    @Test
    public void isIdSetReturnsTrue() {
        Customer model = new Customer();
        model.setId(ValueGenerator.getUniqueInteger());
        assertThat(model.getId()).isNotNull();
        assertThat(model.isIdSet()).isTrue();
    }

    //-------------------------------------------------------------
    // Many to One:  Customer.address ==> Address.id
    //-------------------------------------------------------------

    @Test
    public void manyToOne_setAddress() {
        Customer many = new Customer();

        // init
        Address one = new Address();
        one.setId(ValueGenerator.getUniqueInteger());
        many.setAddress(one);

        // make sure it is propagated properly
        assertThat(many.getAddress()).isEqualTo(one);

        // now set it to back to null
        many.setAddress(null);

        // make sure null is propagated properly
        assertThat(many.getAddress()).isNull();
    }

    //-------------------------------------------------------------
    // One to Many: SimpleOneToMany CUSTOMER.ID ==> ACCOUNT.CUSTOMER_ID
    //-------------------------------------------------------------

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // account.account <-- customer.customers
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @Test
    public void oneToMany_addAccount() {
        Customer one = new Customer();
        Account many = new Account();

        // init
        one.addAccount(many);

        // make sure it is propagated
        assertThat(one.getAccounts()).contains(many);
        assertThat(one).isEqualTo(many.getCustomer());

        // now set it to null
        one.removeAccount(many);

        // make sure null is propagated
        assertThat(one.getAccounts().contains(many)).isFalse();
        assertThat(many.getCustomer()).isNull();
    }

    /*
     public void equalsUsingPk() {
     Customer model1 = new Customer();
     Customer model2 = new Customer();

     Integer id = ValueGenerator.getUniqueInteger();
     model1.setId(id);
     model2.setId(id);

     model1.setCompanyName("a");
     model2.setCompanyName("a");

     model1.setContractBinary("dummy".getBytes());
     model2.setContractBinary("dummy".getBytes());

     model1.setContractFileName("dummy.txt");
     model2.setContractFileName("dummy.txt");

     model1.setContractContentType("application/text");
     model2.setContractContentType("application/text");

     model1.setContractSize(1);
     model2.setContractSize(1);

     model1.setVersion(1);
     model2.setVersion(1);
     assertThat(model1.isIdSet()).isTrue();
     assertThat(model2.isIdSet()).isTrue();
     assertThat(model1.hashCode()).isEqualTo(model2.hashCode());
     assertThat(model1).isEqualTo(model2);
     assertThat(model2).isEqualTo(model1);
     }
     */
}