package com.bkersanske.playersalarytool.controllers;

import com.bkersanske.playersalarytool.services.IUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author bkersanske
 * @since 09/08/15 19:39
 */
@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private IUploadService uploadService;

    @RequestMapping(method= RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("file") MultipartFile file) {
        if(!file.isEmpty()) {
            try {
                uploadService.processFileInputStream(file.getInputStream());
                return "Upload of file succeeeded!";
            } catch(Exception e) {
                return "Upload of file failed: " + e.getMessage();
            }
        } else {
            return "Upload of file failed because it was empty!";
        }
    }

}
