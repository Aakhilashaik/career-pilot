package com.careerpilot.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.careerpilot.model.JobDescription;

@Repository
public class JobDescriptionRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int saveJobDescription(
			JobDescription jobDescription) {

		String sql =
				"INSERT INTO job_descriptions(user_id,company_name,job_role,description) VALUES(?,?,?,?)";

		return jdbcTemplate.update(
				sql,
				jobDescription.getUserId(),
				jobDescription.getCompanyName(),
				jobDescription.getJobRole(),
				jobDescription.getDescription());
	}
}