package com.ENTER.subscription.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ENTER.subscription.domain.Account;
import com.ENTER.subscription.dto.AttachFile;
import com.ENTER.subscription.dto.BoardList;
import com.ENTER.subscription.dto.findBoard;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Repository
@RequiredArgsConstructor
public class BoardDtoImpl implements BoardDto{
	private final BoardMapper boardMapper;

	@Override
	public int insertJoin(Account account) {
		return boardMapper.insertJoin(account);
	}

	@Override
	public List<BoardList> selectJoinList() {
		// TODO Auto-generated method stub
		return boardMapper.selectJoinList();
	}

	@Override
	public void boardDel(Account account) {
		boardMapper.boardDel(account);

	}

	@Override
	public int maxJoinNum() {

		return boardMapper.maxJoinNum();
	}

	@Override
	public int createFiles(List<AttachFile> reqFiles) {
		return boardMapper.createFiles(reqFiles);
	}

	@Override
	public int createFiles_New(AttachFile at) {

		return boardMapper.createFiles_New(at);

	}

	@Override
	public int totalCount() {
		// TODO Auto-generated method stub
		return boardMapper.totalCount();
	}

	@Override
	public List<BoardList> brdListTmp(findBoard findBoard) {
		// TODO Auto-generated method stub
		return boardMapper.brdListTmp(findBoard);
	}

}
