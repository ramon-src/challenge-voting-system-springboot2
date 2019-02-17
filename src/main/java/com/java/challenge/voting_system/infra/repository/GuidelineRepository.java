package com.java.challenge.voting_system.infra.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.challenge.voting_system.guideline.AssociatedVote;
import com.java.challenge.voting_system.guideline.Guideline;
import com.java.challenge.voting_system.user.User;

public class GuidelineRepository {
	
	private List<Guideline> guidelines;
	private Map<Guideline, List<User>> associatedUsers;
	private List<AssociatedVote> associatedVotes;
	
	public GuidelineRepository() {
		guidelines = new ArrayList<Guideline>();
		associatedUsers = new HashMap<Guideline, List<User>>();
		setAssociatedVotes(new ArrayList<AssociatedVote>());
	}
	
	public Guideline get(Guideline guideline) {
		return guidelines.stream().filter(gl -> gl.getId() == guideline.getId()).findFirst().get();
	}

	public Boolean exists(Guideline guideline) {
		return guidelines.stream().filter(gl -> gl.getId() == guideline.getId()).findFirst().isPresent();
	}
	
	public Boolean associatedAlreadyVoted(AssociatedVote associatedVote) {
		return getAssociatedVotes().stream().filter(av -> 
			av.getGuidelineId() == associatedVote.getGuidelineId() && av.getAssociatedId() == associatedVote.getAssociatedId()
		).findFirst().isPresent();
	}
	
	public void associate(AssociatedVote associatedVote) throws Exception {
		Guideline guideline = associatedVote.getGuideline();
		if (!exists(guideline))
			throw new Exception("A pauta não existe.");
		
		if (associatedAlreadyVoted(associatedVote))
			throw new Exception("O usuário já votou na pauta escolhida.");
		
		associatedVotes.add(associatedVote);
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

	public Map<Guideline, List<User>> getAssociatedUsers() {
		return associatedUsers;
	}

	public void setAssociatedUsers(Map<Guideline, List<User>> associatedUsers) {
		this.associatedUsers = associatedUsers;
	}

	public List<AssociatedVote> getAssociatedVotes() {
		return associatedVotes;
	}

	public void setAssociatedVotes(List<AssociatedVote> associatedVotes) {
		this.associatedVotes = associatedVotes;
	}
	
}
