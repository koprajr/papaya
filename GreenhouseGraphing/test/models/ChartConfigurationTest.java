package models;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ChartConfigurationTest {



    @Test
    public void testGetIndividualSensors() throws Exception {

    }

    @Test
    public void testGetEquations() throws Exception {

    }

    @Test
    public void testGetManualData() throws Exception {

    }


    private ChartConfiguration getTestChartConfig_1() {
        ChartConfiguration chartConfig = new ChartConfiguration();
        chartConfig.setReportTemplateId(1);
        chartConfig.setTitle("test chart configuration name");
        chartConfig.setxAxis("x label");
        chartConfig.setyAxis("y label");
        chartConfig.setChartType("a chart type");

        List<Sensor> sensors = new ArrayList<Sensor>();
        Sensor s = new Sensor();
        s.setId(22);
        sensors.add(s);
        s = new Sensor(); s.setId(27);
        sensors.add(s);
        s = new Sensor(); s.setId(30);
        sensors.add(s);
        chartConfig.setSensors(sensors);


        List<Equation> equations = new ArrayList<Equation>();
        chartConfig.setEquations(equations);

        List<ManualDataPoint> manualDataPoints = new ArrayList<ManualDataPoint>();
        chartConfig.setManualData(manualDataPoints);




        return chartConfig;



    }
}
