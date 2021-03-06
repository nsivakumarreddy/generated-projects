/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-jsf2-spring-conversation:src/main/java/domain/SearchForm.e.vm.java
 */
package com.jaxio.web.domain;

import static com.jaxio.dao.support.EntitySelector.newEntitySelector;
import static com.jaxio.dao.support.PropertySelector.newPropertySelector;
import static com.jaxio.dao.support.Ranges.RangeBigDecimal.newRangeBigDecimal;
import static com.jaxio.dao.support.Ranges.RangeLocalDate.newRangeLocalDate;

import java.math.BigDecimal;

import javax.inject.Named;

import com.jaxio.dao.support.EntitySelector;
import com.jaxio.dao.support.PropertySelector;
import com.jaxio.dao.support.Ranges.RangeBigDecimal;
import com.jaxio.dao.support.Ranges.RangeLocalDate;
import com.jaxio.dao.support.SearchParameters;
import com.jaxio.domain.Account;
import com.jaxio.domain.Currency;
import com.jaxio.domain.Transaction;
import com.jaxio.domain.Transaction_;
import com.jaxio.web.domain.support.GenericSearchForm;
import com.jaxio.web.faces.ConversationContextScoped;

/**
 * View Helper to search {@link Transaction}.
 * It exposes a {@link Transaction} instance so it can be used in search by-example-query.
 */
@Named
@ConversationContextScoped
public class TransactionSearchForm extends GenericSearchForm<Transaction, Integer, TransactionSearchForm> {
    private static final long serialVersionUID = 1L;

    protected Transaction transaction = new Transaction();
    protected RangeBigDecimal<Transaction> amountRange = newRangeBigDecimal(Transaction_.amount);
    protected RangeLocalDate<Transaction> transactionDateRange = newRangeLocalDate(Transaction_.transactionDate);
    protected RangeLocalDate<Transaction> valueDateRange = newRangeLocalDate(Transaction_.valueDate);
    protected PropertySelector<Transaction, BigDecimal> amountSelector = newPropertySelector(Transaction_.amount);
    protected PropertySelector<Transaction, String> descriptionSelector = newPropertySelector(Transaction_.description);
    protected EntitySelector<Transaction, Currency, Integer> currencySelector = newEntitySelector(Transaction_.currency);
    protected EntitySelector<Transaction, Account, Integer> accountSelector = newEntitySelector(Transaction_.account);

    public Transaction getTransaction() {
        return transaction;
    }

    @Override
    protected Transaction getEntity() {
        return getTransaction();
    }

    @Override
    public TransactionSearchForm newInstance() {
        return new TransactionSearchForm();
    }

    @Override
    public SearchParameters toSearchParameters() {
        return new SearchParameters() //
                .limitBroadSearch() //
                .anywhere() //
                .caseInsensitive() //
                .leftJoin(Transaction_.account) //
                .range(amountRange, transactionDateRange, valueDateRange) //
                .property(amountSelector, descriptionSelector) //
                .entity(currencySelector, accountSelector) //
        ;
    }

    @Override
    public void resetWithOther(TransactionSearchForm other) {
        this.transaction = other.getTransaction();
        this.amountRange = other.getAmountRange();
        this.transactionDateRange = other.getTransactionDateRange();
        this.valueDateRange = other.getValueDateRange();
        this.amountSelector = other.getAmountSelector();
        this.descriptionSelector = other.getDescriptionSelector();
        this.currencySelector = other.getCurrencySelector();
        this.accountSelector = other.getAccountSelector();
    }

    // Ranges
    public RangeBigDecimal<Transaction> getAmountRange() {
        return amountRange;
    }

    public RangeLocalDate<Transaction> getTransactionDateRange() {
        return transactionDateRange;
    }

    public RangeLocalDate<Transaction> getValueDateRange() {
        return valueDateRange;
    }

    // Property selectors
    public PropertySelector<Transaction, BigDecimal> getAmountSelector() {
        return amountSelector;
    }

    public PropertySelector<Transaction, String> getDescriptionSelector() {
        return descriptionSelector;
    }

    // Relation selectors
    public EntitySelector<Transaction, Currency, Integer> getCurrencySelector() {
        return currencySelector;
    }

    public EntitySelector<Transaction, Account, Integer> getAccountSelector() {
        return accountSelector;
    }
}
