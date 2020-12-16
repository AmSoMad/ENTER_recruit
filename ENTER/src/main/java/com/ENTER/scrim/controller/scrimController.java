package com.ENTER.scrim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ENTER.fillter.XSSFilter;
import com.ENTER.fillter.XSSRequestWrapper;
import com.ENTER.scrim.domain.scrimForm;
import com.ENTER.scrim.dto.findScrim;
import com.ENTER.scrim.service.ScrimService;
import com.ENTER.subscription.domain.Account;
import com.ENTER.util.PaginationInfo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "scrim")
public class scrimController {
	private final ScrimService ScrimService;



	@RequestMapping(value = "scrimList")
	public String ScrimList(Model model, findScrim findScrim) {
		return "/scrim/scrimList";
	}

	@RequestMapping(value = "scrimListTmp")
	public String ScrimListTmp(Model model,@RequestBody findScrim findScrim) {
		int cnt = ScrimService.totalCount();
		PaginationInfo pagination = new PaginationInfo();
    	pagination.setCurrentPageNo(findScrim.getPageNo());
    	pagination.setRecordCountPerPage(10);
    	pagination.setPageSize(10);
    	pagination.setTotalRecordCount(cnt);
    	model.addAttribute("pagination", pagination);
    	model.addAttribute("cnt",cnt);
		model.addAttribute("list", ScrimService.scrimList(findScrim));
		log.info("scrimList");
		return "/scrim/scrimListTmp";
	}

	@RequestMapping(value = "scrimReg")
	public String ScrimReg(Model model, scrimForm scrimForm) {
		log.info("scrimReg");
		model.addAttribute("files", scrimForm);
		return "/scrim/scrimReg";
	}

	@RequestMapping(value = "scrimView")
	public String ScrimView(Model model) {
		log.info("scrimView");
		return "/scrim/scrimView";
	}

	@RequestMapping(value = "scrimRegForm")
	public String scrimRegForm(scrimForm scrimForm, Model model) {
		log.info(scrimForm.toString());
		ScrimService.scrimReg(scrimForm);
		log.info("친선완료");
		return "redirect:/scrim/scrimList";
	}

	@RequestMapping(value = "scrimDescView")
	public String scrimDescView(Model model,@RequestBody scrimForm scrimForm) {
		scrimForm sf =  ScrimService.scrimDescView(scrimForm);
		model.addAttribute("club_nm", sf.getClub_nm());
		model.addAttribute("scrim_desc", sf.getScrim_desc());
		log.info("scrimDescView");
		return "/scrim/scrimDescView";
	}

	@RequestMapping(value = "scrimDel")
	public String scrimDel(scrimForm scrimForm, Model model) {
		log.info(scrimForm.toString());
		ScrimService.scrimDel(scrimForm);
		model.addAttribute("club_nm", scrimForm.getClub_nm());
		return "scrim/scrimDel";
	}

}
