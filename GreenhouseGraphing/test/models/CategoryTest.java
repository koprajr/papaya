package models;

import dao.MangoDAO;
import junit.framework.Assert;
import models.associations.categories.CategoryDataPointAssoc;
import models.associations.categories.CategoryManualDataPointAssoc;
import models.associations.categories.CategoryReportTemplateAssoc;
import org.junit.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: matthallman
 * Date: 11/18/13
 * Time: 6:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class CategoryTest {


    @Test
    public void testCategories() {
        MangoDAO dao = new MangoDAO();
        Category testCategory = getTestCategory();
        dao.insertCategory(testCategory.getName());

        List<Category> categoriesFromDB = null;
        categoriesFromDB = dao.selectCategories();
        boolean found = false;
        for (Category category : categoriesFromDB) {
            if (category.getName().equals(testCategory.getName())) {
                testCategory = category; // set the correct Id on the test category for future tests.
                found = true;
            }
        }
        Assert.assertEquals(true, found);


        testCategorizeDataPoint(testCategory, getTestSensor());
        testCategorizeManualDataPoint(testCategory, getTestManualDataPoint());
        testCategorizeReportTemplate(testCategory, getTestReportTemplate());



        dao.deleteCategory(testCategory.getName());
        categoriesFromDB = dao.selectCategories();
        found = false;
        for (Category category : categoriesFromDB) {
            if (category.getName().equals(testCategory.getName())) {
                found = true;
            }
        }
        Assert.assertEquals(false, found);

    }

    private void testCategorizeDataPoint(Category category, Sensor dataPoint) {
        MangoDAO dao = new MangoDAO();
        dao.categorizeDataPoint(category, dataPoint);
        boolean found = false;
        List<Sensor> sensorsMatchingCategory = dao.selectDataPointsForCategory(category);
        for (Sensor sensor : sensorsMatchingCategory) {
            if (sensor.getId() == dataPoint.getId()) {
                found = true;
            }
        }
        Assert.assertEquals(true, found);

        // test removing category from sensor:

        dao.deleteCategoryDataPointAssoc(new CategoryDataPointAssoc(category.getId(), dataPoint.getId()));
        found = false;
        sensorsMatchingCategory = dao.selectDataPointsForCategory(category);
        for (Sensor sensor : sensorsMatchingCategory) {
            if (sensor.getId() == dataPoint.getId()) {
                found = true;
            }
        }
        Assert.assertEquals(false, found);
    }


    private void testCategorizeManualDataPoint(Category category, ManualDataPoint manualDataPoint) {
        MangoDAO dao = new MangoDAO();
        dao.categorizeManualDataPoint(category, manualDataPoint);
        boolean found = false;
        List<ManualDataPoint> manualDataPoints = dao.selectManualDataPointsForCategory(category);
        for (ManualDataPoint mdp : manualDataPoints) {
            if (mdp.getId() == manualDataPoint.getId()) {
                found = true;
            }
        }
        Assert.assertEquals(true, found);

        // test deleting categorized mdp
        dao.deleteCategoryManualDataPointAssoc(new CategoryManualDataPointAssoc(category.getId(), manualDataPoint.getId()));
        found = false;
        manualDataPoints = dao.selectManualDataPointsForCategory(category);
        for (ManualDataPoint mdp : manualDataPoints) {
            if (mdp.getId() == manualDataPoint.getId()) {
                found = true;
            }
        }
        Assert.assertEquals(false, found);
    }


    private void testCategorizeReportTemplate(Category category, ReportTemplate reportTemplate) {
        MangoDAO dao = new MangoDAO();
        dao.categorizeReportTemplate(category, reportTemplate);
        boolean found = false;
        List<ReportTemplate> reportTemplatesFromDB = dao.selectReportTemplatesForCategory(category);
        for (ReportTemplate reportTemplateFromDB : reportTemplatesFromDB) {
//            System.out.println("reportTemplate.getId()" + reportTemplate.getId());
//            System.out.print("reportTemplateFromDB.getId()" + reportTemplateFromDB.getId());
            if (reportTemplate.getId().equals(reportTemplateFromDB.getId())) {
                System.out.println("Found");
                found = true;
            }
        }
        Assert.assertEquals(true, found);

        // test deleting categorized mdp
        dao.deleteCategoryReportTemplateAssoc(new CategoryReportTemplateAssoc(category.getId(), reportTemplate.getId()));
        found = false;
        reportTemplatesFromDB = dao.selectReportTemplatesForCategory(category);
        for (ReportTemplate reportTemplateFromDB : reportTemplatesFromDB) {
            if (reportTemplate.getId() == reportTemplateFromDB.getId()) {
                found = true;
            }
        }
        Assert.assertEquals(false, found);
    }

    private static Category getTestCategory() {
        Category category = new Category();
        category.setName("A test category");
        return category;
    }



    private static Sensor getTestSensor() {   // TODO: don't use a real sensor. create one just for this test.
        Sensor s = new Sensor();
        s.setId(169);
        return s;
    }

    private static ManualDataPoint getTestManualDataPoint() { //TODO: don't user real mdp.
        ManualDataPoint mdp = new ManualDataPoint();
        mdp.setId(1);
        return mdp;
    }

    private static ReportTemplate getTestReportTemplate() { //TODO: don't use real report_template.
        ReportTemplate rt = new ReportTemplate();
        rt.setId(133);
        return rt;
    }

}
