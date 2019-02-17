package com.java.challenge.voting_system.app.http.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.java.challenge.voting_system.app.http.service.GuidelinesRulesToView;

public class GuidelineControllerTest {

	@InjectMocks
	private GuidelineController guidelineController;

	@Mock
	private GuidelinesRulesToView guidelinesRulesToView;

	@Before
	public void setup() {
		initMocks(this);
	}

	@Test
	public void should_listAllGuidelines_when_allRouteCalled() {
		guidelineController.all();
		verify(guidelinesRulesToView).listAllGuidelines();
	}

}
