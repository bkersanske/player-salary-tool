package com.bkersanske.playersalarytool.services;

import org.springframework.stereotype.Service;

import java.io.InputStream;

/**
 * @author bkersanske
 * @since 09/08/15 19:51
 */
@Service
public interface IUploadService {

    public void processFileInputStream(InputStream inputStream);

}
