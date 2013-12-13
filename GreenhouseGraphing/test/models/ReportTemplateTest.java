package models;

import dao.MangoDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ReportTemplateTest {

    private MangoDAO dao;
    private ReportTemplate defaultTemplate;

    @Before
    public void setUp() throws Exception {
        dao = new MangoDAO();

        List<Sensor> sensors = new ArrayList<Sensor>();
        List<ManualDataPoint> manualDataPoints = new ArrayList<ManualDataPoint>();
        List<ChartConfiguration> chartConfigurations = new ArrayList<ChartConfiguration>();

        defaultTemplate.setName("test template 100");
        defaultTemplate.setDescription("a description");

        // Add sensors to this report.
        Sensor s = new Sensor();
        s.setId(22);
        sensors.add(s);
        s = new Sensor();
        s.setId(23);
        sensors.add(s);
        defaultTemplate.setSensors(sensors);

        // Add Manual data points to this report.
        ManualDataPoint mdp = new ManualDataPoint(1, "");
        manualDataPoints.add(mdp);
        defaultTemplate.setManualData(manualDataPoints);

        // Add Chart configuration.
        ChartConfiguration chartConfig = new ChartConfiguration();
        chartConfig.setSensors(sensors);
        chartConfig.setName("test configuration 100");
        chartConfig.setxLabel("x label");
        chartConfig.setyLabel("y label");
        chartConfig.setChartType("bar");
        chartConfig.setManualData(manualDataPoints);
        chartConfigurations.add(chartConfig);
        defaultTemplate.setChartConfigurations(chartConfigurations);
    }

    @After
    public void tearDown() throws Exception {
        dao = null;
        defaultTemplate = null;
    }

    @Test
    public void testCreateReportTemplate() throws Exception {

        // Save template to database.
        dao.createReportTemplate(defaultTemplate);

        // Load same template from database.
        ReportTemplate t1 = dao.getReportTemplateByName(defaultTemplate.getName());

        assertEquals(defaultTemplate.getName(), t1.getName());
        assertEquals(defaultTemplate.getDescription(), t1.getDescription());
        assertEquals(defaultTemplate.getSensors().size(), t1.getSensors().size());
        assertEquals(defaultTemplate.getManualData().size(), t1.getManualData().size());

        ChartConfiguration defaultConfig = defaultTemplate.getChartConfigurations().iterator().next();
        ChartConfiguration cc1 = t1.getChartConfigurations().iterator().next();
        assertEquals(defaultConfig.getName(), cc1.getName());
        assertEquals(defaultConfig.getxLabel(), cc1.getxLabel());
        assertEquals(defaultConfig.getyLabel(), cc1.getyLabel());
    }

    /*
        Test the following functions (database queries):

            + MangoDAO.deleteAllTemplateDataPointAssoc()
            + MangoDAO.deleteAllChartConfigurationDataPointAssoc()
            + MangoDAO.deleteAllTemplateChartConfigurationAssoc()
     */
    @Test
    public void testEditReportTemplate() throws Exception {
    }

    @Test
    public void testSelectAllReportTemplates() throws Exception {
        List<ReportTemplate> reportTemplates = dao.getAllReportTemplates();
        System.out.println(reportTemplates);  // TODO: make this test better. Just used debugger to see result.
    }

}
