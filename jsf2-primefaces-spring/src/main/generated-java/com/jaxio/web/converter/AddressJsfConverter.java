/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-jsf2-spring-conversation:src/main/java/converter/JsfConverter.e.vm.java
 */
package com.jaxio.web.converter;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import com.jaxio.domain.Address;
import com.jaxio.repository.AddressRepository;
import com.jaxio.web.converter.support.GenericJsfConverter;

/**
 * JSF converter for {@link Address}.
 * @see GenericJsfConverter
 */
@Named
@Singleton
public class AddressJsfConverter extends GenericJsfConverter<Address, Integer> {
    @Inject
    public AddressJsfConverter(AddressRepository addressRepository) {
        super(addressRepository, Address.class, Integer.class);
    }
}