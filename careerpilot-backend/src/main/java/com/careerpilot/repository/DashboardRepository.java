package com.careerpilot.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.careerpilot.model.DashboardStats;

@Repository
public class DashboardRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public DashboardStats getDashboardStats(int userId) {

		DashboardStats stats =
				new DashboardStats();

		Integer totalApplications =
				jdbcTemplate.queryForObject(
						"SELECT COUNT(*) FROM applications WHERE user_id=?",
						Integer.class,
						userId);

		stats.setTotalApplications(
				totalApplications);

		Integer selectedApplications =
				jdbcTemplate.queryForObject(
						"SELECT COUNT(*) FROM applications WHERE user_id=? AND status='Selected'",
						Integer.class,
						userId);

		stats.setSelectedApplications(
				selectedApplications);

		Integer rejectedApplications =
				jdbcTemplate.queryForObject(
						"SELECT COUNT(*) FROM applications WHERE user_id=? AND status='Rejected'",
						Integer.class,
						userId);

		stats.setRejectedApplications(
				rejectedApplications);

		stats.setPendingApplications(
				totalApplications
				- selectedApplications
				- rejectedApplications);

		Integer totalInterviews =
				jdbcTemplate.queryForObject(
						"SELECT COUNT(*) FROM interviews WHERE user_id=?",
						Integer.class,
						userId);

		stats.setTotalInterviews(
				totalInterviews);

		// ATS Analysis Count

		Integer totalResumeAnalyses =
				jdbcTemplate.queryForObject(
						"SELECT COUNT(*) FROM ats_analysis",
						Integer.class);

		stats.setTotalResumeAnalyses(
				totalResumeAnalyses);

		// ATS Average Score

		Integer averageAtsScore =
				jdbcTemplate.queryForObject(
						"SELECT IFNULL(AVG(ats_score),0) FROM ats_analysis",
						Integer.class);

		stats.setAverageAtsScore(
				averageAtsScore);

		return stats;
	}
}