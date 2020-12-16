package com.ENTER.scrim.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ENTER.scrim.domain.Findcalendar;
import com.ENTER.scrim.domain.scrimForm;
import com.ENTER.scrim.service.ScrimService;
import com.fasterxml.jackson.databind.JsonSerializable;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "calendar")
public class ScrimCalendarController {
	private final ScrimService scrimService;

	@GetMapping(value = "/scrim")
	public JSONArray ScrimCalendar(String start, String end) {

		JSONArray objArray = new JSONArray();
		log.debug(start+"asdasfdasdf");
		log.debug(end+"asdasfdasdf");
		Findcalendar findcalendar = new Findcalendar((start.substring(0, 10)), (end.substring(0,10))) ;
		log.debug(findcalendar.toString()+"asfdasdfasda2222222222222sdf");
		ArrayList<scrimForm> scrimList =  scrimService.findCalendarList(findcalendar);
		for(int i = 0; i < scrimList.size(); i++) {
			JSONObject obj = new JSONObject();
			obj.put("title", scrimList.get(i).getClub_nm());
			obj.put("start", String.valueOf(scrimList.get(i).getBgn_dt()));
			objArray.add(obj);
		}
		log.debug(objArray.toJSONString()+" 전달함");

		return objArray;
	}
}
