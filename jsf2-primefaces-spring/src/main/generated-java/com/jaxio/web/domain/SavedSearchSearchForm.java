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

import javax.inject.Named;

import com.jaxio.dao.support.EntitySelector;
import com.jaxio.dao.support.PropertySelector;
import com.jaxio.dao.support.SearchParameters;
import com.jaxio.domain.SavedSearch;
import com.jaxio.domain.SavedSearch_;
import com.jaxio.domain.User;
import com.jaxio.web.domain.support.GenericSearchForm;
import com.jaxio.web.faces.ConversationContextScoped;

/**
 * View Helper to search {@link SavedSearch}.
 * It exposes a {@link SavedSearch} instance so it can be used in search by-example-query.
 */
@Named
@ConversationContextScoped
public class SavedSearchSearchForm extends GenericSearchForm<SavedSearch, Integer, SavedSearchSearchForm> {
    private static final long serialVersionUID = 1L;

    protected SavedSearch savedSearch = new SavedSearch();
    protected PropertySelector<SavedSearch, String> nameSelector = newPropertySelector(SavedSearch_.name);
    protected PropertySelector<SavedSearch, String> formClassnameSelector = newPropertySelector(SavedSearch_.formClassname);
    protected EntitySelector<SavedSearch, User, Integer> userSelector = newEntitySelector(SavedSearch_.user);

    public SavedSearch getSavedSearch() {
        return savedSearch;
    }

    @Override
    protected SavedSearch getEntity() {
        return getSavedSearch();
    }

    @Override
    public SavedSearchSearchForm newInstance() {
        return new SavedSearchSearchForm();
    }

    @Override
    public SearchParameters toSearchParameters() {
        return new SearchParameters() //
                .limitBroadSearch() //
                .anywhere() //
                .caseInsensitive() //
                .property(nameSelector, formClassnameSelector) //
                .entity(userSelector) //
        ;
    }

    @Override
    public void resetWithOther(SavedSearchSearchForm other) {
        this.savedSearch = other.getSavedSearch();
        this.nameSelector = other.getNameSelector();
        this.formClassnameSelector = other.getFormClassnameSelector();
        this.userSelector = other.getUserSelector();
    }

    // Property selectors
    public PropertySelector<SavedSearch, String> getNameSelector() {
        return nameSelector;
    }

    public PropertySelector<SavedSearch, String> getFormClassnameSelector() {
        return formClassnameSelector;
    }

    // Relation selectors
    public EntitySelector<SavedSearch, User, Integer> getUserSelector() {
        return userSelector;
    }
}
