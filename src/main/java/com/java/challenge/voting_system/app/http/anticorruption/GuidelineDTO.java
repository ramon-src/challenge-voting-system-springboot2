package com.java.challenge.voting_system.app.http.anticorruption;

import java.util.List;

import com.java.challenge.voting_system.domain.guideline.Guideline;

public class GuidelineDTO {

	private List<Guideline> guidelines;

	public List<Guideline> getGuidelines() {
		return guidelines;
	}

	public void setGuidelines(List<Guideline> guidelines) {
		this.guidelines = guidelines;
	}

}
