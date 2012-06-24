/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/main/java/project/service/ServiceImpl.e.vm.java
 */
package fr.jaxio.demo.service.more;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import javax.inject.Named;
import javax.inject.Singleton;

import fr.jaxio.demo.dao.support.GenericDao;
import fr.jaxio.demo.service.support.GenericEntityServiceImpl;
import fr.jaxio.demo.domain.more.MoreTypesDemo;
import fr.jaxio.demo.dao.more.MoreTypesDemoDao;

/**
 * Default implementation of the {@link MoreTypesDemoService} interface.
 * Note: you may use multiple DAO from this layer.
 * @see MoreTypesDemoService
 */
@Named("moreTypesDemoService")
@Singleton
public class MoreTypesDemoServiceImpl extends GenericEntityServiceImpl<MoreTypesDemo, Integer> implements MoreTypesDemoService {

    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(MoreTypesDemoServiceImpl.class);

    protected MoreTypesDemoDao moreTypesDemoDao;

    @Inject
    public void setMoreTypesDemoDao(MoreTypesDemoDao moreTypesDemoDao) {
        this.moreTypesDemoDao = moreTypesDemoDao;
    }

    /**
     * Dao getter used by the {@link GenericEntityServiceImpl}.
     */
    @Override
    public GenericDao<MoreTypesDemo, Integer> getDao() {
        return moreTypesDemoDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MoreTypesDemo getNew() {
        return new MoreTypesDemo();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MoreTypesDemo getNewWithDefaults() {
        MoreTypesDemo result = getNew();
        result.initDefaultValues();
        return result;
    }

}