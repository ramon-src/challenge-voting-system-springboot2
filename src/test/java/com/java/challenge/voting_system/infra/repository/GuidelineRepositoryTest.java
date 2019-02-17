package com.java.challenge.voting_system.infra.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.java.challenge.voting_system.guideline.Guideline;
import com.java.challenge.voting_system.user.User;

public class GuidelineRepositoryTest {

	@InjectMocks
	private GuidelineRepository guidelineRepository;

	@Mock
	private Guideline guideline;
	@Mock
	private User user;

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

	@Test(expected = Exception.class)
	public void should_notAssociateUsers_when_guidelineNotFound() throws Exception {
		guideline.setId(10L);
		
		guidelineRepository.associate(user, guideline);
	}
	
	@Test
	public void should_existTheGuideline() {
		guideline.setId(10L);
		List<Guideline> guidelines = Arrays.asList(guideline);
		guidelineRepository.setGuidelines(guidelines);
		
		assertTrue(guidelineRepository.exists(guideline));
	}
	
	@Test
	public void should_not_existTheGuideline() {		
		assertFalse(guidelineRepository.exists(guideline));
	}
	
	@Test
	public void should_associateUsersToGuideline_evenWhen_guidelineIsNotAssociatedYet() throws Exception {
		guideline.setId(10L);
		List<Guideline> guidelines = Arrays.asList(guideline);
		guidelineRepository.setGuidelines(guidelines);
		
		guidelineRepository.associate(user, guideline);
		
		assertEquals(1, guidelineRepository.getAssociatedUsers().size());
	}

	@Test
	public void should_associateUsersToGuideline_when_guidelineWasAssociated() throws Exception {
		guideline.setId(10L);
		List<Guideline> guidelines = Arrays.asList(guideline);
		guidelineRepository.setGuidelines(guidelines);
		
		Map<Guideline, List<User>> associatedUsers = new HashMap<Guideline, List<User>>();
		associatedUsers.put(guideline, new ArrayList<User>());
		guidelineRepository.setAssociatedUsers(associatedUsers);
		
		guidelineRepository.associate(user, guideline);
		
		assertEquals(1, guidelineRepository.getAssociatedUsers().size());
	}

}
