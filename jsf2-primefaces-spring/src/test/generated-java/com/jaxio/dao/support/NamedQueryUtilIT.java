/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/test/java/dao/support/NamedQueryUtilIT.p.vm.java
 */
package com.jaxio.dao.support;

import java.util.*;

import javax.inject.Inject;
import org.apache.log4j.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.jaxio.dao.support.*;
import com.jaxio.util.*;
import com.jaxio.domain.Account;
import com.jaxio.domain.Address;
import com.jaxio.domain.Book;
import com.jaxio.domain.Document;
import com.jaxio.domain.Legacy;
import com.jaxio.domain.more.MoreTypesDemo;
import com.jaxio.domain.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext-test.xml" })
@Transactional
public class NamedQueryUtilIT {

    private static final Logger log = Logger.getLogger(NamedQueryUtilIT.class);

    @Inject
    private NamedQueryUtil namedQueryUtil;

    @Test
    public void executeGetAllAccountsQueryName() {
        String sqlQuery = "Account.selectAll";
        List<Account> accounts = namedQueryUtil.findByNamedQuery(new SearchParameters().namedQuery(sqlQuery));

        if (accounts != null) {
            log.info(accounts.size());

            for (Account account : accounts) {
                log.info(account.toString());
            }
        }
    }

    @Test
    public void executeGetAllAccountsSqlQuery() {
        String sqlQuery = "Account.selectAll.native";
        List<Account> accounts = namedQueryUtil.findByNamedQuery(new SearchParameters().namedQuery(sqlQuery));

        if (accounts != null) {
            log.info(accounts.size());
            for (Account account : accounts) {
                log.info(account.toString());
            }
        }
    }

}