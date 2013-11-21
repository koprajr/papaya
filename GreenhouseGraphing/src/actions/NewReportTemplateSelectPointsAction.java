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
    private List<Sensor> gW_sensors;
    private List<Sensor> gL_sensors;
    private List<Sensor> gT_sensors;
    private List<Sensor> gE_sensors;


    public NewReportTemplateSelectPointsAction() {
        dao = new MangoDAO();
    }

    @Override
    public String execute() throws Exception {

        ///////////////////////////////////

        Category cat = new Category();
        cat.setName("greenhouseWater");
        Category tableCategory = dao.selectCategory(cat);
        if (tableCategory == null) return "invalid";
        int categoryId = tableCategory.getId();
        cat.setId(categoryId);

        gW_sensors = dao.selectDataPointsForCategory(cat);
        System.out.println(gW_sensors);

        ///////////////////////////////////

        cat.setName("greenhouseLighting");
        tableCategory = dao.selectCategory(cat);
        if (tableCategory == null) return "invalid";
        categoryId = tableCategory.getId();
        cat.setId(categoryId);

        gL_sensors = dao.selectDataPointsForCategory(cat);

        ///////////////////////////////////

        cat.setName("greenhouseTemperature");
        tableCategory = dao.selectCategory(cat);
        if (tableCategory == null) return "invalid";
        categoryId = tableCategory.getId();
        cat.setId(categoryId);

        gT_sensors = dao.selectDataPointsForCategory(cat);

        ///////////////////////////////////

        cat.setName("greenhouseElectricity");
        tableCategory = dao.selectCategory(cat);
        if (tableCategory == null) return "invalid";
        categoryId = tableCategory.getId();
        cat.setId(categoryId);

        gE_sensors = dao.selectDataPointsForCategory(cat);

        ///////////////////////////////////

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

    public List<Sensor> getgE_sensors() {
        return gE_sensors;
    }

    public void setgE_sensors(List<Sensor> gE_sensors) {
        this.gE_sensors = gE_sensors;
    }

    public List<Sensor> getgT_sensors() {
        return gT_sensors;
    }

    public void setgT_sensors(List<Sensor> gT_sensors) {
        this.gT_sensors = gT_sensors;
    }

    public List<Sensor> getgL_sensors() {
        return gL_sensors;
    }

    public void setgL_sensors(List<Sensor> gL_sensors) {
        this.gL_sensors = gL_sensors;
    }

    public List<Sensor> getgW_sensors() {
        return gW_sensors;
    }

    public void setgW_sensors(List<Sensor> gW_sensors) {
        this.gW_sensors = gW_sensors;
    }


}
