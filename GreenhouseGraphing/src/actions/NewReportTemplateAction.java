package actions;

import com.opensymphony.xwork2.ActionSupport;
import models.*;

import java.util.HashSet;
import java.util.Set;

public class NewReportTemplateAction extends ActionSupport {
    private ReportTemplate reportTemplate;
    private Set<ChartConfiguration> chartConfigurations;
    private Set<Sensor> sensors;
    private Set<Equation> equations;
    private Set<ManualData> manualData;

    @Override
    public String execute() throws Exception {
        // BEING - Testing Code
        sensors = new HashSet<Sensor>();
//        sensors.add(new Sensor(new Long(1), "Sensor 1's Name"));
//        sensors.add(new Sensor(new Long(2), "Sensor 2's Name"));
//        sensors.add(new Sensor(new Long(3), "Sensor 3's Name"));
        equations = new HashSet<Equation>();
        equations.add(new SampleEquation(new Long(1), "Equation 1's Name"));
        equations.add(new SampleEquation(new Long(2), "Equation 2's Name"));
        equations.add(new SampleEquation(new Long(3), "Equation 3's Name"));
        manualData = new HashSet<ManualData>();
        manualData.add(new ManualData(new Long(1), "Manual Data 1's Name"));
        manualData.add(new ManualData(new Long(2), "Manual Data 2's Name"));
        manualData.add(new ManualData(new Long(3), "Manual Data 3's Name"));
        // END - TESTING CODE

        return "success";
    }

    public Set<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(Set<Sensor> sensors) {
        this.sensors = sensors;
    }

    public Set<Equation> getEquations() {
        return equations;
    }

    public void setEquations(Set<Equation> equations) {
        this.equations = equations;
    }

    public Set<ManualData> getManualData() {
        return manualData;
    }

    public void setManualData(Set<ManualData> manualData) {
        this.manualData = manualData;
    }
}
