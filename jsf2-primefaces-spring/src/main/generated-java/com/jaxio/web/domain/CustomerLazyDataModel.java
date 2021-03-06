/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-jsf2-spring-conversation:src/main/java/domain/LazyDataModel.e.vm.java
 */
package com.jaxio.web.domain;

import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.LazyDataModel;

import com.jaxio.domain.Customer;
import com.jaxio.repository.CustomerRepository;
import com.jaxio.web.converter.CustomerJsfConverter;
import com.jaxio.web.domain.support.GenericLazyDataModel;
import com.jaxio.web.faces.ConversationContextScoped;

/**
 * Provide PrimeFaces {@link LazyDataModel} for {@link Customer}
 */
@Named
@ConversationContextScoped
public class CustomerLazyDataModel extends GenericLazyDataModel<Customer, Integer, CustomerSearchForm> {
    private static final long serialVersionUID = 1L;

    @Inject
    public CustomerLazyDataModel(CustomerRepository customerRepository, CustomerJsfConverter customerConverter, CustomerController customerController,
            CustomerSearchForm customerSearchForm) {
        super(customerRepository, customerConverter, customerController, customerSearchForm);
    }
}