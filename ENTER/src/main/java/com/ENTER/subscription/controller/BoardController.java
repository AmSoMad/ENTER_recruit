package com.ENTER.subscription.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ENTER.config.AppProperties;
import com.ENTER.subscription.domain.Account;
import com.ENTER.subscription.dto.findBoard;
import com.ENTER.subscription.service.BoardService;
import com.ENTER.util.HtmlUtil;
import com.ENTER.util.PaginationInfo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "subscription")
public class BoardController {
	private final BoardService boardService;
	private final AppProperties appProperties;

	@RequestMapping(value = "boardList")
	public String boardList(Model model) {
		return "subscription/boardList";

	}

	@RequestMapping(value = "boardListTmp")
	public String boardListTmp(Model model,@RequestBody findBoard findBoard) {
		int cnt = boardService.totalCount();
		log.info(findBoard.toString());
		PaginationInfo pagination = new PaginationInfo();
    	pagination.setCurrentPageNo(findBoard.getPageNo());
    	pagination.setRecordCountPerPage(10);
    	pagination.setPageSize(10);
    	pagination.setTotalRecordCount(cnt);
    	model.addAttribute("pagination", pagination);
    	model.addAttribute("cnt",cnt);
		model.addAttribute("list", boardService.brdListTmp(findBoard));
		return "subscription/boardListTmp";
	}


	@RequestMapping(value = "boardReg")
	public String boardReg(Account account, Model model) {
		account.setBrd_no(boardService.maxJoinNum());
		log.info(account.toString());
		log.info(boardService.insertJoin(account)+"명 " + account.getNickname() + "  접수완료");
		model.addAttribute("desc", account.getBrddesc());
		model.addAttribute("nickname",account.getNickname());
		model.addAttribute("kakaoname",account.getKakaoname());
		model.addAttribute("gametype", account.getGametype());
		return "subscription/boardReg";
	}

	@RequestMapping(value = "boardDel")
	public String boardDel(Account account, Model model) {
		log.info(account.toString());
		boardService.boardDel(account);
		model.addAttribute("nickname", account.getNickname());

		return "subscription/boardDel";
	}









}
