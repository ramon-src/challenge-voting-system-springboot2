package com.java.challenge.voting_system.app.http.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.java.challenge.voting_system.app.http.anticorruption.VoteInfoDTO;
import com.java.challenge.voting_system.domain.guideline.AssociatedVote;
import com.java.challenge.voting_system.infra.repository.GuidelineRepository;

public class VotingControllerTest {

	@InjectMocks
	private VotingController votingController;

	@Mock
	private GuidelineRepository guidelineRepository;

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
}
