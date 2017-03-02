package evolution.dao;

import java.util.List;

import evolution.entity.AnotherEntity;

public interface AnotherDao {
	public List<AnotherEntity> selectAll();
	
	public AnotherEntity selectById(int id);
	
	public void insert(AnotherEntity anotherEntity);
	
	public void update(AnotherEntity anotherEntity);
	
	public void delete(int id);
}
