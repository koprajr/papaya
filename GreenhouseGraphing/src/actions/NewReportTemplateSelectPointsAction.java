package actions;

import com.opensymphony.xwork2.ActionSupport;
import dao.MangoDAO;
import models.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NewReportTemplateSelectPointsAction extends ActionSupport{

    private MangoDAO dao;
    private List<String> manualDataTypes;
    private List<Sensor> sensors;
    private List<Sensor> sensorsGW;
    private List<Sensor> sensorsGL;
    private List<Sensor> sensorsGT;
    private List<Sensor> sensorsGE;


    public NewReportTemplateSelectPointsAction() {
        dao = new MangoDAO();
    }

    @Override
    public String execute() throws Exception {

        Category cat = new Category();
        cat.setName("greenhouseWater");
        Category tableCategory = dao.selectCategory(cat);
        if (tableCategory == null) return "invalid";
        int categoryId = tableCategory.getId();
        cat.setId(categoryId);

        Category cat2 = new Category();
        cat2.setName("greenhouseLighting");
        Category tableCategory2 = dao.selectCategory(cat2);
        if (tableCategory2 == null) return "invalid";
        int categoryId2 = tableCategory2.getId();
        cat2.setId(categoryId2);

        Category cat3 = new Category();
        cat3.setName("greenhouseTemperature");
        Category tableCategory3 = dao.selectCategory(cat3);
        if (tableCategory3 == null) return "invalid";
        int categoryId3 = tableCategory3.getId();
        cat3.setId(categoryId3);

        Category cat4 = new Category();
        cat4.setName("greenhouseElectricity");
        Category tableCategory4 = dao.selectCategory(cat4);
        if (tableCategory4 == null) return "invalid";
        int categoryId4 = tableCategory4.getId();
        cat4.setId(categoryId4);

        sensorsGW = dao.selectDataPointsForCategory(cat);
        sensorsGL = dao.selectDataPointsForCategory(cat2);
        sensorsGT = dao.selectDataPointsForCategory(cat3);
        sensorsGE = dao.selectDataPointsForCategory(cat4);


        manualDataTypes = dao.selectManualDataTypes();
        sensors = dao.getSensors();
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

    public List<Sensor> getSensorsGE() {
        return sensorsGE;
    }

    public void setSensorsGE(List<Sensor> sensorsGE) {
        this.sensorsGE = sensorsGE;
    }

    public List<Sensor> getSensorsGT() {
        return sensorsGT;
    }

    public void setSensorsGT(List<Sensor> sensorsGT) {
        this.sensorsGT = sensorsGT;
    }

    public List<Sensor> getSensorsGL() {
        return sensorsGL;
    }

    public void setSensorsGL(List<Sensor> sensorsGL) {
        this.sensorsGL = sensorsGL;
    }

    public List<Sensor> getSensorsGW() {
        return sensorsGW;
    }

    public void setSensorsGW(List<Sensor> sensorsGW) {
        this.sensorsGW = sensorsGW;
    }
}
