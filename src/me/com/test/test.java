package me.com.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import me.com.entity.user;
import me.com.util.MyBatisUtil;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class test {

    public static void main(String[] args) throws IOException {
        //mybatis的配置文件
        String resource = "conf.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = test.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource); 
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession(true);
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "me.com.mapping.userMapper.addUser";//映射sql的标识字符串
        user u = new user();
        u.setName("为什么成功");
        u.setAge(20);
        //执行查询返回一个唯一user对象的sql
        int result = session.insert(statement, u);
        
        
        System.out.println(result);
    }
    
    
    
    public void testAdd(){
    	//获取sqlSession对象
    	SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
    	//映射sql的标识字符串
    	String statement = "me.com.mappgin.userMapper.addUser";
    	//创建用户
    	user user = new user();
    	user.setName("吴忘成");
    	user.setAge(22);
    	//执行插入操作
    	int result = sqlSession.insert(statement,user);
    	//关闭SqlSession
    	sqlSession.close();
    	System.out.println(result);
    }
}