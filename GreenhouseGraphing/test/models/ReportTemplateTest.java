package models;

import dao.MangoDAO;
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

        Assert.assertEquals(testTemplate_1.getName(), testTemplate1PulledFromDB.getName());
        Assert.assertEquals(testTemplate_1.getDescription(), testTemplate_1.getDescription());
        Assert.assertEquals(testTemplate_1.getSensors().size(), testTemplate1PulledFromDB.getSensors().size());
        Assert.assertEquals(testTemplate_1.getManualData().size(), testTemplate1PulledFromDB.getManualData().size());
        ChartConfiguration chartConfiguration = testTemplate1PulledFromDB.getChartConfigurations().iterator().next();
        Assert.assertEquals("chartName", chartConfiguration.getName());
        Assert.assertEquals("x label", chartConfiguration.getxLabel());
        Assert.assertEquals("y label", chartConfiguration.getyLabal());

    }

    @Test
    public void testSelectAllReportTemplates() throws Exception{
        MangoDAO dao = new MangoDAO();
        List<ReportTemplate> reportTemplates = dao.getAllReportTemplates();
        System.out.println(reportTemplates);  // TODO: make this test better. Just used debugger to see result.

    }

    private ReportTemplate getTestTemplate_1() {
        List<Sensor> sensors = new ArrayList<Sensor>();
        Set<Equation> equations = new HashSet<Equation>();
        List<ManualDataPoint> manualDataPoints = new ArrayList<ManualDataPoint>();
        List<ChartConfiguration> chartConfigurations = new ArrayList<ChartConfiguration>();

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
        testTemplate_1.setSensors(sensors);


        // Add Manual data points to this report.
        ManualDataPoint mdp = new ManualDataPoint(1, "");
        manualDataPoints.add(mdp);
        testTemplate_1.setManualData(manualDataPoints);


        ChartConfiguration chartConfig = new ChartConfiguration();
        chartConfig.setSensors(new ArrayList<Sensor>(sensors));
        chartConfig.setName("chartName");
        chartConfig.setxLabel("x label");
        chartConfig.setyLabal("y label");
        chartConfig.setChartType("plot");
//        chartConfig.setEquations();
        chartConfig.setManualData(new ArrayList<ManualDataPoint>(manualDataPoints));
        chartConfigurations.add(chartConfig);
        testTemplate_1.setChartConfigurations(chartConfigurations);


        return testTemplate_1;
    }



}