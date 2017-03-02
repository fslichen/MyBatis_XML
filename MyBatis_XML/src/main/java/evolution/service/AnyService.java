package evolution.service;
 
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
 
public class AnyService {
    private static SqlSessionFactory sqlSessionFactory;
 
    private AnyService() {// Create a private constructor to make it a singleton.
    	
    }
    
    static {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis.xml");// Read mybatis.xml from resources.
            if (sqlSessionFactory == null) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
    
    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}