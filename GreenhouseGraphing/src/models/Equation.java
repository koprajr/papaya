package models;

import java.math.BigInteger;

/**
 *
 */
public interface Equation {
    public Integer solve();
    public void setTimeInterval(BigInteger start, BigInteger end);

}
