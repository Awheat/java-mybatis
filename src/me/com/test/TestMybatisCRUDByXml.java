package me.com.test;

import static org.junit.Assert.*;

import java.util.List;

import me.com.entity.user;
import me.com.util.MyBatisUtil;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

//基于xml的单元测试
public class TestMybatisCRUDByXml {
	
	@Test
	public void testAdd(){
		//获取sqlSession对象
    	SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
    	//映射sql的标识字符串
    	String statement = "me.com.mapping.userMapper.addUser";
    	//创建用户
    	user u = new user();
    	u.setName("这次应该没问题吧");
    	u.setAge(22);
    	//执行插入操作
    	int result = sqlSession.insert(statement, u);
    	//关闭SqlSession
    	sqlSession.close();
    	//打印结果
    	System.out.println(result);
	}
	
	@Test
	public void testUpdate(){
		//获取sqlSession对象
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		//映射sql表示字符串
		String statement = "me.com.mapping.userMapper.updateUser";
		//创建user对象
		user u = new user();
		u.setId(2);
		u.setName("蓝天白云");
		u.setAge(30);
		//执行更新操作
		int result = sqlSession.update(statement,u);
		//关闭sqlSession
		sqlSession.close();
		//打印结果
		System.out.println(result);
	}
	
	@Test
	public void testDelete(){
		//获取sqlSession对象
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		//映射sql表示字符串
		String statement = "me.com.mapping.userMapper.deleteUser";
		//执行删除操作
		int result = sqlSession.delete(statement,3);
		//关闭sqlSession
		sqlSession.close();
		//打印结果
		System.out.println(result);
	}
	
	@Test
	public void testGetAll(){
		//获取sqlSession对象
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		//映射sql表示字符串
		String statement = "me.com.mapping.userMapper.getAllUsers";
		//执行查询操作
		List<user> users = sqlSession.selectList(statement);
		//关闭sqlSession
		sqlSession.close();
		//打印结果
		System.out.println(users);
	}
	
	@Test
	public void testGetUserById(){
		//获取sqlSession对象
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		//映射sql表示字符串
		String statement = "me.com.mapping.userMapper.getUser";
		//执行查询操作
		user u = sqlSession.selectOne(statement,5);
		//关闭sqlSession
		sqlSession.close();
		//打印结果
		System.out.println(u);
	}
	
}
