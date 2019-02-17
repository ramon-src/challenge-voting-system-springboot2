package com.java.challenge.voting_system.app.http.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.challenge.voting_system.app.http.anticorruption.GuidelineDTO;
import com.java.challenge.voting_system.app.http.service.GuidelinesRulesToView;
import com.java.challenge.voting_system.infra.repository.GuidelineRepository;

@ResponseBody
@RestController
@RequestMapping("guideline")
public class GuidelineController {
	@Autowired
	private GuidelinesRulesToView guidelinesRulesToViewService;
	@Autowired
	private GuidelineRepository guidelineRepository;

	@GetMapping("/all")
	public GuidelineDTO all() {
		return guidelinesRulesToViewService.listAllGuidelines();
	}
	
	@PostMapping("/create")
	public void create(@RequestBody GuidelineDTO guidelineDTO) {
		guidelineRepository.create(guidelineDTO.getGuideline());
	}
}
