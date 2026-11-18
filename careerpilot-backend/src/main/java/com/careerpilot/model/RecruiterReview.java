package com.careerpilot.model;

public class RecruiterReview {

	private String strengths;
	private String weaknesses;
	private String recommendations;
	private int predictedScore;

	public RecruiterReview() {
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

	public int getPredictedScore() {
		return predictedScore;
	}

	public void setPredictedScore(int predictedScore) {
		this.predictedScore = predictedScore;
	}
}