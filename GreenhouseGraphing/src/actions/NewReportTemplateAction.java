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
    private List<Sensor> sensors;
    private Set<Equation> equations;
    private Set<ManualData> manualData;

    @Override
    public String execute() throws Exception {
        // BEING - Testing Code
    	MangoDAO dao = new MangoDAO();
		sensors = dao.getSensors();
    	
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

    public Set<ManualData> getManualData() {
        return manualData;
    }

    public void setManualData(Set<ManualData> manualData) {
        this.manualData = manualData;
    }
}
