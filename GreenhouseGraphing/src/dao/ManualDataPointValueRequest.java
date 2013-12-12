package dao;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: matthallman
 * Date: 11/16/13
 * Time: 8:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class ManualDataPointValueRequest {

    int ManualDataPointId;
    long ts_start;
    long ts_end;


    public ManualDataPointValueRequest() {
    }

    public ManualDataPointValueRequest(int manualDataPointId, long ts_start, long ts_end) {
        ManualDataPointId = manualDataPointId;
        this.ts_start = ts_start;
        this.ts_end = ts_end;
    }

    public int getManualDataPointId() {
        return ManualDataPointId;
    }

    public long getTs_start() {
        return ts_start;
    }

    public long getTs_end() {
        return ts_end;
    }
}