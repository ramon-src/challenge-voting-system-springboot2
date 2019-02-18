package com.java.challenge;

import com.java.challenge.voting_system.domain.user.User;
import com.java.challenge.voting_system.infra.repository.GuidelineInMemoryRepository;
import com.java.challenge.voting_system.infra.repository.IGuidelineRepository;

public class Loader {
	private static User user;
	private static IGuidelineRepository guidelineRepository;

	public static void initDependencies() {
		setUser(new User());
		setGuidelineRepository(new GuidelineInMemoryRepository());
	}

	public static User user() {
		return Loader.user;
	}

	public static void setUser(User user) {
		Loader.user = user;
	}

	public static IGuidelineRepository getGuidelineRepository() {
		return guidelineRepository;
	}

	public static void setGuidelineRepository(IGuidelineRepository guidelineRepository) {
		Loader.guidelineRepository = guidelineRepository;
	}

}
