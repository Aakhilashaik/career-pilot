package com.careerpilot.util;

public class ResumeSectionChecker {

	public static int calculateSectionScore(
			String resumeText) {

		int score = 0;

		String resume =
				resumeText.toLowerCase();

		if (resume.contains("education")) {
			score += 5;
		}

		if (resume.contains("skills")) {
			score += 5;
		}

		if (resume.contains("projects")) {
			score += 5;
		}

		if (resume.contains("experience")) {
			score += 5;
		}

		return score;
	}
}