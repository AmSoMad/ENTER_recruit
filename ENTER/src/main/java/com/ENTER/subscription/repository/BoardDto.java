package com.ENTER.subscription.repository;

import java.util.List;

import com.ENTER.subscription.domain.Account;
import com.ENTER.subscription.dto.AttachFile;
import com.ENTER.subscription.dto.BoardList;
import com.ENTER.subscription.dto.findBoard;

public interface BoardDto {
	int insertJoin(Account account);
	List<BoardList> selectJoinList();
	void boardDel(Account account);
	int maxJoinNum();
	int createFiles(List<AttachFile> reqFiles);
	int createFiles_New(AttachFile at);
	int totalCount();
	List<BoardList> brdListTmp(findBoard findBoard);

}
