package actions;

import models.User;
import dao.MangoDAO;

import java.io.File;
import org.apache.commons.io.FileUtils;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UploadAction extends ActionSupport implements ServletRequestAware{
    private File upload;
    private String uploadContentType;
    private String uploadFileName;
    private HttpServletRequest servletRequest;

    private MangoDAO mangoDao;
    private UsersAction usersAction;

    public UploadAction(){
        mangoDao = new MangoDAO();
        usersAction = new UsersAction();
    }

    public String execute() {
        String filePath = servletRequest.getSession().getServletContext().getRealPath("/"); // get path to directory
        uploadFileName = getUploadFileName(); //name of uploaded file

        saveFile(filePath); //save file at path location
        String pathToFile = filePath + uploadFileName; //create string of uploaded file's location
        parseAndInsertCSV(pathToFile); //parse the file

        return "success";
    }

    public String saveFile(String filePath) {
        try {
            File fileToCreate = new File(filePath, uploadFileName);// Create file at filePath called fileToParse.csv
            FileUtils.copyFile(upload, fileToCreate); // copy temp file content to this file

        } catch (Exception e) {
            e.printStackTrace();
            addActionError(e.getMessage());
            return "input";
        }
        return "success";
    }

    public String parseAndInsertCSV(String pathToFile) {
        BufferedReader br = null;
        String line; //var to hold current line
        String cvsSplitBy = ","; //set comma as delimiter

        try {

            br = new BufferedReader(new FileReader(pathToFile)); //open the file
            while ((line = br.readLine()) != null) {
                String[] userData = line.split(cvsSplitBy); //split line at the delimiter
                User newUser = new User();            // User object to be created
                newUser = usersAction.setUserInfo(newUser, userData); // set User Info

                mangoDao.createUser(newUser); //create new User
            }
        } catch (FileNotFoundException e) {
            System.err.println("Upload File Not Found.");
            e.printStackTrace();
            return "input";
        } catch (IOException e) {
            System.err.println("IO Exception");
            e.printStackTrace();
            return "input";
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return "input";
                }
            }
        }

        return "success";
    }
    public String display() {
        return NONE;
    }

    @Override
    public void setServletRequest(HttpServletRequest servletRequest) {
        this.servletRequest = servletRequest;

    }

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName){
        this.uploadFileName = uploadFileName;
    }

    public String getUploadContentType() {
        return uploadContentType;
    }

    public void setUploadContentType(String uploadContentType){
        this.uploadContentType = uploadContentType;
    }
}