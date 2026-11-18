package com.careerpilot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careerpilot.model.Interview;
import com.careerpilot.repository.InterviewRepository;

@Service
public class InterviewService {

	@Autowired
	private InterviewRepository interviewRepository;

	// Schedule Interview
	public String scheduleInterview(Interview interview) {

		if (interview.getStatus() == null ||
				interview.getStatus().isEmpty()) {

			interview.setStatus("Scheduled");
		}

		int result =
				interviewRepository.saveInterview(interview);

		if (result > 0) {
			return "Interview Scheduled Successfully";
		}

		return "Interview Scheduling Failed";
	}

	// View Interviews
	public List<Interview> getInterviewsByUserId(int userId) {

		return interviewRepository.getInterviewsByUserId(userId);
	}

	// Update Interview Status
	public String updateInterviewStatus(
			int interviewId,
			String status) {

		int result =
				interviewRepository.updateInterviewStatus(
						interviewId,
						status);

		if (result > 0) {
			return "Interview Status Updated Successfully";
		}

		return "Interview Status Update Failed";
	}

	// Update Feedback
	public String updateFeedback(
			int interviewId,
			String feedback) {

		int result =
				interviewRepository.updateFeedback(
						interviewId,
						feedback);

		if (result > 0) {
			return "Interview Feedback Updated Successfully";
		}

		return "Interview Feedback Update Failed";
	}
	public List<Interview> searchByCompany(
			String companyName) {

		return interviewRepository
				.searchByCompany(companyName);
	}
}