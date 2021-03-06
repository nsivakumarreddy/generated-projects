/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-selenium-primefaces:src/test/java/selenium/support/element/Paginator.p.vm.java
 */
package com.jaxio.web.selenium.support.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Paginator extends CustomElement {
    private static final String ONE_RESULT = "There is one result";
    private static final String NO_RESULT = "There is no result";
    // paginator
    @FindBy(css = "div.ui-paginator-bottom span.ui-paginator-pages span.ui-state-active")
    public WebElement paginatorCurrent;
    @FindBy(css = "div.ui-paginator-bottom span.ui-icon-seek-next")
    public WebElement paginatorNextButton;
    @FindBy(css = "div.ui-paginator-bottom span.ui-icon-seek-prev")
    public WebElement paginatorPrevButton;

    // sum
    @FindBy(id = "searchResultsRegion")
    public WebElement searchResultsRegion;

    public void next() {
        webClient.click(paginatorNextButton);
    }

    public void previous() {
        webClient.click(paginatorPrevButton);
    }

    public void isPage(int pageId) {
        webClient.waitUntilTextIsPresent(paginatorCurrent, String.valueOf(pageId));
    }

    public void hasResult(String value) {
        webClient.waitUntilTextIsPresent(searchResultsRegion, value);
    }

    public void hasSize(int size) {
        hasResult(sizeToString(size));
    }

    private String sizeToString(int size) {
        switch (size) {
        case 0:
            return NO_RESULT;
        case 1:
            return ONE_RESULT;
        default:
            return "There are " + size + " results";
        }
    }
}
