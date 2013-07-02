/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-selenium-primefaces:src/test/java/selenium/support/element/CustomElement.p.vm.java
 */
package com.jaxio.web.selenium.support.elements;

import org.openqa.selenium.By;

import com.jaxio.web.selenium.support.WebClient;

public abstract class CustomElement {
    protected String id;
    protected By by;
    protected WebClient webClient;

    public CustomElement() {
    }

    public CustomElement(By by) {
        this.by = by;
    }

    public CustomElement(String id) {
        this(By.id(id));
        this.id = id;
    }

    protected By by() {
        return by;
    }
}