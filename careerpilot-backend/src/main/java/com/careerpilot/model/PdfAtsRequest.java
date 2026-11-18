package com.careerpilot.model;

public class PdfAtsRequest {

	private String pdfPath;
	private String jobDescription;

	public PdfAtsRequest() {
	}

	public String getPdfPath() {
		return pdfPath;
	}

	public void setPdfPath(String pdfPath) {
		this.pdfPath = pdfPath;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
}