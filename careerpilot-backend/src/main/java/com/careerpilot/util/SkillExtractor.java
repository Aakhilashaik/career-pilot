package com.careerpilot.util;

import java.util.ArrayList;
import java.util.List;

public class SkillExtractor {

	public static List<String> extractSkills(String text) {

		List<String> skills = new ArrayList<>();

		String content = text.toLowerCase();

		String[] knownSkills = {

				"java",
				"spring boot",
				"spring security",
				"rest api",
				"mysql",
				"postgresql",
				"jdbc",
				"hibernate",
				"jpa",
				"git",
				"github",
				"docker",
				"aws",
				"junit",
				"html",
				"css",
				"javascript",
				"react",
				"typescript",
				"microservices",
				"python",
				"machine learning"
		};

		for (String skill : knownSkills) {

			if (content.contains(skill)) {
				skills.add(skill);
			}
		}

		return skills;
	}
}