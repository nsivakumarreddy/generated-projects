/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-sd:src/main/java/project/domain/Entity.e.vm.java
 */
package com.jaxio.demo.domain;

import com.google.common.base.Objects;

import javax.xml.bind.annotation.XmlTransient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.domain.Persistable;

@Entity
@Table(name = "`ROLE`")
public class Role implements Persistable<Integer> {
    private static final long serialVersionUID = 1L;
    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(Role.class);

    // Raw attributes
    private Integer id; // pk
    private String roleName; // unique (not null)

    // ---------------------------
    // Constructors
    // ---------------------------

    public Role() {
    }

    public Role(Integer primaryKey) {
        setId(primaryKey);
    }

    @Override
    @Transient
    @XmlTransient
    public boolean isNew() {
        return getId() == null;
    }

    // -------------------------------
    // Getter & Setter
    // -------------------------------

    // -- [id] ------------------------

    @Column(name = "ID", precision = 10)
    @GeneratedValue
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // -- [roleName] ------------------------

    @NotEmpty
    @Size(max = 255)
    @Column(name = "role_name", nullable = false, unique = true)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * Set the default values.
     */
    public void initDefaultValues() {
    }

    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof Role && hashCode() == other.hashCode());
    }

    /**
     * hashCode implementation using a business key.
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(getRoleName());
    }

    /**
     * Construct a readable string representation for this {@link Role} instance.
     */
    @Override
    public String toString() {
        return Objects.toStringHelper(this) //
                .add("id", getId()) //
                .add("roleName", getRoleName()) //
                .toString();
    }
}