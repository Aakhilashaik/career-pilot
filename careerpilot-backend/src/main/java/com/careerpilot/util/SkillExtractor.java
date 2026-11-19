package com.careerpilot.util;

import java.util.ArrayList;
import java.util.List;

public class SkillExtractor {

	public static List<String> extractSkills(
			String text) {

		List<String> skills =
				new ArrayList<>();

		String content =
				text.toLowerCase();

		String[] knownSkills = {

				"java",
				"spring",
				"spring boot",
				"spring security",
				"rest api",
				"microservices",
				"mysql",
				"postgresql",
				"oracle",
				"jdbc",
				"hibernate",
				"jpa",

				"docker",
				"kubernetes",
				"aws",
				"azure",

				"git",
				"github",

				"html",
				"css",
				"javascript",
				"typescript",
				"react",
				"angular",

				"python",
				"machine learning",
				"artificial intelligence",

				"linux",
				"maven",
				"gradle",

				"junit",
				"mockito",

				"c",
				"c++",

				"sql",
				"mongodb"
		};

		for (String skill : knownSkills) {

			if (content.contains(skill)) {

				skills.add(skill);
			}
		}

		return skills;
	}
}