package com.java.challenge.voting_system.app.http.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.challenge.voting_system.app.http.anticorruption.GuidelineDTO;
import com.java.challenge.voting_system.app.http.service.GuidelinesRulesToView;

@RestController
@RequestMapping("guideline")
public class GuidelineController {
	@Autowired
	private GuidelinesRulesToView guidelinesRulesToViewService;

	@GetMapping("/all")
	public GuidelineDTO all() {
		return guidelinesRulesToViewService.listAllGuidelines();
	}
}
