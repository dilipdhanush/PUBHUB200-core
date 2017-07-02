package com.revature.bookapp.modelDAO;

import org.springframework.jdbc.core.JdbcTemplate;

import com.dilip.bookapp.model.User;
import com.dilip.bookapp.util.ConnectionUtil;

public class UserDAO {
private JdbcTemplate jdbcTemplate= ConnectionUtil.getJdbcTemplate();

public void save(User user){
	String sql="insert into users(name,password) values(?,?)";
	Object[] args={user.getName(),user.getPassword()};
	int rows=jdbcTemplate.update(sql,args);
	System.out.println(rows);
}

public void delete(User user){
	String sql="delete from users where name=?";
	Object[] args={user.getName()};
	int rows=jdbcTemplate.update(sql,args);
	System.out.println(rows);
}
public void findbyId(User user) {
	String sql="select id,name,password from users where name=? and password=?";
	Object[] args={user.getName(),user.getPassword() };
	jdbcTemplate.queryForObject(sql, args,(rs,rowNum) -> {
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("id"));
		user.setId(rs.getInt("id"));
		return user;
	});
}
}
