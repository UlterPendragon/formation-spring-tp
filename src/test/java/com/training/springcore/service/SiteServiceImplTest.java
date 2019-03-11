package com.training.springcore.service;

import com.training.springcore.model.Captor;
import com.training.springcore.model.Site;
import com.training.springcore.utils.OutputCapture;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {
        SiteServiceImplTest.SiteServiceTestConfiguration.class})
        public class SiteServiceImplTest {

    @Configuration
    @ComponentScan("com.training.springcore.service")
    static class SiteServiceTestConfiguration{ }

    @Autowired
    private SiteService siteService;

    @Rule
    public OutputCapture output = new OutputCapture();


    @Test
    public void readFileFromUrl(){
        try {
            siteService.readFile("url:https://dev-mind.fr/lorem.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(output.toString()).contains("Lorem ipsum dolor sit amet, consectetur adipiscing elit");
    }
    @Test
    public void readFileFromClasspath(){
        try {
            siteService.readFile("classpath:lorem.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(output.toString()).contains("Lorem ipsum dolor sit amet, consectetur adipiscing elit");
    }
    @Test
    public void readFileFromFileSystem(){
        try {
            siteService.readFile("file:/C:/Users/Diginamic/Desktop/lorem.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(output.toString()).contains("Lorem ipsum dolor sit amet, consectetur adipiscing elit");
    }

   /* @Test
    public void findByIdShouldReturnNullWhenIdIsNull(){
        // Initialisation
        String siteId = null;

        // Appel du SUT
        Site site = siteService.findById(siteId);

        // Vérification
        assertThat(site).isNull();

    } */
}