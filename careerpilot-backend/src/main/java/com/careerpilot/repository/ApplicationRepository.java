package com.careerpilot.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.careerpilot.model.Application;

@Repository
public class ApplicationRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// Add Application
	public int saveApplication(Application application) {

		String sql = """
				INSERT INTO applications
				(user_id, company_name, job_role,
				location, package_offered,
				application_url, applied_date, status)
				VALUES(?,?,?,?,?,?,?,?)
				""";

		return jdbcTemplate.update(
				sql,
				application.getUserId(),
				application.getCompanyName(),
				application.getJobRole(),
				application.getLocation(),
				application.getPackageOffered(),
				application.getApplicationUrl(),
				application.getAppliedDate(),
				application.getStatus());
	}

	// View Applications By User
	public List<Application> getApplicationsByUserId(int userId) {

		String sql = "SELECT * FROM applications WHERE user_id=?";

		return jdbcTemplate.query(
				sql,
				(rs, rowNum) -> {

					Application app = new Application();

					app.setId(rs.getInt("id"));
					app.setUserId(rs.getInt("user_id"));
					app.setCompanyName(rs.getString("company_name"));
					app.setJobRole(rs.getString("job_role"));
					app.setLocation(rs.getString("location"));
					app.setPackageOffered(rs.getString("package_offered"));
					app.setApplicationUrl(rs.getString("application_url"));
					app.setAppliedDate(rs.getDate("applied_date"));
					app.setStatus(rs.getString("status"));

					return app;
				},
				userId);
	}

	// Update Application Status
	public int updateStatus(int applicationId, String status) {

		String sql =
				"UPDATE applications SET status=? WHERE id=?";

		return jdbcTemplate.update(
				sql,
				status,
				applicationId);
	}

	// Delete Application
	public int deleteApplication(int applicationId) {

		String sql =
				"DELETE FROM applications WHERE id=?";

		return jdbcTemplate.update(
				sql,
				applicationId);
	}
	// Search Applications By Company
	public List<Application> searchByCompany(
			String companyName) {

		String sql =
				"SELECT * FROM applications WHERE company_name LIKE ?";

		return jdbcTemplate.query(
				sql,
				(rs, rowNum) -> {

					Application app =
							new Application();

					app.setId(rs.getInt("id"));
					app.setUserId(rs.getInt("user_id"));
					app.setCompanyName(rs.getString("company_name"));
					app.setJobRole(rs.getString("job_role"));
					app.setLocation(rs.getString("location"));
					app.setPackageOffered(rs.getString("package_offered"));
					app.setApplicationUrl(rs.getString("application_url"));
					app.setAppliedDate(rs.getDate("applied_date"));
					app.setStatus(rs.getString("status"));

					return app;
				},
				"%" + companyName + "%");
	}
}