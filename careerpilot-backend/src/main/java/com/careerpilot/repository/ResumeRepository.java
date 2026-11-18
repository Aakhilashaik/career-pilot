package com.careerpilot.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.careerpilot.model.Resume;

@Repository
public class ResumeRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int saveResume(Resume resume) {

		String sql =
				"INSERT INTO resumes(user_id,resume_name,file_path,version_number) VALUES(?,?,?,?)";

		return jdbcTemplate.update(
				sql,
				resume.getUserId(),
				resume.getResumeName(),
				resume.getFilePath(),
				resume.getVersionNumber());
	}

	public List<Resume> getResumesByUserId(
			int userId) {

		String sql =
				"SELECT * FROM resumes WHERE user_id=?";

		return jdbcTemplate.query(
				sql,
				(rs, rowNum) -> {

					Resume resume =
							new Resume();

					resume.setId(
							rs.getInt("id"));

					resume.setUserId(
							rs.getInt("user_id"));

					resume.setResumeName(
							rs.getString("resume_name"));

					resume.setFilePath(
							rs.getString("file_path"));

					resume.setUploadedAt(
							rs.getTimestamp("uploaded_at"));

					resume.setVersionNumber(
							rs.getInt("version_number"));

					return resume;

				},
				userId);
	}
}