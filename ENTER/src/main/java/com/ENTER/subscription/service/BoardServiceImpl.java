package com.ENTER.subscription.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ENTER.config.AppProperties;
import com.ENTER.subscription.domain.Account;
import com.ENTER.subscription.dto.AttachFile;
import com.ENTER.subscription.dto.BoardList;
import com.ENTER.subscription.dto.findBoard;
import com.ENTER.subscription.repository.BoardDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	private final BoardDto boardDto;
	private final AppProperties appProperties;
    @Value("${spring.profiles.active}")
    private String activeProfile;

	@Override
	public int insertJoin(Account account) {

		try {
			MultipartFile [] files = account.getFiles();
			if(files != null && files.length > 0) {
				File file = new File(appProperties.getUploadDirBoard()+"/"+account.getBrd_no());
				if(!file.exists()) {
					log.debug("파일 디렉토리 없음");
					if(file.mkdirs()) {
						log.debug("디렉토리 생성 성공");
					}
				}
			}

			//List<AttachFile> reqFiles = new ArrayList<AttachFile>();
			AttachFile at = new AttachFile();
			for (MultipartFile multipartFile : files){
				if(multipartFile != null && multipartFile.getSize() > 0) {
					String profFileNm = multipartFile.getOriginalFilename();
					String profFileSize = Long.toString(multipartFile.getSize());
					String extName = profFileNm.substring(profFileNm.lastIndexOf("."), profFileNm.length());
					String profSysFileNm = "JOIN" +  UUID.randomUUID().toString()+ extName;
					log.debug("profFileNm : " + profFileNm);
					log.debug("profSysFileNm : " + profSysFileNm);
					log.debug("extName : " + extName);
					log.debug("profFileSize : " + profFileSize);

					String targetFilePath=appProperties.getUploadDirBoard() + "/" + String.valueOf(account.getBrd_no()) +"/" + profSysFileNm;
					multipartFile.transferTo(new File(targetFilePath));

					//시스템파일명 set
					if(at.getSysFileNm_1() != null && !at.getSysFileNm_1().equals("")) {
						if(at.getSysFileNm_2() != null && !at.getSysFileNm_2().equals("")) {
							at.setSysFileNm_3(profSysFileNm);
						}else {
							at.setSysFileNm_2(profSysFileNm);
						}
					}else {
						at.setSysFileNm_1(profSysFileNm);
						at.setRefNo(account.getBrd_no());
						at.setFileGb("JOIN");
						at.setFileNm(profFileNm);
						at.setFilePath(appProperties.getUploadDirBoard() + "/" + profFileNm);
						at.setFileSize(profFileSize);

					}

				}

			}
			//if (at.size() > 0 ) {	boardDto.createFiles(at);	}
			boardDto.createFiles_New(at);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		return boardDto.insertJoin(account);
	}

	@Override
	public List<BoardList> selectJoinList() {
		return boardDto.selectJoinList();
	}

	@Override
	public void boardDel(Account account) {
		boardDto.boardDel(account);

	}

	@Override
	public int maxJoinNum() {
		return boardDto.maxJoinNum();
	}

	@Override
	public int totalCount() {
		return boardDto.totalCount();
	}

	@Override
	public List<BoardList> brdListTmp(findBoard findBoard) {
		return boardDto.brdListTmp(findBoard);
	}

}
