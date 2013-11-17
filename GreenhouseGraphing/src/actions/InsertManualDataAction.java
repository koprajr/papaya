package actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.MangoDAO;
import models.*;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Jeff
 * Date: 11/13/13
 * Time: 12:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class InsertManualDataAction extends ActionSupport {
    private ManualDataBean bean;
    private MangoDAO mangoDAO;

    public InsertManualDataAction() {
        mangoDAO = new MangoDAO();
    }

    public String execute() {
        if (bean == null) return "invalid";
        if (!bean.getQuantity().equals("")&&!bean.getType().equals("")){
            if (!isDouble(bean.getQuantity())) return "invalid";
            ManualDataPointValue manualDataPointValue = new ManualDataPointValue();

            Double value = Double.parseDouble(bean.getQuantity());

            User user = new User();
            Map<String, Object> session = ActionContext.getContext().getSession();
            user.setUsername((String)session.get("username"));
            User tableUser = mangoDAO.getUser(user);

            ManualDataPoint manualDataType = new ManualDataPoint();
            manualDataType.setName(bean.getType());
            ManualDataPoint tableManualDataType = mangoDAO.selectManualDataType(manualDataType);

            manualDataPointValue.setUserId(tableUser.getId());
            manualDataPointValue.setPointValue(value);
            manualDataPointValue.setTs(System.currentTimeMillis());
            manualDataPointValue.setManualDataPointId(tableManualDataType.getId());

            mangoDAO.insertManualDataPointValue(manualDataPointValue);

            return "success";
        }

        return "invalid";

    }

    boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void setBean(ManualDataBean bean) {
        this.bean = bean;
    }

    public ManualDataBean getBean() {
        return bean;
    }
}
