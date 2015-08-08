package com.bkersanske.playersalarytool.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author bkersanske
 * @since 08/08/15 11:48
 */
public interface IDomainObject extends Serializable {

    String getId();

    void prepareForWrite();

    void validate();

    void setUpdated(Date d);
}
