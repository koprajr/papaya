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
    private Set<ManualDataPoint> manualDataPoint;

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
        manualDataPoint = new HashSet<ManualDataPoint>();
        manualDataPoint.add(new ManualDataPoint(new Long(1), "Manual Data 1's Name"));
        manualDataPoint.add(new ManualDataPoint(new Long(2), "Manual Data 2's Name"));
        manualDataPoint.add(new ManualDataPoint(new Long(3), "Manual Data 3's Name"));
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

    public Set<ManualDataPoint> getManualDataPoint() {
        return manualDataPoint;
    }

    public void setManualDataPoint(Set<ManualDataPoint> manualDataPoint) {
        this.manualDataPoint = manualDataPoint;
    }
}
