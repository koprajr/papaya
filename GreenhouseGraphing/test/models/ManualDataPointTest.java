package models;

import dao.MangoDAO;
import junit.framework.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: matthallman
 * Date: 11/16/13
 * Time: 2:06 PM
 * To change this template use File | Settings | File Templates.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ManualDataPointTest {


    @Test
    public void a_testCreateManualDataPoint() {
        MangoDAO dao = new MangoDAO();
        dao.insertManualDataPoint(getTestManualDataPoint_1());
        List<ManualDataPoint> mdps = dao.getManualDataPoints();
        boolean found = false;
        for (ManualDataPoint mdp : mdps) {
            if (mdp.getName().equals(getTestManualDataPoint_1().getName()))
                found = true;
        }
        Assert.assertEquals(true, found);
    }



    @Test
    public void b_testRemoveManualDataPoint() {
        MangoDAO dao = new MangoDAO();
        dao.deleteManualDataPoint(getTestManualDataPoint_1().getName());
        boolean found = false;
        List<ManualDataPoint> mdps = dao.getManualDataPoints();
        for (ManualDataPoint mdp : mdps) {
            if (mdp.getName().equals(getTestManualDataPoint_1().getName()))
                found = true;
        }
        Assert.assertEquals(false, found);
    }


    private static ManualDataPoint getTestManualDataPoint_1() {
        ManualDataPoint mdp = new ManualDataPoint();
        mdp.setName("test manual data point");
        return mdp;
    }

}
