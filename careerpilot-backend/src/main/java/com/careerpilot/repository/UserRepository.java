package com.careerpilot.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.careerpilot.model.User;

@Repository
public class UserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// Save User
	public int saveUser(User user) {

		String sql = "INSERT INTO users(full_name,email,phone,password,role) VALUES(?,?,?,?,?)";

		return jdbcTemplate.update(
				sql,
				user.getFullName(),
				user.getEmail(),
				user.getPhone(),
				user.getPassword(),
				user.getRole()
		);
	}

	// Find User By Email
	public User findByEmail(String email) {

		String sql = "SELECT * FROM users WHERE email=?";

		try {

			User user = jdbcTemplate.queryForObject(
					sql,
					(rs, rowNum) -> {

						User u = new User();

						u.setId(rs.getInt("id"));
						u.setFullName(rs.getString("full_name"));
						u.setEmail(rs.getString("email"));
						u.setPhone(rs.getString("phone"));
						u.setPassword(rs.getString("password"));
						u.setRole(rs.getString("role"));

						return u;
					},
					email);

			System.out.println("User Found: " + user.getEmail());

			return user;

		} catch (EmptyResultDataAccessException e) {

			System.out.println("User Not Found");

			return null;
		}
	}
}
