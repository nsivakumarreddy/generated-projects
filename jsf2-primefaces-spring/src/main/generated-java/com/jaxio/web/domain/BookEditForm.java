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
import com.jaxio.domain.Account;
import com.jaxio.domain.Book;
import com.jaxio.repository.BookRepository;
import com.jaxio.web.conversation.ConversationContext;
import com.jaxio.web.domain.AccountController;
import com.jaxio.web.domain.support.GenericEditForm;

/**
 * View Helper to edit {@link Book}.
 */
@Named
@Scope("conversation")
public class BookEditForm extends GenericEditForm<Book, Integer> {
    private Book book;

    @Inject
    public BookEditForm(BookRepository bookRepository) {
        super(bookRepository);
    }

    @Override
    protected void onInit(Book param) {
        this.book = param;
    }

    @Override
    public Book getEntity() {
        return book;
    }

    public Book getBook() {
        return book;
    }

    // --------------------------------------------
    // Actions for account association
    // --------------------------------------------

    public String viewAccount() {
        ConversationContext<Account> ctx = AccountController.newEditContext(book.getAccount());
        ctx.setLabelWithKey("book_account");
        conversation().pushSubReadOnly(ctx);
        return ctx.view();
    }
}