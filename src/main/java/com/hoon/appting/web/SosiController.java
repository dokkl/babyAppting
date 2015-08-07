package com.hoon.appting.web;

import com.hoon.appting.entity.Sosi;
import com.hoon.appting.repository.SosiRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hoon on 2015-07-22.
 */
@RestController
@RequestMapping("/sosi")
public class SosiController {
    static final Logger LOG = LoggerFactory.getLogger(SosiController.class);

    @Autowired
    private SosiRepository sosiRepository;

    @RequestMapping("{sosiId}")
    public Sosi getSosi(@PathVariable Long sosiId) {
        LOG.debug("===========> getSosi sosiId : {}", sosiId);
        return sosiRepository.findOne(sosiId);
    }
}
