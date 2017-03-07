package me.com.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 
 * @author wuwc by 2017-03-07
 *
 */
public class MyBatisUtil {
	/***
	 * 
	 * 获取SqlSessionFactory对象
	 * @return SqlSessionFactory
	 */
	public static SqlSessionFactory getSqlSessionFactory(){
		//1.获得mybatis的配置文件
		String resource = "conf.xml";
		//2.通过类就加载器加载mybatis的xml配置文件
		InputStream inputStream = MyBatisUtil.class.getClassLoader().getResourceAsStream(resource);
		//3.创建SqlSession的工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		
		return factory;
	}
	
	/***
	 * 
	 * 获取SqlSession
	 * @return SqlSession
	 */
	public static SqlSession getSqlSession(){
		return getSqlSessionFactory().openSession();
	}
	
	/***
	 * 
	 * 获取SqlSession
	 * @param isAutoCommit
	 * 		  true: 表示创建的SqlSession对象在执行完SQL之后会自动提交事务
	 * 		  false: 表示创建的SqlSession对象在执行完SQL之后不会自动提交事务，这时就需要我们手动调用sqlSession.commit()提交事务
	 * @return SqlSession
	 */
	public static SqlSession getSqlSession(boolean isAutoCommit){
		return getSqlSessionFactory().openSession(isAutoCommit);
	}
}
