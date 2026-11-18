package com.careerpilot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.careerpilot.model.JobDescription;
import com.careerpilot.service.JobDescriptionService;

@RestController
@RequestMapping("/api/job-descriptions")
@CrossOrigin("*")
public class JobDescriptionController {

	@Autowired
	private JobDescriptionService service;

	@PostMapping
	public String saveJobDescription(
			@RequestBody JobDescription jobDescription) {

		return service.saveJobDescription(jobDescription);
	}
}