package com.ENTER.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ENTER.home.domain.BoardForm;
import com.ENTER.subscription.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MainController {
	private final BoardService boardService;
	@RequestMapping(value = "/")
	public String main(Model model) {
		log.info("main");

		return "index";
	}
}
