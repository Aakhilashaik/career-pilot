package com.careerpilot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.careerpilot.model.FeedbackRequest;
import com.careerpilot.model.Interview;
import com.careerpilot.model.InterviewStatusRequest;
import com.careerpilot.service.InterviewService;

@RestController
@RequestMapping("/api/interviews")
@CrossOrigin("*")
public class InterviewController {

	@Autowired
	private InterviewService interviewService;

	// Schedule Interview
	@PostMapping
	public String scheduleInterview(
			@RequestBody Interview interview) {

		return interviewService.scheduleInterview(interview);
	}

	// View Interviews By User
	@GetMapping("/user/{userId}")
	public List<Interview> getInterviewsByUserId(
			@PathVariable int userId) {

		return interviewService.getInterviewsByUserId(userId);
	}

	// Update Interview Status
	@PutMapping("/{interviewId}/status")
	public String updateInterviewStatus(
			@PathVariable int interviewId,
			@RequestBody InterviewStatusRequest request) {

		return interviewService.updateInterviewStatus(
				interviewId,
				request.getStatus());
	}

	// Update Interview Feedback
	@PutMapping("/{interviewId}/feedback")
	public String updateFeedback(
			@PathVariable int interviewId,
			@RequestBody FeedbackRequest request) {

		return interviewService.updateFeedback(
				interviewId,
				request.getFeedback());
	}
	@GetMapping("/company/{companyName}")
	public List<Interview> searchByCompany(
			@PathVariable String companyName) {

		return interviewService
				.searchByCompany(companyName);
	}
}