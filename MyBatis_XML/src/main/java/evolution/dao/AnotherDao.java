package evolution.dao;

import java.util.List;

import evolution.entity.AnotherEntity;

// You only need to provide an interface. 
// No implementation is needed because MyBatis's auto proxy functionality takes care of that. 
// Make sure that evolution.dao.AnotherDao is provided as namespace in anotherEntity.xml
public interface AnotherDao {
	// Make sure that selectAll is provided as id in <select> under anotherEntity.xml
	public List<AnotherEntity> selectAll();
	
	public AnotherEntity selectById(int id);
	
	public void insert(AnotherEntity anotherEntity);
	
	public void update(AnotherEntity anotherEntity);
	
	public void delete(int id);
}
