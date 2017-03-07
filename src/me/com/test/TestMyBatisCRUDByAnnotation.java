package me.com.test;

import static org.junit.Assert.*;

import java.util.List;

import me.com.entity.user;
import me.com.mapping.UserMapperI;
import me.com.util.MyBatisUtil;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

//基于注解的单元测试
public class TestMyBatisCRUDByAnnotation {

	@Test
	public void testAdd(){
		//获取sqlSession对象
    	SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
    	//得到UserMapperI接口的实现类对象
    	UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
    	//创建用户
    	user u = new user();
    	u.setName("这次应该没问题吧");
    	u.setAge(22);
    	//执行插入操作
    	int result = mapper.addUser(u);
    	//关闭SqlSession
    	sqlSession.close();
    	//打印结果
    	System.out.println(result);
	}
	
	@Test
	public void testUpdate(){
		//获取sqlSession对象
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		//得到UserMapperI接口的实现类对象
    	UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
		//创建user对象
		user u = new user();
		u.setId(2);
		u.setName("蓝天白云");
		u.setAge(30);
		//执行更新操作
		int result = mapper.updateUser(u);
		//关闭sqlSession
		sqlSession.close();
		//打印结果
		System.out.println(result);
	}
	
	@Test
	public void testDelete(){
		//获取sqlSession对象
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		//得到UserMapperI接口的实现类对象
    	UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
		//执行删除操作
		int result = mapper.deleteUser(3);
		//关闭sqlSession
		sqlSession.close();
		//打印结果
		System.out.println(result);
	}
	
	@Test
	public void testGetAll(){
		//获取sqlSession对象
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		//得到UserMapperI接口的实现类对象
    	UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
		//执行查询操作
		List<user> users = mapper.getAllUser();
		//关闭sqlSession
		sqlSession.close();
		//打印结果
		System.out.println(users);
	}
	
	@Test
	public void testGetUserById(){
		//获取sqlSession对象
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		//得到UserMapperI接口的实现类对象
    	UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
		//执行查询操作
		user u = mapper.getUserById(5);
		//关闭sqlSession
		sqlSession.close();
		//打印结果
		System.out.println(u);
	}

}
