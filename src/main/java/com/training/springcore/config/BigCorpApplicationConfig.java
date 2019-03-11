package com.training.springcore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@ComponentScan("com.training.springcore")
@Configuration
public class BigCorpApplicationConfig {


    @Autowired
    private Environment environment;

  /*  public ApplicationInfo applicationInfo() {
        String name = environment.getRequiredProperty("bigcorp.name");
        Integer version = environment.getRequiredProperty("bigcorp.version", Integer.class);
        Set<String> emails = environment.getRequiredProperty("bigcorp.emails", Set.class);
        String webSiteUrl = environment.getRequiredProperty("bigcorp.webSiteUrl");

        return new ApplicationInfo(name, version, emails, webSiteUrl);
    } */


}

