package com.careerpilot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.careerpilot.model.Application;
import com.careerpilot.model.StatusUpdateRequest;
import com.careerpilot.service.ApplicationService;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin("*")
public class ApplicationController {

	@Autowired
	private ApplicationService applicationService;

	// Add Application
	@PostMapping
	public String addApplication(@RequestBody Application application) {

		return applicationService.addApplication(application);
	}

	// View Applications By User ID
	@GetMapping("/user/{userId}")
	public List<Application> getApplicationsByUserId(
			@PathVariable int userId) {

		return applicationService.getApplicationsByUserId(userId);
	}

	// Update Application Status
	@PutMapping("/{applicationId}/status")
	public String updateStatus(
			@PathVariable int applicationId,
			@RequestBody StatusUpdateRequest request) {

		return applicationService.updateStatus(
				applicationId,
				request.getStatus());
	}

	// Delete Application
	@DeleteMapping("/{applicationId}")
	public String deleteApplication(
			@PathVariable int applicationId) {

		return applicationService.deleteApplication(
				applicationId);
	}
	// Search By Company
	@GetMapping("/search/{companyName}")
	public List<Application> searchByCompany(
			@PathVariable String companyName) {

		return applicationService
				.searchByCompany(companyName);
	}
}