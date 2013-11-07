package models;

/**
 * User: Daniel Deloff
 * Date: 11/6/13
 * Time: 10:29 PM
 */
public class PasswordBean {
    private String oldPass;
    private String newPass;

    public String getOldpass() {
        return oldPass;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }
}
