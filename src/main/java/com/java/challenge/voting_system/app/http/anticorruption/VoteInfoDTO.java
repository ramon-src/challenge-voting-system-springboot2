package com.java.challenge.voting_system.app.http.anticorruption;

import com.java.challenge.voting_system.domain.guideline.AssociatedVote;


public class VoteInfoDTO {

	public AssociatedVote voteInfo;

	public AssociatedVote getVoteInfo() {
		return voteInfo;
	}

	public void setVoteInfo(AssociatedVote voteInfo) {
		this.voteInfo = voteInfo;
	}

}
