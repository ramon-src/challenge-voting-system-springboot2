package com.java.challenge.voting_system.infra.repository;

import static org.junit.Assert.*;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.java.challenge.voting_system.guideline.Guideline;

public class GuidelineRepositoryTest {

	@InjectMocks
	private  GuidelineRepository guidelineRepository;

	@Mock
	private Guideline guideline;

	@Before
	public void setup() {
		initMocks(this);
	}

	@Test
	public void should_getTheGuideline_when_matchId() {
		guideline.setId(10L);
		List<Guideline> guidelines = Arrays.asList(new Guideline(), guideline, new Guideline());
		guidelineRepository.setGuidelines(guidelines);
		
		assertEquals(guideline, guidelineRepository.get(guideline));
	}
	
	@Test
	public void should_createANewGuideline() {
		guideline.setId(10L);
		
		guidelineRepository.create(guideline);
		
		assertEquals(1, guidelineRepository.getGuidelines().size());
	}

}
