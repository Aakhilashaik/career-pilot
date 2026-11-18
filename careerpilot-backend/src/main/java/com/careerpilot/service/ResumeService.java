package com.careerpilot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careerpilot.model.Resume;
import com.careerpilot.repository.ResumeRepository;

@Service
public class ResumeService {

	@Autowired
	private ResumeRepository resumeRepository;

	public String saveResume(Resume resume) {

		int result =
				resumeRepository.saveResume(resume);

		if(result > 0) {
			return "Resume Saved Successfully";
		}

		return "Resume Save Failed";
	}

	public List<Resume> getResumesByUserId(
			int userId) {

		return resumeRepository
				.getResumesByUserId(userId);
	}
}