package com.ENTER.subscription.service;

import java.util.List;

import com.ENTER.subscription.domain.Account;
import com.ENTER.subscription.dto.BoardList;
import com.ENTER.subscription.dto.findBoard;

public interface BoardService {

	int insertJoin(Account account);
	List<BoardList> selectJoinList();
	void boardDel(Account account);
	int maxJoinNum();
	int totalCount();
	List<BoardList> brdListTmp(findBoard findBoard);
}
