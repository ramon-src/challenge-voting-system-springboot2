package com.java.challenge.voting_system.infra.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.java.challenge.voting_system.guideline.AssociatedVote;
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
		AssociatedVote associatedVote = new AssociatedVote(guideline, user, null);

		guidelineRepository.associate(associatedVote);
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
	public void should_associateUsersToGuideline_when_guidelineWasAssociated() throws Exception {
		guideline.setId(10L);
		List<Guideline> guidelines = Arrays.asList(guideline);
		guidelineRepository.setGuidelines(guidelines);
		AssociatedVote associatedVote = new AssociatedVote(guideline, user, null);

		guidelineRepository.associate(associatedVote);

		assertEquals(1, guidelineRepository.getAssociatedVotes().size());
	}

	@Test(expected = Exception.class)
	public void should_not_permitToUserVoteInGuideline_when_alreadyVoted() throws Exception {
		List<Guideline> guidelines = Arrays.asList(guideline);
		guidelineRepository.setGuidelines(guidelines);
		AssociatedVote associatedVote = new AssociatedVote(guideline, user, null);
		guidelineRepository.setAssociatedVotes(Arrays.asList(associatedVote));

		guidelineRepository.associate(associatedVote);
	}

	@Test
	public void should_countTheTotalOfVotesFromAGuideline() {
		guideline.setId(10L);
		AssociatedVote associatedVote = new AssociatedVote(guideline, user, true);
		AssociatedVote associatedVote2 = new AssociatedVote(guideline, new User(), true);
		AssociatedVote associatedVote3 = new AssociatedVote(new Guideline(1L), new User(), true);

		guidelineRepository.setAssociatedVotes(Arrays.asList(associatedVote, associatedVote2, associatedVote3));

		Integer totalOfVotes = guidelineRepository.countVotesFrom(guideline);

		assertEquals(Integer.valueOf(2), totalOfVotes);
	}

}
