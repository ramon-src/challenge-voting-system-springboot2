package com.java.challenge.voting_system.app.http.controller;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.java.challenge.voting_system.app.http.anticorruption.VoteInfoDTO;
import com.java.challenge.voting_system.domain.guideline.AssociatedVote;
import com.java.challenge.voting_system.domain.guideline.Guideline;
import com.java.challenge.voting_system.domain.guideline.GuidelineFactory;
import com.java.challenge.voting_system.infra.repository.GuidelineInMemoryRepository;

public class VotingControllerTest {

	@InjectMocks
	private VotingController votingController;

	@Mock
	private GuidelineInMemoryRepository guidelineRepository;
	@Mock
	private GuidelineFactory guidelineFactory;

	@Before
	public void setup() {
		initMocks(this);
	}

	@Test
	public void should_associateAVouteOfAUserIntoGuideline_when_votingInGuidelineRouteCalled() throws Exception {
		VoteInfoDTO voteInfoDTO = new VoteInfoDTO();
		AssociatedVote voteInfo = new AssociatedVote();
		voteInfoDTO.setVoteInfo(voteInfo);

		votingController.votingInGuideline(voteInfoDTO);

		verify(guidelineRepository).associate(voteInfoDTO.getVoteInfo());
	}

	@Test
	public void should_countTheNumberOfAssociatedVotesInGuideline_when_counterRouteCalled() throws Exception {
		long id = 1L;
		Guideline guideline = new Guideline(id);
		given(guidelineFactory.make(id)).willReturn(guideline);

		votingController.counter(id);

		verify(guidelineRepository).countVotesFrom(guideline);
	}
}
