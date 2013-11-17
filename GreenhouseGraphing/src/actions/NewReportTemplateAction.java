package actions;

import com.opensymphony.xwork2.ActionSupport;
import dao.MangoDAO;
import models.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NewReportTemplateAction extends ActionSupport {
    private ReportTemplate reportTemplate;
    private Set<ChartConfiguration> chartConfigurations;

    private MangoDAO dao;
    private List<Sensor> sensors;
    private Set<Equation> equations;
    private Set<ManualDataPoint> ManualDataPoints;

    public NewReportTemplateAction() {
        dao = new MangoDAO();
    }

    @Override
    public String execute() throws Exception {
        // BEING - Testing Code
        sensors = dao.getSensors();
        equations = new HashSet<Equation>();
        equations.add(new SampleEquation(new Long(1), "Equation 1's Name"));
        equations.add(new SampleEquation(new Long(2), "Equation 2's Name"));
        equations.add(new SampleEquation(new Long(3), "Equation 3's Name"));
        ManualDataPoints = new HashSet<ManualDataPoint>();
        // END - TESTING CODE

        return SUCCESS;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    public Set<Equation> getEquations() {
        return equations;
    }

    public void setEquations(Set<Equation> equations) {
        this.equations = equations;
    }

    public Set<ManualDataPoint> getManualDataPoints() {
        return ManualDataPoints;
    }

    public void setManualDataPoints(Set<ManualDataPoint> manualDataPoints) {
        this.ManualDataPoints = manualDataPoints;
    }
}
