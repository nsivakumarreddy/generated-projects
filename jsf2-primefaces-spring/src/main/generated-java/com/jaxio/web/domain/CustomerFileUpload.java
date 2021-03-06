/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-jsf2-spring-conversation:src/main/java/domain/FileUpload.e.vm.java
 */
package com.jaxio.web.domain;

import org.apache.commons.io.FilenameUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.jaxio.domain.Customer;

public class CustomerFileUpload {
    private Customer customer;

    public CustomerFileUpload(Customer customer) {
        this.customer = customer;
    }

    /**
     * Primefaces support for contractBinary file upload
     */
    public void onContractBinaryFileUpload(FileUploadEvent fileUploadEvent) {
        UploadedFile uploadedFile = fileUploadEvent.getFile(); //application code
        customer.setContractBinary(uploadedFile.getContents());
        customer.setContractSize(customer.getContractBinary().length);
        customer.setContractContentType(uploadedFile.getContentType());
        customer.setContractFileName(FilenameUtils.getName(uploadedFile.getFileName()));
    }
}