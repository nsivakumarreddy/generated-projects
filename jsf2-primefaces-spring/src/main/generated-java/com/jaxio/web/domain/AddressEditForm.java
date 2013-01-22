/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-spring:src/main/java/domain/EditForm.e.vm.java
 */
package com.jaxio.web.domain;

import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;
import com.jaxio.domain.Address;
import com.jaxio.repository.AddressRepository;
import com.jaxio.web.domain.support.GenericEditForm;

/**
 * View Helper to edit {@link Address}.
 */
@Named
@Scope("conversation")
public class AddressEditForm extends GenericEditForm<Address, Integer> {
    private Address address;

    @Inject
    public AddressEditForm(AddressRepository addressRepository) {
        super(addressRepository);
    }

    @Override
    protected void onInit(Address param) {
        this.address = param;
    }

    @Override
    public Address getEntity() {
        return address;
    }

    public Address getAddress() {
        return address;
    }
}