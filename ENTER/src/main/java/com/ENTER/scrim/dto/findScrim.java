package com.ENTER.scrim.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@Data
public class findScrim {

	private int pageNo = 1;

	private int pageRowCont = 10;

    @Getter(AccessLevel.NONE)
	private int startIdx;

	@Getter(AccessLevel.NONE)
	private int endIdx;

	public int getStartIdx() {
		return (pageNo-1)*pageRowCont +1;
	}

	public int getEndIdx() {
		return pageNo * pageRowCont;
	}

}
