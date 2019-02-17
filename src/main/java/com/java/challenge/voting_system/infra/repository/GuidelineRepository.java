package com.java.challenge.voting_system.infra.repository;

import java.util.ArrayList;
import java.util.List;

import com.java.challenge.voting_system.guideline.Guideline;

public class GuidelineRepository {
	
	private List<Guideline> guidelines;
	
	public GuidelineRepository() {
		guidelines = new ArrayList<Guideline>();
	}
	
	public Guideline get(Guideline guideline) {
		return guidelines.stream().filter(gl -> gl.getId() == guideline.getId()).findFirst().get();
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
}
