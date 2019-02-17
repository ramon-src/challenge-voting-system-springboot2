package com.java.challenge.voting_system.app.http.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.challenge.voting_system.app.http.anticorruption.GuidelineDTO;
import com.java.challenge.voting_system.infra.repository.GuidelineRepository;

@Service
public class GuidelinesRulesToView {
	@Autowired
	public GuidelineRepository guidelineRepository;
	
	public GuidelineDTO guidelineDTO;

	public GuidelinesRulesToView() {
		guidelineDTO = new GuidelineDTO();
	}
	
	public GuidelineDTO listAllGuidelines() {
		guidelineDTO.setGuidelines(guidelineRepository.getGuidelines());
		return guidelineDTO;
	}
}
