package com.careerpilot.model;

public class AtsResult {

	private int atsScore;

	private int predictedScore;

	private int skillMatchPercentage;

	private int projectScore;

	private int experienceScore;

	private int achievementScore;

	private int resumeQualityScore;

	private String matchedKeywords;

	private String missingKeywords;

	private String strengths;

	private String weaknesses;

	private String recommendations;

	private String recruiterFeedback;

	public AtsResult() {
	}

	public int getAtsScore() {
		return atsScore;
	}

	public void setAtsScore(int atsScore) {
		this.atsScore = atsScore;
	}

	public int getPredictedScore() {
		return predictedScore;
	}

	public void setPredictedScore(int predictedScore) {
		this.predictedScore = predictedScore;
	}

	public int getSkillMatchPercentage() {
		return skillMatchPercentage;
	}

	public void setSkillMatchPercentage(int skillMatchPercentage) {
		this.skillMatchPercentage = skillMatchPercentage;
	}

	public int getProjectScore() {
		return projectScore;
	}

	public void setProjectScore(int projectScore) {
		this.projectScore = projectScore;
	}

	public int getExperienceScore() {
		return experienceScore;
	}

	public void setExperienceScore(int experienceScore) {
		this.experienceScore = experienceScore;
	}

	public int getAchievementScore() {
		return achievementScore;
	}

	public void setAchievementScore(int achievementScore) {
		this.achievementScore = achievementScore;
	}

	public int getResumeQualityScore() {
		return resumeQualityScore;
	}

	public void setResumeQualityScore(int resumeQualityScore) {
		this.resumeQualityScore = resumeQualityScore;
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

	public String getStrengths() {
		return strengths;
	}

	public void setStrengths(String strengths) {
		this.strengths = strengths;
	}

	public String getWeaknesses() {
		return weaknesses;
	}

	public void setWeaknesses(String weaknesses) {
		this.weaknesses = weaknesses;
	}

	public String getRecommendations() {
		return recommendations;
	}

	public void setRecommendations(String recommendations) {
		this.recommendations = recommendations;
	}

	public String getRecruiterFeedback() {
		return recruiterFeedback;
	}

	public void setRecruiterFeedback(String recruiterFeedback) {
		this.recruiterFeedback = recruiterFeedback;
	}
}