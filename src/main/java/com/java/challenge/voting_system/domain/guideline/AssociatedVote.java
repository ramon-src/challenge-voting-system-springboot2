package com.java.challenge.voting_system.domain.guideline;

import com.java.challenge.voting_system.domain.user.User;

public class AssociatedVote {
	private Guideline guideline;
	private User associated;
	private Boolean hasVoted;

	public AssociatedVote() {
		
	}
	
	public AssociatedVote(Guideline guideline, User associated, Boolean hasVoted) {
		this.guideline = guideline;
		this.associated = associated;
		this.hasVoted = hasVoted;
	}

	public Guideline getGuideline() {
		return guideline;
	}

	public Long getGuidelineId() {
		return guideline.getId();
	}

	public void setGuideline(Guideline guideline) {
		this.guideline = guideline;
	}

	public User getAssociated() {
		return associated;
	}

	public Long getAssociatedId() {
		return associated.getId();
	}
	
	public void setAssociated(User associated) {
		this.associated = associated;
	}

	public Boolean hasVoted() {
		return hasVoted;
	}

	public void setHasVoted(Boolean hasVoted) {
		this.hasVoted = hasVoted;
	}
}
