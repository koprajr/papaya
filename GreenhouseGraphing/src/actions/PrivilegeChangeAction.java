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
    private UserPrivBean userPrivBean;
    private MangoDAO mangoDAO;

    public PrivilegeChangeAction() {
        mangoDAO = new MangoDAO();
    }

    public String execute() {
        if (!userPrivBean.getUsername().equals("")&&!userPrivBean.getLevel().equals("")) {

            if (userPrivBean.getLevel().toString().length() > 1) return "invalid";

            User user = new User();
            user.setUsername(userPrivBean.getUsername());

            User tableUser = mangoDAO.getUser(user);

            if (tableUser == null) return "invalid";

            UserPriv userPriv = new UserPriv();

            userPriv.setId(tableUser.getId());
            userPriv.setLevel(userPrivBean.getLevel());

            mangoDAO.updateLevel(userPriv);

            return "success";
        }

        return "invalid";
    }

    public UserPrivBean getUserPrivBean() {
        return userPrivBean;
    }

    public void setUserPrivBean(UserPrivBean userPrivBean) {
        this.userPrivBean = userPrivBean;
    }
}
