package com.careerpilot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.careerpilot.model.Resume;
import com.careerpilot.service.ResumeService;

@RestController
@RequestMapping("/api/resumes")
@CrossOrigin("*")
public class ResumeController {

	@Autowired
	private ResumeService resumeService;

	@PostMapping
	public String saveResume(
			@RequestBody Resume resume) {

		return resumeService.saveResume(
				resume);
	}

	@GetMapping("/user/{userId}")
	public List<Resume> getResumesByUserId(
			@PathVariable int userId) {

		return resumeService
				.getResumesByUserId(userId);
	}
}