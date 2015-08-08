package com.bkersanske.playersalarytool.domain;

import com.google.common.base.Preconditions;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

/**
 * @author bkersanske
 * @since 08/08/15 11:21
 */
@MappedSuperclass
public abstract class BaseObject implements IDomainObject {

    private static final long serialVersionUID = 1L;

    /* Unique team id */
    @Id
    private String id;

    @Column
    private Date updated = null;

    public BaseObject() {
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        if (id != null) {
            this.id = id.toLowerCase(Locale.ENGLISH);
        }
    }

    public void setUpdated(Date date) {
        if(date != null) {
            updated = (Date) date.clone();
        }
    }

    public Date getUpdated() {
        if (this.updated != null) {
            return (Date) updated.clone();
        }
        return null;
    }

    @Override
    public void prepareForWrite() {
        Preconditions.checkNotNull(getId(), "The id field must not be null!");
    }

    @Override
    public void validate() {
        Preconditions.checkNotNull(getId(), "The id field must not be null!");
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else if (!(other instanceof BaseObject)) {
            return false;
        } else {
            BaseObject otherBase = (BaseObject) other;
            if(id == null && otherBase.getId() != null) {
                return false;
            } else if (id != null && otherBase.getId() == null) {
                return false;
            }
            return getId().equals(otherBase.getId());
        }
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
