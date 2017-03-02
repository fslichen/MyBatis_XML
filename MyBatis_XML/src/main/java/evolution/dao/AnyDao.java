package evolution.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import evolution.entity.AnyEntity;

public class AnyDao {
	private SqlSessionFactory sqlSessionFactory = null;

	public AnyDao(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public List<AnyEntity> selectAll() {
		List<AnyEntity> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		try {// A try block can be followed by finally. 
			list = session.selectList("AnyEntity.selectAll");// Refer to <mapper namespace="AnyEntity"> in AnyEntity.xml
		} finally {
			session.close();
		}
		System.out.println("selectAll() --> " + list);
		return list;

	}

	public AnyEntity selectById(int id) {
		AnyEntity anyEntity = null;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			anyEntity = session.selectOne("AnyEntity.selectById", id);
		} finally {
			session.close();
		}
		System.out.println("selectById(" + id + ") --> " + anyEntity);
		return anyEntity;
	} 

	public int insert(AnyEntity anyEntity) {
		int id = -1;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			id = session.insert("AnyEntity.insert", anyEntity);
		} finally {
			session.commit();
			session.close();
		}
		System.out.println("insert(" + anyEntity + ") --> " + anyEntity.getId());
		return id;
	}

	public void update(AnyEntity anyEntity) {
		SqlSession session = sqlSessionFactory.openSession();
		int id = 0;
		try {
			id = session.update("AnyEntity.update", anyEntity);
		} finally {
			session.commit();
			session.close();
		}
		System.out.println("update(" + anyEntity + " " + id + ") --> updated");
	}

	public void delete(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.delete("AnyEntity.delete", id);
		} finally {
			session.commit();
			session.close();
		}
		System.out.println("delete(" + id + ")");
	}
}