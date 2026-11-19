package com.careerpilot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careerpilot.model.AtsAnalysis;
import com.careerpilot.model.AtsComparison;
import com.careerpilot.model.AtsLeaderboard;
import com.careerpilot.model.AtsResult;
import com.careerpilot.repository.AtsAnalysisRepository;
import com.careerpilot.util.PdfTextExtractor;
import com.careerpilot.util.ResumeQualityAnalyzer;
import com.careerpilot.util.ResumeSectionChecker;
import com.careerpilot.util.SkillExtractor;

@Service
public class AtsService {

	@Autowired
	private AtsAnalysisRepository repository;

	public String saveAnalysis(AtsAnalysis analysis) {

		int result =
				repository.saveAnalysis(
						analysis);

		if(result > 0) {
			return "ATS Analysis Saved Successfully";
		}

		return "ATS Analysis Save Failed";
	}

	public AtsResult analyzeResume(
			String resumeText,
			String jobDescription) {

		AtsResult result =
				new AtsResult();

		List<String> resumeSkills =
				SkillExtractor.extractSkills(
						resumeText);

		List<String> jdSkills =
				SkillExtractor.extractSkills(
						jobDescription);

		List<String> matchedSkills =
				new ArrayList<>();

		List<String> missingSkills =
				new ArrayList<>();

		for(String skill : jdSkills) {

			if(resumeSkills.contains(skill)) {

				matchedSkills.add(skill);

			} else {

				missingSkills.add(skill);
			}
		}

		int skillMatchPercentage = 0;

		if(!jdSkills.isEmpty()) {

			skillMatchPercentage =
					(matchedSkills.size() * 100)
							/ jdSkills.size();
		}

		result.setSkillMatchPercentage(
				skillMatchPercentage);

		int sectionScore =
				ResumeSectionChecker.calculateSectionScore(
				    resumeText);

				result.setResumeQualityScore(
				    sectionScore);

		int projectScore =
				ResumeQualityAnalyzer.calculateProjectScore(
				    resumeText);

				result.setProjectScore(
				    projectScore);
				int experienceScore =
						ResumeQualityAnalyzer.calculateExperienceScore(
						    resumeText);

						result.setExperienceScore(
						    experienceScore);

						int achievementScore =
								ResumeQualityAnalyzer.calculateAchievementScore(
								    resumeText);

								result.setAchievementScore(
								    achievementScore);
		int atsScore =
				(int)(
				(skillMatchPercentage * 0.50)
				+ sectionScore
				+ projectScore
				+ experienceScore
				+ achievementScore);

		if(atsScore > 100) {
			atsScore = 100;
		}

		result.setAtsScore(
				atsScore);

		result.setMatchedKeywords(
				String.join(
						", ",
						matchedSkills));

		result.setMissingKeywords(
				String.join(
						", ",
						missingSkills));

		StringBuilder strengths =
				new StringBuilder();

		if(!matchedSkills.isEmpty()) {

			strengths.append(
					"Relevant skills found: ")
					.append(
					String.join(
							", ",
							matchedSkills))
					.append(". ");
		}

		if(projectScore >= 15) {

			strengths.append(
			"Strong technical projects detected. ");
		}

		if(experienceScore >= 12) {

			strengths.append(
			"Good use of action-oriented experience descriptions. ");
		}

		if(achievementScore >= 8) {

			strengths.append(
			"Resume includes measurable achievements. ");
		}

		if(strengths.length() == 0) {

			strengths.append(
			"Basic resume structure detected.");
		}

		result.setStrengths(
				strengths.toString());

		StringBuilder weaknesses =
				new StringBuilder();

		if(!missingSkills.isEmpty()) {

			weaknesses.append(
					"Missing skills: ")
					.append(
					String.join(
							", ",
							missingSkills))
					.append(". ");
		}

		if(sectionScore < 25) {

			weaknesses.append(
			"Resume is missing important sections. ");
		}

		if(achievementScore < 5) {

			weaknesses.append(
			"Few quantified achievements detected. ");
		}

		if(experienceScore < 8) {

			weaknesses.append(
			"Experience descriptions can be improved. ");
		}

		result.setWeaknesses(
				weaknesses.toString());

		StringBuilder recommendations =
				new StringBuilder();

		for(String skill : missingSkills) {

			recommendations
					.append("Add ")
					.append(skill)
					.append(
					" through projects, internships or certifications. ");
		}

		if(sectionScore < 25) {

			recommendations.append(
			"Include Education, Skills, Projects, Experience and Certifications sections. ");
		}

		if(achievementScore < 5) {

			recommendations.append(
			"Add measurable achievements using percentages, numbers and project impact. ");
		}

		if(experienceScore < 8) {

			recommendations.append(
			"Use action verbs such as Developed, Designed, Built and Implemented. ");
		}

		result.setRecommendations(
				recommendations.toString());

		int predictedScore =
				atsScore
				+ (missingSkills.size() * 5);

		if(predictedScore > 100) {

			predictedScore = 100;
		}

		result.setPredictedScore(
				predictedScore);

		if(atsScore >= 85) {

			result.setRecruiterFeedback(
			"Excellent profile. Resume demonstrates strong technical relevance and recruiter appeal.");

		} else if(atsScore >= 70) {

			result.setRecruiterFeedback(
			"Good profile. Improving missing skills and achievements can significantly increase interview chances.");

		} else {

			result.setRecruiterFeedback(
			"Resume requires improvement. Focus on skills, projects, measurable achievements and experience descriptions.");
		}

		return result;
	}

	public AtsResult analyzePdfResume(
			String pdfPath,
			String jobDescription)
			throws Exception {

		String resumeText =
				PdfTextExtractor
				.extractText(pdfPath);

		return analyzeResume(
				resumeText,
				jobDescription);
	}

	public List<AtsAnalysis> getAllAnalysis() {

		return repository
				.getAllAnalysis();
	}

	public List<AtsComparison> compareScores() {

		return repository
				.compareScores();
	}

	public AtsLeaderboard getBestResume() {

		return repository
				.getBestResume();
	}
}