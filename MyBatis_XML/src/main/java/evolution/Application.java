package evolution;
 
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import evolution.dao.AnotherDao;
import evolution.dao.AnyDaoImpl;
import evolution.entity.AnotherEntity;
import evolution.entity.AnyEntity;
import evolution.service.AnyService;
 
public class Application {
	@Test
    public void testNonAutoProxy() {
        // Create AnyDaoImpl.
		AnyDaoImpl anyDaoImpl = new AnyDaoImpl(AnyService.getSqlSessionFactory());
        // Insert
		anyDaoImpl.insert(new AnyEntity("Entity Name 0"));
        anyDaoImpl.insert(new AnyEntity("Entity Name 1"));
        // Select
        anyDaoImpl.selectById(1);
        List<AnyEntity> anyEntities = anyDaoImpl.selectAll();
        // Update
        for (int i = 0; i < anyEntities.size(); i++) {
        	anyEntities.get(i).setName("Entity Name " + i);
        	anyDaoImpl.update(anyEntities.get(i));
        }
        anyEntities = anyDaoImpl.selectAll();
    }

	@Test
	public void testAutoProxy() {// This method is recommended by MyBatis team.
		// Get session.
		SqlSession session = AnyService.getSqlSessionFactory().openSession();
		AnotherDao anotherDao = session.getMapper(AnotherDao.class);
		// Insert
		anotherDao.insert(new AnotherEntity("Chen"));
		session.commit();
		// Select
		AnotherEntity anotherEntity = anotherDao.selectById(1);
		System.out.println(anotherEntity);
		// Update
		anotherEntity.setName("Ling");
		anotherDao.update(anotherEntity);
		List<AnotherEntity> anotherEntities = anotherDao.selectAll();
		System.out.println(anotherEntities);
		session.commit();
	}
}