package actions;

import com.opensymphony.xwork2.ActionSupport;
import dao.MangoDAO;
import models.ChartConfiguration;
import models.Equation;
import models.ReportTemplate;
import models.Sensor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class EditReportTemplateAction extends ActionSupport {
    private ReportTemplate template;
    private List<Integer> templateSensorIds;
    private Set<ChartConfiguration> chartConfigurations;
    private List<Sensor> sensors;
    private Set<Equation> equations;
    private Set<Object> manualData;

    @Override
    public String execute() throws Exception {

        MangoDAO dao = new MangoDAO();

        // -- BEGIN TEST CODE
        template = dao.getReportTemplateByName("test tesmplate 6");

        sensors = dao.getSensors();
        templateSensorIds = new ArrayList<Integer>();
        if (template.getSensors() != null) {
            for (Sensor s : template.getSensors()) {
                templateSensorIds.add(s.getId());
            }
        }
        // -- END TEST CODE

        return SUCCESS;
    }

    public ReportTemplate getTemplate() {
        return template;
    }

    public void setTemplate(ReportTemplate template) {
        this.template = template;
    }

    public List<Integer> getTemplateSensorIds() {
        return templateSensorIds;
    }

    public void setTemplateSensorIds(List<Integer> templateSensorIds) {
        this.templateSensorIds = templateSensorIds;
    }

    public Set<ChartConfiguration> getChartConfigurations() {
        return chartConfigurations;
    }

    public void setChartConfigurations(Set<ChartConfiguration> chartConfigurations) {
        this.chartConfigurations = chartConfigurations;
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

    public Set<Object> getManualData() {
        return manualData;
    }

    public void setManualData(Set<Object> manualData) {
        this.manualData = manualData;
    }
}
