package com.ENTER.scrim.service;

import java.util.ArrayList;
import java.util.List;

import com.ENTER.scrim.domain.Findcalendar;
import com.ENTER.scrim.domain.scrimForm;
import com.ENTER.scrim.dto.findScrim;
import com.ENTER.scrim.dto.scrimAttach;

public interface ScrimService {

	void scrimReg(scrimForm scrimForm);

	List<scrimAttach> scrimList(findScrim findScrim);

	int totalCount();

	scrimForm scrimDescView(scrimForm scrimForm);

	ArrayList<scrimForm> findCalendarList(Findcalendar findcalendar);

	void scrimDel(scrimForm scrimForm);

}
