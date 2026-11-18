package com.careerpilot.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.careerpilot.model.Interview;

@Repository
public class InterviewRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// Schedule Interview
	public int saveInterview(Interview interview) {

		String sql = """
				INSERT INTO interviews
				(user_id, company_name,
				round_name, interview_date,
				interview_time, meeting_link,
				status, feedback)
				VALUES(?,?,?,?,?,?,?,?)
				""";

		return jdbcTemplate.update(
				sql,
				interview.getUserId(),
				interview.getCompanyName(),
				interview.getRoundName(),
				interview.getInterviewDate(),
				interview.getInterviewTime(),
				interview.getMeetingLink(),
				interview.getStatus(),
				interview.getFeedback());
	}

	// View Interviews
	public List<Interview> getInterviewsByUserId(int userId) {

		String sql = "SELECT * FROM interviews WHERE user_id=?";

		return jdbcTemplate.query(
				sql,
				(rs, rowNum) -> {

					Interview interview = new Interview();

					interview.setId(rs.getInt("id"));
					interview.setUserId(rs.getInt("user_id"));
					interview.setCompanyName(rs.getString("company_name"));
					interview.setRoundName(rs.getString("round_name"));
					interview.setInterviewDate(rs.getDate("interview_date"));
					interview.setInterviewTime(rs.getTime("interview_time"));
					interview.setMeetingLink(rs.getString("meeting_link"));
					interview.setStatus(rs.getString("status"));
					interview.setFeedback(rs.getString("feedback"));

					return interview;
				},
				userId);
	}

	// Update Interview Status
	public int updateInterviewStatus(
			int interviewId,
			String status) {

		String sql =
				"UPDATE interviews SET status=? WHERE id=?";

		return jdbcTemplate.update(
				sql,
				status,
				interviewId);
	}

	// Update Feedback
	public int updateFeedback(
			int interviewId,
			String feedback) {

		String sql =
				"UPDATE interviews SET feedback=? WHERE id=?";

		return jdbcTemplate.update(
				sql,
				feedback,
				interviewId);
	}
	// Search Interviews By Company
	public List<Interview> searchByCompany(
			String companyName) {

		String sql =
				"SELECT * FROM interviews WHERE company_name LIKE ?";

		return jdbcTemplate.query(
				sql,
				(rs, rowNum) -> {

					Interview interview =
							new Interview();

					interview.setId(
							rs.getInt("id"));

					interview.setUserId(
							rs.getInt("user_id"));

					interview.setCompanyName(
							rs.getString("company_name"));

					interview.setRoundName(
							rs.getString("round_name"));

					interview.setInterviewDate(
							rs.getDate("interview_date"));

					interview.setInterviewTime(
							rs.getTime("interview_time"));

					interview.setMeetingLink(
							rs.getString("meeting_link"));

					interview.setStatus(
							rs.getString("status"));

					interview.setFeedback(
							rs.getString("feedback"));

					return interview;

				},
				"%" + companyName + "%");
	}
}