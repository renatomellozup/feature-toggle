package com.rrodrigues.featuretoggle.decisions;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Endpoint(id = "feature-toggles")
public class FeatureToogleDecisions {

    private final FeatureDecisions featureDecisions;

    public FeatureToogleDecisions(FeatureDecisions featureDecisions) {
        this.featureDecisions = featureDecisions;
    }

    @ReadOperation
    public Map<String, Boolean> featureToggles() {
        return featureDecisions.getToggles();
    }
}
