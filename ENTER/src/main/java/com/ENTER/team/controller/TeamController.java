package com.ENTER.team.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "team")
public class TeamController {

	@RequestMapping(value = "teamassignment")
	public String teamassignment(Model model) {

		return "team/teamassignment.html";
	}

}
