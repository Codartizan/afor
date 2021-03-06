package nz.co.afor.reports;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gherkin.ast.Feature;
import nz.co.afor.reports.results.ResultValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matt on 15/03/2016.
 */
public class FeatureResult {
    private final String name;
    private final int anchor;
    private List<ScenarioResult> scenarios = new ArrayList<>();
    private List<ScenarioOutlineResult> scenarioOutlines = new ArrayList<>();

    FeatureResult(Feature feature) {
        this.name = feature.getName();
        this.anchor = feature.getLocation().toString().hashCode();
    }

    public String getName() {
        return name;
    }

    public List<ScenarioResult> getScenarios() {
        return scenarios;
    }

    public List<ScenarioOutlineResult> getScenarioOutlines() {
        return scenarioOutlines;
    }

    @JsonIgnore
    public int getAnchor() {
        return anchor;
    }

    @JsonIgnore
    public ResultValue getScenarioResultCount() {
        ResultValue resultValue = new ResultValue();
        for (ScenarioResult scenarioResult : getScenarios())
            resultValue.addResult(scenarioResult.getScenarioResult());
        for (ScenarioOutlineResult scenarioOutlineResult : getScenarioOutlines())
            resultValue.addResult(scenarioOutlineResult.getScenarioResult());
        return resultValue;
    }
}
