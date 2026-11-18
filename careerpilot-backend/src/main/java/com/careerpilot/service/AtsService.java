package com.careerpilot.service;

import java.util.ArrayList;
import java.util.List;

import com.careerpilot.model.AtsComparison;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careerpilot.model.AtsAnalysis;
import com.careerpilot.model.AtsResult;
import com.careerpilot.repository.AtsAnalysisRepository;
import com.careerpilot.util.PdfTextExtractor;
import com.careerpilot.util.ResumeSectionChecker;
import com.careerpilot.util.SkillExtractor;
import com.careerpilot.model.AtsLeaderboard;
@Service
public class AtsService {

	@Autowired
	private AtsAnalysisRepository repository;

	// Save ATS Analysis
	public String saveAnalysis(AtsAnalysis analysis) {

		int result = repository.saveAnalysis(analysis);

		if (result > 0) {
			return "ATS Analysis Saved Successfully";
		}

		return "ATS Analysis Save Failed";
	}

	// ATS Analysis Using Resume Text
	public AtsResult analyzeResume(
			String resumeText,
			String jobDescription) {

		AtsResult result = new AtsResult();

		List<String> resumeSkills =
				SkillExtractor.extractSkills(resumeText);

		List<String> jdSkills =
				SkillExtractor.extractSkills(jobDescription);

		List<String> matchedSkills =
				new ArrayList<>();

		List<String> missingSkills =
				new ArrayList<>();

		for (String skill : jdSkills) {

			if (resumeSkills.contains(skill)) {

				matchedSkills.add(skill);

			} else {

				missingSkills.add(skill);
			}
		}

		// Skill Match Percentage

		int skillMatchPercentage = 0;

		if (!jdSkills.isEmpty()) {

			skillMatchPercentage =
					(matchedSkills.size() * 100)
							/ jdSkills.size();
		}

		result.setSkillMatchPercentage(
				skillMatchPercentage);

		// Resume Section Score

		int sectionScore =
				ResumeSectionChecker.calculateSectionScore(
						resumeText);

		// ATS Score

		int atsScore =
				(int) ((skillMatchPercentage * 0.7)
						+ sectionScore
						+ 10);

		if (atsScore > 100) {
			atsScore = 100;
		}

		result.setAtsScore(atsScore);

		// Matched Keywords

		result.setMatchedKeywords(
				String.join(", ", matchedSkills));

		// Missing Keywords

		result.setMissingKeywords(
				String.join(", ", missingSkills));

		// Strengths

		if (!matchedSkills.isEmpty()) {

			result.setStrengths(
					"Strong skills in: "
							+ String.join(", ",
									matchedSkills));
		} else {

			result.setStrengths(
					"No matching skills found.");
		}

		// Weaknesses

		if (!missingSkills.isEmpty()) {

			result.setWeaknesses(
					"Missing important skills: "
							+ String.join(", ",
									missingSkills));
		} else {

			result.setWeaknesses(
					"No major skill gaps found.");
		}

		// Recommendations

		StringBuilder recommendations =
				new StringBuilder();

		for (String skill : missingSkills) {

			recommendations
					.append("Add ")
					.append(skill)
					.append(" experience. ");
		}

		if (recommendations.length() == 0) {

			recommendations.append(
					"Resume is already strongly aligned with the job description.");
		}

		result.setRecommendations(
				recommendations.toString());

		// Predicted Score

		int predictedScore =
				atsScore + (missingSkills.size() * 8);

		if (predictedScore > 100) {
			predictedScore = 100;
		}

		result.setPredictedScore(
				predictedScore);

		// Recruiter Feedback

		if (atsScore >= 85) {

			result.setRecruiterFeedback(
					"Excellent resume match. High probability of recruiter shortlist.");

		} else if (atsScore >= 70) {

			result.setRecruiterFeedback(
					"Good profile. Add missing skills to improve ATS performance.");

		} else {

			result.setRecruiterFeedback(
					"Resume requires improvement. Several important skills are missing.");
		}

		return result;
	}

	// ATS Analysis Using PDF

	public AtsResult analyzePdfResume(
			String pdfPath,
			String jobDescription)
			throws Exception {

		String resumeText =
				PdfTextExtractor.extractText(pdfPath);

		return analyzeResume(
				resumeText,
				jobDescription);
	}
	public List<AtsAnalysis> getAllAnalysis() {

		return repository.getAllAnalysis();
	}
	public List<AtsComparison> compareScores() {

		return repository.compareScores();
	}
	public AtsLeaderboard getBestResume() {

		return repository.getBestResume();
	}
	
}