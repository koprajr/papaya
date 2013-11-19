package actions;

import com.opensymphony.xwork2.ActionSupport;
import dao.MangoDAO;
import models.ManualDataType;

/**
 * Created with IntelliJ IDEA.
 * User: Jeff
 * Date: 11/18/13
 * Time: 11:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class newManualDataType extends ActionSupport {
    private MangoDAO mangoDAO;
    private ManualDataType bean;

    public newManualDataType() {
        mangoDAO = new MangoDAO();
    }

    public String execute() {
        bean.setName(bean.getName().toUpperCase());
        ManualDataType testManualDataType = mangoDAO.selectManualDataType(bean);

        if (testManualDataType == null) {
            mangoDAO.insertManualDataType(bean);
            return "success";
        }

        return "invalid";

    }

    public ManualDataType getBean() {
        return bean;
    }

    public void setBean(ManualDataType bean) {
        this.bean = bean;
    }
}
