package com.careerpilot.util;

public class PdfTest {

	public static void main(String[] args) {

		try {

			String text =
					PdfTextExtractor.extractText(
				"C:\\Users\\skmah\\OneDrive\\Desktop\\cirtificates\\Resumes\\MAHABOOB SUBHANI_ Intern - AI & Software Engineering_Resume.pdf");

			System.out.println(text);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}