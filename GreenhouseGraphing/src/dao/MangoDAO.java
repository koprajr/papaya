package dao;

import models.*;
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

    public void insertManualDataType(ManualDataType manualDataType) {
        SqlSession session = null;
        try {
            session = factory.openSession();
            session.insert("dao.MangoMapper.insertManualDataType", manualDataType);
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

    public List<String> selectCategories() {
        SqlSession session = null;
        List<String> categories = null;
        try {
            session = factory.openSession();
            categories = session.selectList("dao.MangoMapper.selectCategories");
        } finally {
            if (session != null){
                session.close();
            }
        }
        return categories;
    }

    public Category selectCategory(Category category) {
        SqlSession session = null;
        Category categoryFromTable = null;
        try {
            session = factory.openSession();
            categoryFromTable = session.selectOne("dao.MangoMapper.selectCategory", category);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return categoryFromTable;
    }

    public ReportTemplate selectReportTemplate(ReportTemplate reportTemplate) {
        SqlSession session = null;
        ReportTemplate reportTemplateFromTable = null;
        try {
            session = factory.openSession();
            reportTemplateFromTable = session.selectOne("dao.MangoMapper.selectReportTemplate", reportTemplate);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return reportTemplateFromTable;
    }

    public void insertCategoryManualData(CategoryHelper categoryHelper) {
        SqlSession session = null;
        try {
            session = factory.openSession();
            session.insert("dao.MangoMapper.insertCategoryManualData", categoryHelper);
            session.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void insertCategoryReportTemplate(CategoryHelper categoryHelper) {
        SqlSession session = null;
        try {
            session = factory.openSession();
            session.insert("dao.MangoMapper.insertCategoryReportTemplate", categoryHelper);
            session.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public CategoryHelper selectCategoryManualData(CategoryHelper categoryHelper) {
        SqlSession session = null;
        CategoryHelper tableCategoryHelper = null;
        try {
            session = factory.openSession();
            tableCategoryHelper = session.selectOne("dao.MangoMapper.selectCategoryManualData", categoryHelper);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return tableCategoryHelper;

    }

    public CategoryHelper selectCategoryReportTemplate(CategoryHelper categoryHelper) {
        SqlSession session = null;
        CategoryHelper tableCategoryHelper = null;
        try {
            session = factory.openSession();
            tableCategoryHelper = session.selectOne("dao.MangoMapper.selectCategoryReportTemplate", categoryHelper);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return tableCategoryHelper;

    }


}
