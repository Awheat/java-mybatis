package me.com.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import me.com.entity.user;

//接口:基于注解
public interface UserMapperI {
	
	/* 说明:我们不需要针对UserMapperI接口去编写具体的实现类代码，这个具体的实现类由MyBatis帮我们动态构建出来.*/
	
	
	//使用@Select注解指明getUserById方法要执行的SQL
	@Select("select * from users where id=#{id}")
	public user getUserById(int id);
	
	//使用@Select注解指明getAllUser方法要执行的SQL
	@Select("select * from users")
	public List<user> getAllUser();
	
	//使用@Select注解指明addUser方法要执行的SQL
	@Insert("insert into users(name, age) values(#{name}, #{age})")
	public int addUser(user u);
	
	//使用@Select注解指明deleteUser方法要执行的SQL
	@Delete("delete from users where id=#{id}")
	public int deleteUser(int id);
	
	//使用@Select注解指明updateUser方法要执行的SQL
	@Update("update users set name=#{name},age=#{age} where id=#{id}")
	public int updateUser(user u);
	
	
}
