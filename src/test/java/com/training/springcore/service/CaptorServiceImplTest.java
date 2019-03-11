package com.training.springcore.service;

import com.training.springcore.model.Captor;
import com.training.springcore.service.measure.MeasureService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@RunWith(SpringRunner.class)
public class CaptorServiceImplTest {
    @Mock
    private MeasureService fixedMeasureService;
    @Mock
    private MeasureService simulatedMeasureService;
    @Mock
    private MeasureService realMeasureService;

    @InjectMocks
    private CaptorServiceImpl captorService;

    @Test
    public void findBySiteShouldReturnNullWhenIdIsNull() {
        // Initialisation
        String siteId = null;

        // Appel du SUT
        Set<Captor> captors = captorService.findBySite(siteId);

        // Vérification
        Assertions.assertThat(captors).isEmpty();
    }

    @Test
    public void findBySite() {
        // Initialisation
        String siteId = "siteId";

        // Appel du SUT
        Set<Captor> captors = captorService.findBySite(siteId);

        // Vérification
        Assertions.assertThat(captors).hasSize(1);
        Assertions.assertThat(captors).extracting(Captor::getName).contains("Capteur A");
    }
}