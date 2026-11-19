package com.careerpilot.model;

public class AtsAnalysis {

	private int id;
	private int resumeId;
	private int jobDescriptionId;
	private int atsScore;
	private String matchedKeywords;
	private String missingKeywords;
	private String recruiterFeedback;

	public AtsAnalysis() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getResumeId() {
		return resumeId;
	}

	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}

	public int getJobDescriptionId() {
		return jobDescriptionId;
	}

	public void setJobDescriptionId(int jobDescriptionId) {
		this.jobDescriptionId = jobDescriptionId;
	}

	public int getAtsScore() {
		return atsScore;
	}

	public void setAtsScore(int atsScore) {
		this.atsScore = atsScore;
	}

	public String getMatchedKeywords() {
		return matchedKeywords;
	}

	public void setMatchedKeywords(String matchedKeywords) {
		this.matchedKeywords = matchedKeywords;
	}

	public String getMissingKeywords() {
		return missingKeywords;
	}

	public void setMissingKeywords(String missingKeywords) {
		this.missingKeywords = missingKeywords;
	}

	public String getRecruiterFeedback() {
		return recruiterFeedback;
	}

	public void setRecruiterFeedback(String recruiterFeedback) {
		this.recruiterFeedback = recruiterFeedback;
	}
	

}