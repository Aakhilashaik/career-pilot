package com.careerpilot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careerpilot.model.JobDescription;
import com.careerpilot.repository.JobDescriptionRepository;

@Service
public class JobDescriptionService {

	@Autowired
	private JobDescriptionRepository repository;

	public String saveJobDescription(
			JobDescription jobDescription) {

		int result =
				repository.saveJobDescription(
						jobDescription);

		if(result > 0) {
			return "Job Description Saved Successfully";
		}

		return "Job Description Save Failed";
	}
}