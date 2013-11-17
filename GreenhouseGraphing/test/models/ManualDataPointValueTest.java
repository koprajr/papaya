package models;

import dao.MangoDAO;
import junit.framework.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: matthallman
 * Date: 11/16/13
 * Time: 8:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class ManualDataPointValueTest {

    private final int USER_ID = 4;
    private final int MANUAL_DATA_POINT_ID = 1;



    @Test
    public void testManualDataPointValue() {

        List<ManualDataPointValue> manualDataPointValues = getTestManualDataPointValues_1();

        MangoDAO dao = new MangoDAO();
        for (ManualDataPointValue mdpv : manualDataPointValues) {
            dao.insertManualDataPointValue(mdpv);
        }


        List<ManualDataPointValue> valuesFromDB = dao.getManualDataPointValuesForPointInRange(MANUAL_DATA_POINT_ID, new BigInteger(String.valueOf(250)), new BigInteger(String.valueOf(3500)));

        for (int i = 0; i < manualDataPointValues.size(); i++) {
            ManualDataPointValue mdpv = manualDataPointValues.get(i);
            ManualDataPointValue mdpv_DB = valuesFromDB.get(i);
            Assert.assertEquals(mdpv.getManualDataPointId(), mdpv_DB.getManualDataPointId());
            Assert.assertEquals(mdpv.getUserId(), mdpv_DB.getUserId());
            Assert.assertEquals(mdpv.getPointValue(), mdpv_DB.getPointValue());
            Assert.assertEquals(mdpv.getTs(), mdpv_DB.getTs());
        }
    }






    private List<ManualDataPointValue> getTestManualDataPointValues_1() {
        List<ManualDataPointValue> pointValues = new ArrayList<ManualDataPointValue>();
        Random r = new Random();
        for (int i = 1; i < 15; i++) {
            ManualDataPointValue pointValue = new ManualDataPointValue();
            pointValue.setManualDataPointId(MANUAL_DATA_POINT_ID);
            pointValue.setPointValue(r.nextDouble());
            pointValue.setUserId(USER_ID);
            pointValue.setTs(new BigInteger(String.valueOf(i * 250)));   // minTs:250   maxTs: 3500
            pointValues.add(pointValue);
        }
        return pointValues;
    }

}
