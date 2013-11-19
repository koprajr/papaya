package actions;

import com.opensymphony.xwork2.ActionSupport;
import dao.MangoDAO;
import models.ChartConfiguration;
import models.Equation;
import models.ReportTemplate;
import models.Sensor;

import java.util.Set;

public class EditReportTemplateAction extends ActionSupport {
    private ReportTemplate template;
    private Set<ChartConfiguration> chartConfigurations;
    private Set<Sensor> sensors;
    private Set<Equation> equations;
    private Set<Object> manualData;

    @Override
    public String execute() throws Exception {
        // TODO: Implement the logic for this action.
        MangoDAO dao = new MangoDAO();
        return SUCCESS;
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
