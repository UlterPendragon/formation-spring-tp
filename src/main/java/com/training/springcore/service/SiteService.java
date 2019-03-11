package com.training.springcore.service;

import com.training.springcore.model.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;

public interface SiteService {
    Site findById(String siteId);

    void readFile(String path) throws IOException;


}
