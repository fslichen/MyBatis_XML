package evolution.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import evolution.entity.TheOtherEntity;

public interface TheOtherDao {
	public List<TheOtherEntity> selectByNameAndAge(@Param("name") String name, @Param("age") int age);
	
	public List<TheOtherEntity> selectByPojo(TheOtherEntity theOtherEntity);
	
	public void insert(TheOtherEntity theOtherEntity);
}
