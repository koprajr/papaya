package actions;

import com.opensymphony.xwork2.ActionSupport;
import dao.MangoDAO;
import models.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NewReportTemplateAction extends ActionSupport {
    private ReportTemplate reportTemplate;
    private Set<ChartConfiguration> chartConfigurations;
    private List<Integer> manualDataIds;
    private List<ManualDataPoint> manualDataPoints;

    private MangoDAO dao;
    private List<Sensor> sensors;
    private Set<Equation> equations;
    private List<String> manualData;
    private ReportTemplate bean;

    private Set<Integer> cBox = new HashSet<Integer>();
    private Set<String> mBox = new HashSet<String>();
    private Sensor testSensor;
    private ManualDataPoint testManualDataPoint;
    private int id;

    public NewReportTemplateAction() {
        dao = new MangoDAO();
    }

    @Override
    public String execute() throws Exception {

        manualDataPoints = new ArrayList<ManualDataPoint>();
        if (manualDataIds != null) {
            for (Integer id : manualDataIds) {
                manualDataPoints.add(dao.selectManualDataPointById(id));
            }
        }

        // BEING - Testing Code
        //sensors = dao.getSensors();
        equations = new HashSet<Equation>();
        sensors = new ArrayList<Sensor>();
        manualData = new ArrayList<String>();


        if (!cBox.isEmpty() && cBox != null) {
            for (Integer s : cBox) {
                testSensor = dao.getSensor(s);
                sensors.add(testSensor);
            }
        }
        if (!mBox.isEmpty() && mBox != null) {
            for (String s : mBox) {
                manualData.add(s);
            }
        }

        return SUCCESS;
    }

    public List<ManualDataPoint> getManualDataPoints() {
        return manualDataPoints;
    }

    public void setManualDataPoints(List<ManualDataPoint> manualDataPoints) {
        this.manualDataPoints = manualDataPoints;
    }

    public List<Integer> getManualDataIds() {
        return manualDataIds;
    }

    public void setManualDataIds(List<Integer> manualDataIds) {
        this.manualDataIds = manualDataIds;
    }

    public void setSensorIds(String[] sensorIdsS) {
        for (String sensorIds : sensorIdsS) {
            try {
                id = Integer.parseInt(sensorIds);
                cBox.add(id);
            } catch (NumberFormatException nfe) {
                System.out.println("ERROR-----------------------------------------------------------------------------------");
            } catch (NullPointerException npe) {
                System.out.println("ERROR-----------------------------------------------------------------------------------");
            }
            //cBox.add(testSensor);
        }
    }

    public void setManualIds(String[] manualIdsS) {
        for (String manualIds : manualIdsS) {
            try {
                mBox.add(manualIds);
            } catch (NumberFormatException nfe) {
                System.out.println("ERROR-----------------------------------------------------------------------------------");
            } catch (NullPointerException npe) {
                System.out.println("ERROR-----------------------------------------------------------------------------------");
            }
        }
    }

    public ReportTemplate getBean() {
        return bean;
    }

    public void setBean(ReportTemplate bean) {
        this.bean = bean;
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

    public List<String> getManualData() {
        return manualData;
    }

    public void setManualData(List<String> manualData) {
        this.manualData = manualData;
    }
}
