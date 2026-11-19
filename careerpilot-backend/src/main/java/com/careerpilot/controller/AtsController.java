package com.careerpilot.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.careerpilot.model.AtsAnalysis;
import com.careerpilot.model.AtsComparison;
import com.careerpilot.model.AtsLeaderboard;
import com.careerpilot.model.AtsRequest;
import com.careerpilot.model.AtsResult;
import com.careerpilot.model.PdfAtsRequest;
import com.careerpilot.service.AtsService;

@RestController
@RequestMapping("/api/ats")
@CrossOrigin("*")
public class AtsController {

	@Autowired
	private AtsService atsService;

	@PostMapping
	public String saveAnalysis(
			@RequestBody AtsAnalysis analysis) {

		return atsService.saveAnalysis(analysis);
	}

	@PostMapping("/analyze")
	public AtsResult analyzeResume(
			@RequestBody AtsRequest request) {

		return atsService.analyzeResume(
				request.getResumeText(),
				request.getJobDescription());
	}

	@PostMapping("/analyze-pdf")
	public AtsResult analyzePdfResume(
			@RequestBody PdfAtsRequest request)
			throws Exception {

		return atsService.analyzePdfResume(
				request.getPdfPath(),
				request.getJobDescription());
	}

	@PostMapping("/upload")
	public AtsResult uploadResume(
			@RequestParam("resume") MultipartFile resume,
			@RequestParam("jobDescription") String jobDescription)
			throws Exception {

		File tempFile =
				File.createTempFile(
						"resume",
						".pdf");

		resume.transferTo(tempFile);

		return atsService.analyzePdfResume(
				tempFile.getAbsolutePath(),
				jobDescription);
	}

	@GetMapping("/history")
	public List<AtsAnalysis> getHistory() {
		return atsService.getAllAnalysis();
	}

	@GetMapping("/compare")
	public List<AtsComparison> compareScores() {
		return atsService.compareScores();
	}

	@GetMapping("/best-resume")
	public AtsLeaderboard getBestResume() {
		return atsService.getBestResume();
	}
}