package actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.MangoDAO;
import models.ManualData;
import models.ManualDataBean;
import models.ManualDataType;
import models.User;
import org.apache.derby.client.am.DateTime;
import utils.TimeUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    private String start;

    public InsertManualDataAction() {
        mangoDAO = new MangoDAO();
    }

    public String execute() {
        if (bean == null) return "invalid";
        if (!bean.getQuantity().equals("")&&!bean.getType().equals("")){
            if (!isDouble(bean.getQuantity())) return "invalid";
            ManualData manualData = new ManualData();

            Double value = Double.parseDouble(bean.getQuantity());

            User user = new User();
            Map<String, Object> session = ActionContext.getContext().getSession();
            user.setUsername((String)session.get("username"));
            User tableUser = mangoDAO.getUser(user);

            ManualDataType manualDataType = new ManualDataType();
            manualDataType.setName(bean.getType());
            ManualDataType tableManualDataType = mangoDAO.selectManualDataType(manualDataType);

            manualData.setUserId(tableUser.getId());
            manualData.setValue(value);

            //manualData.setTimeStamp(System.currentTimeMillis());
            manualData.setTimeStamp(TimeUtils .timeStampToEpochTime(start));
            manualData.setTypeId(tableManualDataType.getId());

            mangoDAO.insertManualData(manualData);

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

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }
}
