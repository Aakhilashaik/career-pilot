package com.careerpilot.util;

public class ResumeQualityAnalyzer {

	public static int calculateProjectScore(
			String resumeText) {

		String text =
				resumeText.toLowerCase();

		int score = 0;

		if(text.contains("spring boot")) {
			score += 5;
		}

		if(text.contains("react")) {
			score += 5;
		}

		if(text.contains("docker")) {
			score += 5;
		}

		if(text.contains("aws")) {
			score += 5;
		}

		if(text.contains("microservices")) {
			score += 5;
		}

		if(text.contains("rest api")) {
			score += 5;
		}

		return score;
	}

	public static int calculateExperienceScore(
			String resumeText) {

		String text =
				resumeText.toLowerCase();

		int score = 0;

		String[] actionVerbs = {

				"developed",
				"designed",
				"implemented",
				"built",
				"engineered",
				"optimized",
				"improved",
				"created"
		};

		for(String word : actionVerbs) {

			if(text.contains(word)) {

				score += 3;
			}
		}

		return Math.min(score,20);
	}

	public static int calculateAchievementScore(
			String resumeText) {

		String text =
				resumeText.toLowerCase();

		int score = 0;

		if(text.contains("%")) {
			score += 5;
		}

		if(text.matches(".*\\d+.*")) {
			score += 5;
		}

		if(text.contains("reduced")) {
			score += 3;
		}

		if(text.contains("improved")) {
			score += 3;
		}

		if(text.contains("increased")) {
			score += 3;
		}

		return Math.min(score,15);
	}
}