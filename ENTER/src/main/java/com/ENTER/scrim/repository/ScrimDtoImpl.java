package com.ENTER.scrim.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ENTER.scrim.domain.Findcalendar;
import com.ENTER.scrim.domain.scrimForm;
import com.ENTER.scrim.dto.findScrim;
import com.ENTER.scrim.dto.scrimAttach;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ScrimDtoImpl implements ScrimDto {
	private final ScrimMapper ScrimMapper;
	@Override
	public void scrimReg(scrimAttach scrimAttach) {
		ScrimMapper.scrimReg(scrimAttach);

	}
	@Override
	public List<scrimAttach> scrimList(findScrim findScrim) {

		return ScrimMapper.scrimList(findScrim);
	}
	@Override
	public int totalCount() {

		return ScrimMapper.totalCount();
	}
	@Override
	public scrimForm scrimDescView(scrimForm scrimForm) {
		// TODO Auto-generated method stub
		return ScrimMapper.scrimDescView(scrimForm);
	}
	@Override
	public ArrayList<scrimForm> findCalendarList(Findcalendar findcalendar) {
		// TODO Auto-generated method stub
		return ScrimMapper.findCalendarList(findcalendar);
	}
	@Override
	public void scrimForm(scrimForm scrimForm) {
		ScrimMapper.scrimForm(scrimForm);

	}

}
