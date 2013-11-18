package dao;

import models.*;
import models.associations.ChartConfigurationDataPointAssoc;
import models.associations.ChartConfigurationManualDataPointAssoc;
import models.associations.ReportTemplateDataPointAssoc;
import models.associations.ReportTemplateManualDataPointAssoc;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.List;

public class MangoDAO {
	private static final String config = "dao/config.xml";
	private SqlSessionFactory factory;
	
	public MangoDAO() {
		try {
			InputStream input = Resources.getResourceAsStream(config);
			factory = new SqlSessionFactoryBuilder().build(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

    public UserPriv getLevel(User user) {
        SqlSession session = null;
        UserPriv userPriv;
        try {
            session = factory.openSession();
            userPriv = session.selectOne("dao.MangoMapper.selectLevel", user);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return userPriv;
    }
	
	public List<User> getUsers(){
		SqlSession session = null;
		List<User> users = null;
		try {
			session = factory.openSession();
			users = session.selectList("dao.MangoMapper.selectUsers");
		} finally {
			if (session != null){
				session.close();
			}
		}
		return users;
	}

    public User getUser(User user){
        SqlSession session = null;
        User userFromTable = null;
        try {
            session = factory.openSession();
            userFromTable = session.selectOne("dao.MangoMapper.selectUser", user);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return userFromTable;
    }

    public void insertUser(User user) {
        SqlSession session = null;
        try {
            session = factory.openSession();
            session.insert("dao.MangoMapper.insertUser", user);
            session.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateUserPass(User user) {
        SqlSession session = null;
        try {
            session = factory.openSession();
            session.update("dao.MangoMapper.updateUserPass", user);
            session.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
	
	public void deleteUser(User user){
		SqlSession session = null;
		try {
			session = factory.openSession();
			session.delete("dao.MangoMapper.deleteUser", user);
			session.commit();
		} finally {
			if (session != null){
				session.close();
			}
		}
	}
	
	public void createUser(User user){
		SqlSession session = null;
		try {
			session = factory.openSession();
			session.insert("dao.MangoMapper.createUser", user);
			session.commit();
		} finally {
			if (session != null){
				session.close();
			}
		}
	}

    public void updateLevel(UserPriv userPriv) {
        SqlSession session = null;
        try {
            session = factory.openSession();
            session.update("dao.MangoMapper.updatePrivilege", userPriv);
            session.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void insertManualData(ManualData manualData) {
        SqlSession session = null;
        try {
            session = factory.openSession();
            session.insert("dao.MangoMapper.insertManualData", manualData);
            session.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public ManualDataType selectManualDataType(ManualDataType manualDataType) {
        SqlSession session = null;
        ManualDataType tableManualDataType = null;
        try {
            session = factory.openSession();
            tableManualDataType = session.selectOne("dao.MangoMapper.selectManualDataType", manualDataType);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return tableManualDataType;
    }

    public List<String> selectManualDataTypes() {
        SqlSession session = null;
        List<String> manualDataTypes = null;
        try {
            session = factory.openSession();
            manualDataTypes = session.selectList("dao.MangoMapper.selectManualDataTypes");
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return manualDataTypes;
    }
	
	public List<Sensor> getSensors(){
		SqlSession session = null;
		List<Sensor> sensors = null;
		try {
			session = factory.openSession();
			sensors = session.selectList("dao.MangoMapper.selectSensors");
		} finally {
			if (session != null){
				session.close();
			}
		}
		return sensors;
	}
	
	public Sensor getSensor(int sensorId){
		SqlSession session = null;
		List<Sensor> sensors = null;
		try {
			session = factory.openSession();
			sensors = session.selectList("dao.MangoMapper.selectSensor", sensorId);
		} finally {
			if (session != null){
				session.close();
			}
		}
		return sensors != null ? sensors.get(0) : null;
	}
	
	public List<PointValue> getPointValues(SensorValueSelect sensor){
		SqlSession session = null;
		List<PointValue> pointValues = null;
		try {
			session = factory.openSession();
			pointValues = session.selectList("dao.MangoMapper.selectPointValues", sensor);
		} finally {
			if (session != null){
				session.close();
			}
		}
		return pointValues;
	}




    /** Manual Data Point Functions */

    public void insertManualDataPoint(ManualDataPoint manualDataPoint) {
        SqlSession session = null;
        try {
            session = factory.openSession();
            session.insert("dao.MangoMapper.insertManualDataPoint", manualDataPoint);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (session != null)
                session.close();
        }
    }

    public void insertManualDataPoint(String name) {
        insertManualDataPoint(new ManualDataPoint(name));
    }

    public void insertManualDataPointValue(ManualDataPointValue manualData) {
        SqlSession session = null;
        try {
            session = factory.openSession();
            session.insert("dao.MangoMapper.insertManualDataPointValue", manualData);
            session.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<ManualDataPoint> getManualDataPoints() {
        SqlSession session = null;
        List<ManualDataPoint> manualDataPoints = null;
        try {
            session = factory.openSession();
            manualDataPoints = session.selectList("dao.MangoMapper.selectManualDataPoints");
        } finally {
            if (session != null)
                session.close();
        }
        return manualDataPoints;
    }

    public List<ManualDataPointValue> getManualDataPointValuesForPointInRange(ManualDataPointValueRequest request) {
        SqlSession session = null;
        List<ManualDataPointValue> values = null;
        try {
            session = factory.openSession();
            values = session.selectList("dao.MangoMapper.selectManualDataPointValuesForPointInRange", request);
        } finally {
            if (session != null)
                session.close();
        }
        return values;
    }

    public void deleteManualDataPoint(int id) {
        SqlSession session = null;
        try {
            session = factory.openSession();
            session.delete("dao.MangoMapper.deleteManualDataPointById", id);
            session.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        finally {
            if (session != null)
                session.close();
        }
    }

    public void deleteManualDataPoint(String name) {
        SqlSession session = null;
        try {
            session = factory.openSession();
            session.delete("dao.MangoMapper.deleteManualDataPointByName", name);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (session != null)
                session.close();
        }
    }

    public List<ManualDataPointValue> getManualDataPointValuesForPointInRange(int manualDataPointId, BigInteger ts_start, BigInteger ts_end) {
        return getManualDataPointValuesForPointInRange(new ManualDataPointValueRequest(manualDataPointId, ts_start, ts_end));
    }


    public ManualDataPoint getManualDataPointByName(String name) {
        SqlSession session = null;
        ManualDataPoint pointFromDB = null;
        try {
            session = factory.openSession();
            pointFromDB =  session.selectOne("dao.MangoMapper.selectManualDataPointByName");
        } finally {
            if (session != null)
                session.close();
        }
        return pointFromDB;
    }




    public ReportTemplate getReportTemplateByName(String name) {
        SqlSession session = null;
        try {
            session = factory.openSession();
            ReportTemplate temp_reportTemplate = new ReportTemplate();
            temp_reportTemplate.setName(name);
            ReportTemplate templateFromDB = session.selectOne("dao.MangoMapper.getReportTemplateByName", temp_reportTemplate);

            List<ManualDataPoint> manualDataPoints = session.selectList("dao.MangoMapper.getManualDataPointsForReportTemplate", templateFromDB);
            templateFromDB.setManualData(manualDataPoints);

            List<Sensor> sensors = session.selectList("dao.MangoMapper.getDataPointsForReportTemplate", templateFromDB);
            templateFromDB.setSensors(sensors);

            List<ChartConfiguration> chartConfigurations = getChartConfigsForReportTemplateId(templateFromDB.getId());
            templateFromDB.setChartConfigurations(chartConfigurations);


            return templateFromDB;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (session != null)
                session.close();
        }
        return null;
    }



    public List<ChartConfiguration> getChartConfigsForReportTemplateId(int reportTemplateId) {
        SqlSession session = null;
        List<ChartConfiguration> chartConfigs = null;
        try {
            session = factory.openSession();
            chartConfigs = session.selectList("dao.MangoMapper.getChartConfigurationByReportTemplateId", reportTemplateId);

            for (ChartConfiguration chartConfig : chartConfigs) {
                List<Sensor> sensors  = session.selectList("dao.MangoMapper.getSensorsForChartConfig", chartConfig.getId());
                chartConfig.setSensors(sensors);
                List<ManualDataPoint> manualDataPoints = session.selectList("dao.MangoMapper.getManualDataPointsForChartConfig", chartConfig.getId());
                chartConfig.setManualData(manualDataPoints);
            }


        } finally {
            if (session != null)
                session.close();
        }
        return chartConfigs;
    }


    public void deleteChartConfiguration(int id) {
        SqlSession session = null;
        try {
            session = factory.openSession();
            session.delete("dao.MangoMapper.deleteChartConfigurationById", id);
        } finally {
            if (session != null)
                session.close();
        }
    }

    public void deleteChartConfiguration(String name) {
        SqlSession session = null;
        try {
            session = factory.openSession();
            session.delete("dao.MangoMapper.deleteChartConfigurationByName", name);
        } finally {
            if (session != null)
                session.close();
        }
    }


    /**
     * Deletes all chart configurations for the corresponding report.
     * @param id A report id.
     */
    public void deleteChartConfigurationsForReport(int id) {
        SqlSession session = null;
        try {
            session = factory.openSession();
            session.delete("dao.MangoMapper.deleteChartConfigurationForReport", id);
        } finally {
            if (session != null)
                session.close();
        }
    }





    /** Report template functions */
    public List<ReportTemplate> getAllReportTemplates() {
        SqlSession session = null;
        List<ReportTemplate> reportTemplates = null;
        try {
            session = factory.openSession();
            reportTemplates =  session.selectList("dao.MangoMapper.selectReportTemplates");
            return fillInReportTemplates(reportTemplates);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }
        return null;
    }

    /**
     * Fills in the report templates with sensors, manual data points, and chart configurations.
     * @param templates A list of ReportTemplate with only their id, name, and description.
     * @return
     */
    private List<ReportTemplate> fillInReportTemplates(List<ReportTemplate> templates) {
        for (ReportTemplate reportTemplate : templates) {
            reportTemplate = fillInReportTemplate(reportTemplate);
        }
        return templates;
    }

    private ReportTemplate fillInReportTemplate(ReportTemplate reportTemplate) {
        SqlSession session = null;
        try {
            session = factory.openSession();

            List<ManualDataPoint> manualDataPoints = session.selectList("dao.MangoMapper.getManualDataPointsForReportTemplate", reportTemplate);
            reportTemplate.setManualData(manualDataPoints);

            List<Sensor> sensors = session.selectList("dao.MangoMapper.getDataPointsForReportTemplate", reportTemplate);
            reportTemplate.setSensors(sensors);

            List<ChartConfiguration> chartConfigurations = getChartConfigsForReportTemplateId(reportTemplate.getId());
            reportTemplate.setChartConfigurations(chartConfigurations);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }
        return reportTemplate;
    }



    public void createReportTemplate(ReportTemplate reportTemplate) {

        SqlSession session = null;
        try {
            session = factory.openSession();
            session.insert("dao.MangoMapper.createReportTemplate", reportTemplate);
            session.commit();
            reportTemplate.setId( ((ReportTemplate) session.selectOne("dao.MangoMapper.getReportTemplateByName", reportTemplate)).getId() );

            // Sensor Associations.
            if (reportTemplate.getSensors() != null) {
                for (Sensor s: reportTemplate.getSensors()) { // (dataPoints)
                    session.insert("dao.MangoMapper.createReportTemplateDataPointAssoc", new ReportTemplateDataPointAssoc(reportTemplate.getId(), s.getId()));
                }
            }

            // Manudal Data Points Associations.
            if (reportTemplate.getManualData() != null) {
                for (ManualDataPoint mdp : reportTemplate.getManualData()) {
                    session.insert("dao.MangoMapper.createReportTemplateManualDataPointAssoc", new ReportTemplateManualDataPointAssoc(reportTemplate.getId(), mdp.getId()));
                }
            }

            for (ChartConfiguration chartConfig: reportTemplate.getChartConfigurations()) {
                chartConfig.setReportTemplateId(reportTemplate.getId());
                insertChartConfiguration(chartConfig);
            }
            session.commit();
        }
        catch (Exception e) {
            e.printStackTrace();

        }
        finally {
            if (session != null){
                session.close();
            }
        }
    }

    public void insertChartConfiguration(ChartConfiguration chartConfig) {
        SqlSession session = null;
        try {
            session = factory.openSession();
            session.insert("dao.MangoMapper.insertChartConfiguration", chartConfig);
            session.commit();
            chartConfig.setId( ((ChartConfiguration) session.selectOne("dao.MangoMapper.getChartConfigurationByName", chartConfig.getName())).getId());

            // Sensor Assocs
            for (Sensor s : chartConfig.getSensors()) {
                session.insert("dao.MangoMapper.insertChartConfigurationDataPointAssoc", new ChartConfigurationDataPointAssoc(chartConfig.getId(), s.getId()));
            }

            // Manual Data Assocs
            for (ManualDataPoint mdp : chartConfig.getManualData()) {
                session.insert("dao.MangoMapper.insertChartConfigurationManualDataPointAssoc", new ChartConfigurationManualDataPointAssoc(chartConfig.getId(), mdp.getId()));
            }

            // Equations
            //TODO

            session.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }
    }




    //TODO: FOR TESTING ONLY.
    public void deleteAllReportTemplates() {
        SqlSession session = null;
        List<Sensor> sensors = null;
        try {
            session = factory.openSession();
            session.delete("deleteAllChartConfigDataPointAssoc");
            session.delete("deleteAllChartConfigManualDataPointAssoc");
            session.delete("deleteAllChartConfiguraitons");
            session.delete("deleteAllreportTemplateManualDataPointAssoc");
            session.delete("deleteAllReportTemplateDataPointAssoc");
            session.delete("deleteAllReportTemplates");
            session.commit();
        } finally {
            if (session != null){
                session.close();
            }
        }

    }


    public void insertCategory(String categoryName) {
        SqlSession session = null;
        try {
            session = factory.openSession();
            session.insert("dao.MangoMapper.insertCategory", categoryName);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }
    }

    public void deleteCategory(String categoryName) {
        SqlSession session = null;
        try {
            session = factory.openSession();
            session.delete("dao.MangoMapper.deleteCategoryByName", categoryName);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }
    }

    public List<Category> selectCategories() {
        SqlSession session = null;
        List<Category> categories = null;
        try {
            session = factory.openSession();
            categories = session.selectList("dao.MangoMapper.selectCategories");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }
        return categories;
    }

    public void categorizeDataPoint(Category category, Sensor dataPoint) {


    }

//    public void categorizeManualDataPoint(Category category, ManualDataPoint manualDataPoint) {}

    public void categorizeReportTemplate(int reportTemplateId) {}
	
}
