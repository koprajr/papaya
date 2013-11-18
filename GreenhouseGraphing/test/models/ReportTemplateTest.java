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
        Assert.assertEquals(testTemplate_1.getIndividualSensors().size(), testTemplate1PulledFromDB.getIndividualSensors().size());
        Assert.assertEquals(testTemplate_1.getManualDataPoints().size(), testTemplate1PulledFromDB.getManualDataPoints().size());
        ChartConfiguration chartConfiguration = testTemplate1PulledFromDB.getChartConfigurations().iterator().next();
        Assert.assertEquals("chartName", chartConfiguration.getTitle());
        Assert.assertEquals("x label", chartConfiguration.getxAxis());
        Assert.assertEquals("y label", chartConfiguration.getyAxis());

    }

    @Test
    public void testSelectAllReportTemplates() throws Exception{
        MangoDAO dao = new MangoDAO();
        List<ReportTemplate> reportTemplates = dao.getAllReportTemplates();
        System.out.println(reportTemplates);  // TODO: make this test better. Just used debugger to see result.

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
        ManualDataPoint mdp = new ManualDataPoint(1, "");
        manualDataPoints.add(mdp);
        testTemplate_1.setManualDataPoints(manualDataPoints);


        ChartConfiguration chartConfig = new ChartConfiguration();
        chartConfig.setSensors(new ArrayList<Sensor>(sensors));
        chartConfig.setTitle("chartName");
        chartConfig.setxAxis("x label");
        chartConfig.setyAxis("y label");
        chartConfig.setType("plot");
//        chartConfig.setEquations();
        chartConfig.setManualData(new ArrayList<ManualDataPoint>(manualDataPoints));
        chartConfigurations.add(chartConfig);
        testTemplate_1.setChartConfigurations(chartConfigurations);


        return testTemplate_1;
    }



}
