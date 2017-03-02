package evolution.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import evolution.entity.TheOtherEntity;

public interface TheOtherDao {
	// @Param("name") corresponds to #{name} in theOtherEntity.xml
	public List<TheOtherEntity> selectByNameAndAge(@Param("name") String name, @Param("age") int age);
	
	// theOtherEntity.getName() corresponds to #{name} in theOtherEntity.xml
	public List<TheOtherEntity> selectByPojo(TheOtherEntity theOtherEntity);
	
	// queryMap.get("name") corresponds to #{name} in theOtherEntity.xml
	public List<TheOtherEntity> selectByMap(Map<String, Object> queryMap);
	
	public void insert(TheOtherEntity theOtherEntity);
}
