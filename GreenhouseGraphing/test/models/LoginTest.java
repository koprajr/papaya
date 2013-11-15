package models;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginTest {

    private static Login bean;

    @Before
    public void setUp() throws Exception {
        bean = new Login();
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
