package com.java.challenge.voting_system.app.http.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.challenge.voting_system.app.http.anticorruption.VoteInfoDTO;
import com.java.challenge.voting_system.domain.guideline.AssociatedVote;
import com.java.challenge.voting_system.domain.guideline.Guideline;
import com.java.challenge.voting_system.domain.guideline.GuidelineFactory;
import com.java.challenge.voting_system.infra.repository.IGuidelineRepository;

@ResponseBody
@RestController
@RequestMapping("voting")
public class VotingController {
	@Autowired
	private IGuidelineRepository guidelineRepository;
	@Autowired
	private GuidelineFactory guidelineFactory;

	@PostMapping("/in-guideline")
	public void votingInGuideline(@RequestBody VoteInfoDTO voteInfoDto) throws Exception {
		AssociatedVote vote = voteInfoDto.getVoteInfo();
		guidelineRepository.associate(vote);
	}

	@GetMapping("/counter/{guidelineId}")
	public Integer counter(@PathVariable Long guidelineId) throws Exception {
		Guideline guideline = guidelineFactory.make(guidelineId);
		return guidelineRepository.countVotesFrom(guideline);
	}
}
