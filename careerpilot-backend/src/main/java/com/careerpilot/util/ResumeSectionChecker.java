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

		if (resume.contains("certification")
				|| resume.contains("certifications")) {

			score += 5;
		}

		if (resume.contains("achievement")
				|| resume.contains("achievements")) {

			score += 5;
		}

		if (resume.contains("internship")
				|| resume.contains("internships")) {

			score += 5;
		}

		if (resume.contains("summary")
				|| resume.contains("professional summary")) {

			score += 5;
		}

		return score;
	}
}