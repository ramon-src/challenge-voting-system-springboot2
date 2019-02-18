package com.java.challenge.voting_system.infra.repository;

import java.util.List;

import com.java.challenge.voting_system.domain.guideline.AssociatedVote;
import com.java.challenge.voting_system.domain.guideline.Guideline;

public interface IGuidelineRepository {

	Guideline get(Guideline guideline);
	
	List<Guideline> all();

	Boolean exists(Guideline guideline);

	Boolean associatedAlreadyVoted(AssociatedVote associatedVote);

	Integer countVotesFrom(Guideline guideline);

	void associate(AssociatedVote associatedVote) throws Exception;

	void create(Guideline guideline);

}