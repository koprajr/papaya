package models;

/**
 * User: Daniel Deloff
 * Date: 11/6/13
 * Time: 10:29 PM
 */
public class PasswordBean {
    private String username;
    private String oldPass;
    private String newPass;
    private String newPass2;

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

    public String getNewPass2() {
        return newPass2;
    }

    public void setNewPass2(String newPass2) {
        this.newPass2 = newPass2;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
