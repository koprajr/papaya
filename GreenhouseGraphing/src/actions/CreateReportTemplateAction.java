package actions;

import com.opensymphony.xwork2.ActionSupport;
import models.ChartConfiguration;
import models.Equation;
import models.ReportTemplate;
import models.Sensor;

import java.util.HashSet;
import java.util.Set;

/**
 *  This action handles the creation of a new Report Template.
 */
public class CreateReportTemplateAction extends ActionSupport {
    private ReportTemplate reportTemplate;
    private Set<ChartConfiguration> chartConfigurations;
    private Set<Sensor> sensors;
    private Set<Equation> equations;
    private Set<Object> manualData;

    @Override
    public String execute() throws Exception {
        // BEING - Testing Code
        sensors = new HashSet<Sensor>();
        sensors.add(new Sensor(new Long(1), "kasa"));
        sensors.add(new Sensor(new Long(2), "dawitt"));
        sensors.add(new Sensor(new Long(3), "williams"));
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

    public Set<Object> getManualData() {
        return manualData;
    }

    public void setManualData(Set<Object> manualData) {
        this.manualData = manualData;
    }
}
