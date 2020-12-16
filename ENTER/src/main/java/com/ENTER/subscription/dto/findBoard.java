package com.ENTER.subscription.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@Data
public class findBoard {
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
