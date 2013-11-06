package models;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoginBeanTest {

    private static LoginBean bean;

    @Before
    public void setUp() throws Exception {
        bean = new LoginBean();
    }

    @After
    public void tearDown() throws Exception {
        bean = null;
    }

    @Test
    public void testGetName() throws Exception {
        bean.setName("Kasa");
        Assert.assertEquals("Kasa", bean.getName());
    }

    @Test
    public void testGetPassword() throws Exception {
        bean.setPassword("password");
        Assert.assertEquals("password", bean.getPassword());
    }
}
