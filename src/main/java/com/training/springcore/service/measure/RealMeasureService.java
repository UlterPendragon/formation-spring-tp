package com.training.springcore.service.measure;

import com.training.springcore.model.Captor;
import com.training.springcore.model.Measure;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service("realMeasureService")
public class RealMeasureService implements MeasureService {

    @Value("${bigcorp.measure.default-real}")
    private Integer defaultValue;

    public List<Measure> readMeasures(Captor captor, Instant start, Instant end, MeasureStep step ){

        checkReadMeasuresArgs(captor, start, end, step);

        List<Measure> measures = new ArrayList<>();
        Instant current = start;

        while(current.isBefore(end)){
            measures.add(new Measure(current, 20_000_000, captor));
            current = current.plusSeconds(step.getDurationInSecondes());
        }
        return measures;
    }


}
