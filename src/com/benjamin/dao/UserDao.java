package com.benjamin.dao;

import com.benjamin.entity.User;

public class UserDao extends BasicDao {
	public User get(Integer id) {
		String sql = "SELECT * FROM user WHERE id = ?";
		User user = new User();
		try {
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, id);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setAge(resultSet.getInt("age"));
				user.setTelephone(resultSet.getString("telephone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.closeAll();
		}
		return user;
	}
}
