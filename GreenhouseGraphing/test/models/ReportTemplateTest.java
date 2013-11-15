package models;

import dao.MangoDAO;
import junit.framework.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class ReportTemplateTest {
    @Test
    public void testGetIndividualSensors() throws Exception {

    }

    @Test
    public void testGetEquations() throws Exception {

    }

    @Test
    public void testGetManualData() throws Exception {

    }

    @Test
    public void testGetChartConfigurations() throws Exception {

    }

    @Test
    public void testCreateReportTemplate() throws Exception {

        MangoDAO dao = new MangoDAO();
        dao.deleteAllReportTemplates();

        ReportTemplate testTemplate_1 = getTestTemplate_1();
        dao.createReportTemplate(testTemplate_1);


        ReportTemplate testTemplate1PulledFromDB = dao.getReportTemplateByName(testTemplate_1.getName());

        Assert.assertEquals(testTemplate_1, testTemplate1PulledFromDB);

        Assert.assertEquals(testTemplate1PulledFromDB.getManualDataPoint().iterator().next().getId(), new Long(1));
        Assert.assertEquals(testTemplate1PulledFromDB.getManualDataPoint().iterator().next().getName(), "Pounds of lettuce added to digestor");
        Assert.assertEquals(testTemplate1PulledFromDB.getDescription(), "a description");
    }

    private ReportTemplate getTestTemplate_1() {
        Set<Sensor> sensors = new HashSet<Sensor>();
        Set<Equation> equations = new HashSet<Equation>();
        Set<ManualDataPoint> manualDataPoints = new HashSet<ManualDataPoint>();
        Set<ChartConfiguration> chartConfigurations = new HashSet<ChartConfiguration>();

        ReportTemplate testTemplate_1 = new ReportTemplate();
        testTemplate_1.setName("test template 1");
        testTemplate_1.setDescription("a description");

        // Add sensors to this report.
        Sensor s = new Sensor();
        s.setId(22);
        sensors.add(s);
        s = new Sensor();
        s.setId(23);
        sensors.add(s);
        testTemplate_1.setIndividualSensors(sensors);


        // Add Manual data points to this report.
        ManualDataPoint mdp = new ManualDataPoint(new Long(1), "");
        manualDataPoints.add(mdp);
        testTemplate_1.setManualDataPoint(manualDataPoints);


        ChartConfiguration chartConfig = new ChartConfiguration(sensors, equations, manualDataPoints);
//        chartConfig.
//        chartConfigurations.add(chartConfig);
        testTemplate_1.setChartConfigurations(chartConfigurations);


        return testTemplate_1;
    }



}
