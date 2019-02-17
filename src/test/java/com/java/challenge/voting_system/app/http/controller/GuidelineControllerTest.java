package com.java.challenge.voting_system.app.http.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.java.challenge.voting_system.app.http.anticorruption.GuidelineDTO;
import com.java.challenge.voting_system.app.http.service.GuidelinesRulesToView;
import com.java.challenge.voting_system.domain.guideline.Guideline;
import com.java.challenge.voting_system.infra.repository.GuidelineRepository;

public class GuidelineControllerTest {

	@InjectMocks
	private GuidelineController guidelineController;

	@Mock
	private GuidelinesRulesToView guidelinesRulesToView;
	@Mock
	private GuidelineRepository guidelineRepository;

	@Before
	public void setup() {
		initMocks(this);
	}

	@Test
	public void should_listAllGuidelines_when_allRouteCalled() {
		guidelineController.all();
		verify(guidelinesRulesToView).listAllGuidelines();
	}

	@Test
	public void should_createAGuideline_when_createRouteCalled() {
		GuidelineDTO guidelineDTO = new GuidelineDTO();
		Guideline guideline = new Guideline(1L);
		guidelineDTO.setGuideline(guideline);
		
		guidelineController.create(guidelineDTO);
		
		verify(guidelineRepository).create(guideline);
	}
}
