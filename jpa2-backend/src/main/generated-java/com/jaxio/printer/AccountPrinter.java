/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/main/java/project/printer/Printer.e.vm.java
 */
package com.jaxio.printer;

import java.util.Locale;

import javax.inject.Named;
import javax.inject.Singleton;

import com.jaxio.domain.Account;
import com.jaxio.domain.Account_;
import com.jaxio.printer.support.GenericPrinter;

/**
 * {@link GenericPrinter} for {@link Account} 
 *
 * @see TypeAwarePrinter
 */
@Named
@Singleton
public class AccountPrinter extends GenericPrinter<Account> {
    public AccountPrinter() {
        super(Account.class, Account_.accountNumber.getName(), Account_.name.getName());
    }

    @Override
    public String print(Account account, Locale locale) {
        if (account == null) {
            return "";
        }
        StringBuilder ret = new StringBuilder();
        appendIfNotEmpty(ret, account.getAccountNumber());
        appendIfNotEmpty(ret, account.getName());
        return ret.toString();
    }
}