package actions;

import com.opensymphony.xwork2.ActionSupport;
import dao.MangoDAO;
import models.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NewReportTemplateSelectPointsAction extends ActionSupport{

    private List<String> manualDataTypes;
    private MangoDAO dao;
    private List<Sensor> sensors;


    public NewReportTemplateSelectPointsAction() {
        dao = new MangoDAO();
    }

    @Override
    public String execute() throws Exception {
        sensors = dao.getSensors();
        manualDataTypes = dao.selectManualDataTypes();
        return SUCCESS;
    }

    public List<String> getManualDataTypes() {
        return manualDataTypes;
    }

    public void setManualDataTypes(List<String> manualDataTypes) {
        this.manualDataTypes = manualDataTypes;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }
}
