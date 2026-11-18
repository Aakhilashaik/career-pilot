package com.careerpilot.repository;

import java.util.List;
import com.careerpilot.model.AtsLeaderboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.careerpilot.model.AtsAnalysis;
import com.careerpilot.model.AtsComparison;

@Repository
public class AtsAnalysisRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int saveAnalysis(AtsAnalysis analysis) {

		String sql =
				"INSERT INTO ats_analysis(resume_id,job_description_id,ats_score,matched_keywords,missing_keywords,recruiter_feedback) VALUES(?,?,?,?,?,?)";

		return jdbcTemplate.update(
				sql,
				analysis.getResumeId(),
				analysis.getJobDescriptionId(),
				analysis.getAtsScore(),
				analysis.getMatchedKeywords(),
				analysis.getMissingKeywords(),
				analysis.getRecruiterFeedback());
	}

	public List<AtsAnalysis> getAllAnalysis() {

		String sql = "SELECT * FROM ats_analysis";

		return jdbcTemplate.query(
				sql,
				(rs, rowNum) -> {

					AtsAnalysis analysis =
							new AtsAnalysis();

					analysis.setId(
							rs.getInt("id"));

					analysis.setResumeId(
							rs.getInt("resume_id"));

					analysis.setJobDescriptionId(
							rs.getInt("job_description_id"));

					analysis.setAtsScore(
							rs.getInt("ats_score"));

					analysis.setMatchedKeywords(
							rs.getString("matched_keywords"));

					analysis.setMissingKeywords(
							rs.getString("missing_keywords"));

					analysis.setRecruiterFeedback(
							rs.getString("recruiter_feedback"));

					return analysis;
				});
	}
	public List<AtsComparison> compareScores() {

		String sql =
				"SELECT resume_id, ats_score FROM ats_analysis";

		return jdbcTemplate.query(
				sql,
				(rs, rowNum) -> {

					AtsComparison comparison =
							new AtsComparison();

					comparison.setResumeId(
							rs.getInt("resume_id"));

					comparison.setAtsScore(
							rs.getInt("ats_score"));

					return comparison;
				});
	}
	public AtsLeaderboard getBestResume() {

		String sql =
				"""
				SELECT resume_id,
				ats_score
				FROM ats_analysis
				ORDER BY ats_score DESC
				LIMIT 1
				""";

		return jdbcTemplate.queryForObject(
				sql,
				(rs, rowNum) -> {

					AtsLeaderboard leader =
							new AtsLeaderboard();

					leader.setResumeId(
							rs.getInt("resume_id"));

					leader.setAtsScore(
							rs.getInt("ats_score"));

					return leader;
				});
	}
}