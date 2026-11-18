package com.careerpilot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careerpilot.model.Application;
import com.careerpilot.repository.ApplicationRepository;

@Service
public class ApplicationService {

	@Autowired
	private ApplicationRepository applicationRepository;

	// Add Application
	public String addApplication(Application application) {

		if (application.getStatus() == null || application.getStatus().isEmpty()) {
			application.setStatus("Applied");
		}

		int result = applicationRepository.saveApplication(application);

		if (result > 0) {
			return "Application Added Successfully";
		}

		return "Application Creation Failed";
	}

	// View Applications
	public List<Application> getApplicationsByUserId(int userId) {

		return applicationRepository.getApplicationsByUserId(userId);
	}

	// Update Status
	public String updateStatus(int applicationId, String status) {

		int result = applicationRepository.updateStatus(
				applicationId,
				status);

		if (result > 0) {
			return "Application Status Updated Successfully";
		}

		return "Application Status Update Failed";
	}

	// Delete Application
	public String deleteApplication(int applicationId) {

		int result = applicationRepository.deleteApplication(applicationId);

		if (result > 0) {
			return "Application Deleted Successfully";
		}

		return "Application Not Found";
	}
	// Search Applications
	public List<Application> searchByCompany(
			String companyName) {

		return applicationRepository
				.searchByCompany(companyName);
	}
}