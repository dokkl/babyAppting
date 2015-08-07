package com.hoon.appting.web;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by hoon on 2015-05-02.
 */
@Configuration
@Controller
public class ImageController {
    private static Logger log = LoggerFactory.getLogger(ImageController.class);

    @Value("${image.home}")
    private String imageHome;

    @RequestMapping("/image/{fileName}")
    public ResponseEntity<byte[]> getImage(@PathVariable("fileName") String fileName) throws IOException {
        log.debug("imageHome : " + imageHome);
        log.debug("fileName : " + fileName);
        File file = new File(imageHome + File.separator + fileName + ".jpg");
        InputStream in = FileUtils.openInputStream(file);
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);

        return new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
    }
}
