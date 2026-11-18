package com.careerpilot.model;

public class DashboardStats {

	private int totalApplications;
	private int selectedApplications;
	private int rejectedApplications;
	private int pendingApplications;
	private int totalInterviews;

	private int totalResumeAnalyses;
	private int averageAtsScore;

	public DashboardStats() {
	}

	public int getTotalApplications() {
		return totalApplications;
	}

	public void setTotalApplications(int totalApplications) {
		this.totalApplications = totalApplications;
	}

	public int getSelectedApplications() {
		return selectedApplications;
	}

	public void setSelectedApplications(int selectedApplications) {
		this.selectedApplications = selectedApplications;
	}

	public int getRejectedApplications() {
		return rejectedApplications;
	}

	public void setRejectedApplications(int rejectedApplications) {
		this.rejectedApplications = rejectedApplications;
	}

	public int getPendingApplications() {
		return pendingApplications;
	}

	public void setPendingApplications(int pendingApplications) {
		this.pendingApplications = pendingApplications;
	}

	public int getTotalInterviews() {
		return totalInterviews;
	}

	public void setTotalInterviews(int totalInterviews) {
		this.totalInterviews = totalInterviews;
	}

	public int getTotalResumeAnalyses() {
		return totalResumeAnalyses;
	}

	public void setTotalResumeAnalyses(int totalResumeAnalyses) {
		this.totalResumeAnalyses = totalResumeAnalyses;
	}

	public int getAverageAtsScore() {
		return averageAtsScore;
	}

	public void setAverageAtsScore(int averageAtsScore) {
		this.averageAtsScore = averageAtsScore;
	}
}