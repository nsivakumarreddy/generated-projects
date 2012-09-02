/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-primefaces:src/main/java/domain/LazyDataModel.e.vm.java
 */
package com.jaxio.demo.web.domain.more;

import java.util.List;
import java.util.Map;
import javax.inject.Inject;

import org.primefaces.model.SortOrder;

import com.jaxio.demo.dao.support.SearchParameters;
import com.jaxio.demo.domain.more.MoreTypesDemo;
import com.jaxio.demo.repository.more.MoreTypesDemoRepository;
import com.jaxio.demo.web.domain.support.GenericLazyDataModel;

/**
 * Provides server-side pagination for search.
 *
 * @see http://jira.springframework.org/browse/SWF-1224 to avoid instanciate it as a var from your flow 
 */
public class MoreTypesDemoLazyDataModel extends GenericLazyDataModel<MoreTypesDemo> {
    private static final long serialVersionUID = 1L;

    @Inject
    transient private MoreTypesDemoRepository moreTypesDemoRepository;
    @Inject
    transient private MoreTypesDemoSearchForm moreTypesDemoSearchForm;

    /**
     * Prepare the search parameters and call the moreTypesDemoRepository finder.
     * Automatically called by PrimeFaces component.
     */
    @Override
    public List<MoreTypesDemo> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {
        SearchParameters sp = moreTypesDemoSearchForm.getSearchParameters();
        sp.clearRanges();
        sp.addRange(moreTypesDemoSearchForm.getNumberIntRange());
        sp.addRange(moreTypesDemoSearchForm.getNumberLongRange());
        sp.addRange(moreTypesDemoSearchForm.getNumberDoubleRange());
        sp.addRange(moreTypesDemoSearchForm.getNumberFloatRange());
        sp.addRange(moreTypesDemoSearchForm.getNumberBigIntegerRange());
        sp.addRange(moreTypesDemoSearchForm.getNumberBigDecimalRange());
        sp.addRange(moreTypesDemoSearchForm.getDateJavaTemporalDateRange());
        sp.addRange(moreTypesDemoSearchForm.getDateJavaTemporalTimestampRange());
        sp.addRange(moreTypesDemoSearchForm.getDateJodaRange());
        sp.addRange(moreTypesDemoSearchForm.getDateTimeJodaRange());
        MoreTypesDemo moreTypesDemo = moreTypesDemoSearchForm.getMoreTypesDemo();
        setRowCount(moreTypesDemoRepository.findCount(moreTypesDemo, sp)); // total count so the paginator may display the total number of pages
        populateSearchParameters(sp, first, pageSize, sortField, sortOrder, filters); // load one page of data
        return moreTypesDemoRepository.find(moreTypesDemo, sp);
    }
}