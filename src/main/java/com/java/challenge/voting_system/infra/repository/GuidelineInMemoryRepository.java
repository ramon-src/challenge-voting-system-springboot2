package com.java.challenge.voting_system.infra.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.java.challenge.voting_system.domain.guideline.AssociatedVote;
import com.java.challenge.voting_system.domain.guideline.Guideline;
import com.java.challenge.voting_system.domain.user.User;

@Repository
public class GuidelineInMemoryRepository implements IGuidelineRepository {

	private List<Guideline> guidelines;
	private List<AssociatedVote> associatedVotes;

	public GuidelineInMemoryRepository() {
		guidelines = new ArrayList<Guideline>();
		associatedVotes = new ArrayList<AssociatedVote>();
		
		initializeData();
	}

	private void initializeData() {
		guidelines.add(new Guideline(1L));
		guidelines.add(new Guideline(2L));
		User user1 = new User(1L, null);
		User user2 = new User(2L, null);
		associatedVotes.add(new AssociatedVote(guidelines.get(0), user1, true));
		associatedVotes.add(new AssociatedVote(guidelines.get(0), user2, false));

		associatedVotes.add(new AssociatedVote(guidelines.get(1), user1, true));
		associatedVotes.add(new AssociatedVote(guidelines.get(1), user2, true));
	}

	public Guideline get(Guideline guideline) {
		return guidelines.stream().filter(gl -> gl.getId() == guideline.getId()).findFirst().get();
	}

	public Boolean exists(Guideline guideline) {
		return guidelines.stream().filter(gl -> gl.getId() == guideline.getId()).findFirst().isPresent();
	}

	public Boolean associatedAlreadyVoted(AssociatedVote associatedVote) {
		return associatedVotes.stream().filter(av -> av.getGuidelineId() == associatedVote.getGuidelineId()
				&& av.getAssociatedId() == associatedVote.getAssociatedId()).findFirst().isPresent();
	}

	public Integer countVotesFrom(Guideline guideline) {
		Integer votesSum = 0;
		for (AssociatedVote associatedVote : associatedVotes) {
			if (associatedVote.getGuidelineId() == guideline.getId() && associatedVote.hasVoted())
				votesSum++;
		}
		return votesSum;
	}

	public void associate(AssociatedVote associatedVote) throws Exception {
		Guideline guideline = associatedVote.getGuideline();
		if (!exists(guideline))
			throw new Exception("A pauta não existe.");

		if (associatedAlreadyVoted(associatedVote))
			throw new Exception("O usuário já votou na pauta escolhida.");

		associatedVotes.add(associatedVote);
	}

	public List<Guideline> all() {
		return guidelines;
	}

	public void create(Guideline guideline) {
		guidelines.add(guideline);
	}

	public List<Guideline> getGuidelines() {
		return guidelines;
	}

	public void setGuidelines(List<Guideline> guidelines) {
		this.guidelines = guidelines;
	}

	public List<AssociatedVote> getAssociatedVotes() {
		return associatedVotes;
	}

	public void setAssociatedVotes(List<AssociatedVote> associatedVotes) {
		this.associatedVotes = associatedVotes;
	}

}
