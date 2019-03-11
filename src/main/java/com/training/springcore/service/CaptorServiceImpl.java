package com.training.springcore.service;

import com.training.springcore.model.Captor;
import com.training.springcore.model.PowerSource;
import com.training.springcore.service.measure.MeasureService;
import com.training.springcore.service.measure.MeasureStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service("captorServiceImpl")
public class CaptorServiceImpl implements CaptorService{

    private MeasureService fixedMeasureService;
    private MeasureService simulatedMeasureService;
    private MeasureService realMeasureService;

    @Autowired
    public CaptorServiceImpl(MeasureService fixedMeasureService, MeasureService simulatedMeasureService, MeasureService realMeasureService) {
        this.fixedMeasureService = fixedMeasureService;
        this.simulatedMeasureService = simulatedMeasureService;
        this.realMeasureService = realMeasureService;
    }

    @Override
    public Set<Captor> findBySite(String siteId) {
        Set<Captor> captors = new HashSet<>();
        if (siteId == null) {
            return captors;
        }
        captors.add(new Captor("capteur A", PowerSource.FIXED));
        captors.add(new Captor("capteur B", PowerSource.SIMULATED));
        captors.add(new Captor("capteur C", PowerSource.REAL));
        return captors;
    }
}
