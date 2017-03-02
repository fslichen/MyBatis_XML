package evolution;
 
import java.util.List;

import evolution.dao.AnyDao;
import evolution.entity.AnyEntity;
import evolution.service.AnyService;
 
public class Main {
    public static void main(String args[]){
        AnyDao anyDao = new AnyDao(AnyService.getSqlSessionFactory());
        AnyEntity anyEntity = new AnyEntity();
        anyEntity.setName("Entity 1");
        anyDao.insert(anyEntity);
        anyEntity.setName("Entity 2"); 
        int id = anyDao.insert(anyEntity);
        anyDao.selectById(id);
        List<AnyEntity> anyEntities = anyDao.selectAll();
        for(int i = 0; i < anyEntities.size(); i++){
        	anyEntities.get(i).setName("Entity Name "+i);
            anyDao.update(anyEntities.get(i));
        }
        anyEntities = anyDao.selectAll();
    }
}