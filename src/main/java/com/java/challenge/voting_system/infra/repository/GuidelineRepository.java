package com.java.challenge.voting_system.infra.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.challenge.voting_system.guideline.Guideline;
import com.java.challenge.voting_system.user.User;

public class GuidelineRepository {
	
	private List<Guideline> guidelines;
	private Map<Guideline, List<User>> associatedUsers;
	
	public GuidelineRepository() {
		guidelines = new ArrayList<Guideline>();
		associatedUsers = new HashMap<Guideline, List<User>>();
	}
	
	public Guideline get(Guideline guideline) {
		return guidelines.stream().filter(gl -> gl.getId() == guideline.getId()).findFirst().get();
	}

	public Boolean exists(Guideline guideline) {
		return guidelines.stream().filter(gl -> gl.getId() == guideline.getId()).findFirst().isPresent();
	}
	
	public void associate(User user, Guideline guideline) throws Exception {
		Boolean exists = exists(guideline);
		if (!exists)
			throw new Exception("A pauta não existe");
		
		associatedUsersFrom(guideline).add(user);
	}

	protected List<User> associatedUsersFrom(Guideline guideline) {
		List<User> associateds = associatedUsers.get(guideline);
		if (associateds == null) {
			ArrayList<User> users = new ArrayList<User>();
			associatedUsers.put(guideline, users);
			associateds = associatedUsers.get(guideline);
		}
		return associateds;
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
	
}
