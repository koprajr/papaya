package dao;

import models.Sensor;
import models.User;
import models.UserPriv;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
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

    public ReportTemplate getReportTemplateByName(String name) {
        SqlSession session = null;
        try {
            session = factory.openSession();
            ReportTemplate temp_reportTemplate = new ReportTemplate();
            temp_reportTemplate.setName(name);
            ReportTemplate templateFromDB = session.selectOne("dao.MangoMapper.getReportTemplateByName", temp_reportTemplate);

            List<ManualDataPoint> manualDataPoints = session.selectList("dao.MangoMapper.getManualDataPointsForReportTemplate", templateFromDB);
            templateFromDB.setManualDataPoint(new HashSet<ManualDataPoint>(manualDataPoints));

            List<Sensor> sensors = session.selectList("dao.MangoMapper.getDataPointsForReportTemplate", templateFromDB);
            templateFromDB.setIndividualSensors(new HashSet<Sensor>(sensors));

          //TODO:  templateFromDB.setChartConfigurations();


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



    public void createReportTemplate(ReportTemplate reportTemplate) {
        // insert into reportTemplate: name, description
        // insert into reportTemplateSensorAssociation: every sensor, equation, and manualData
        // insert into chartConfiguartions: each chart configuration

        SqlSession session = null;
        try {
            session = factory.openSession();
            session.insert("dao.MangoMapper.createReportTemplate", reportTemplate);
            session.commit();
            reportTemplate.setId( ((ReportTemplate) session.selectOne("dao.MangoMapper.getReportTemplateByName", reportTemplate)).getId() );

            // Sensor Associations.
            for (Sensor s: reportTemplate.getIndividualSensors()) { // (dataPoints)
                session.insert("dao.MangoMapper.createReportTemplateDataPointAssoc", new ReportTemplateDataPointAssoc(reportTemplate.getId(), s.getId()));
            }

            // Manudal Data Points Associations.
            for (ManualDataPoint mdp : reportTemplate.getManualDataPoint()) {
                session.insert("dao.MangoMapper.createReportTemplateManualDataPointAssoc", new ReportTemplateManualDataPointAssoc(reportTemplate.getId(), mdp.getId()));
            }

            // TODO: store chart configs.
            // Create chart configurations


//            //
//            for (ChartConfiguration chartConfig : reportTemplate.getChartConfigurations()) {
//                session.insert("dao.MangoMapper.createReportTemplateChartConfigurationsAssoc", chartConfig);
//            }



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


               //TODO
//    public List<ReportTemplate> getAllReportTemplates() {
//
//    }




    //TODO: FOR TESTING ONLY.
    public void deleteAllReportTemplates() {
        SqlSession session = null;
        List<Sensor> sensors = null;
        try {
            session = factory.openSession();
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







	
}
