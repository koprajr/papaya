package dao;

import models.ManualDataPoint;
import models.User;
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
	
}
