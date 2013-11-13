package actions;

import dao.MangoDAO;
import models.User;
import models.UserPriv;
import models.UserPrivBean;

/**
 * User: Daniel Deloff
 * Date: 11/12/13
 * Time: 7:56 PM
 */
public class PrivilegeChangeAction {
    private UserPrivBean bean;
    private MangoDAO mangoDAO;

    public PrivilegeChangeAction() {
        mangoDAO = new MangoDAO();
    }

    public String execute() {
        if (!bean.getUsername().equals("")&&!bean.getLevel().equals("")) {

            if (bean.getLevel().toString().length() > 1) return "invalid";

            User user = new User();
            user.setUsername(bean.getUsername());

            User tableUser = mangoDAO.getUser(user);

            if (tableUser == null) return "invalid";

            UserPriv userPriv = new UserPriv();

            userPriv.setId(tableUser.getId());
            //userPriv.setLevel(bean.getLevel());
            userPriv.setLevel('R');

            mangoDAO.updateLevel(userPriv);

            return "success";
        }

        return "invalid";
    }

    public UserPrivBean getBean() {
        return bean;
    }

    public void setBean(UserPrivBean bean) {
        this.bean = bean;
    }
}
