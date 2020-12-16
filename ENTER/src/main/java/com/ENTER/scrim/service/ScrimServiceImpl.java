package com.ENTER.scrim.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ENTER.config.AppProperties;
import com.ENTER.scrim.domain.Findcalendar;
import com.ENTER.scrim.domain.scrimForm;
import com.ENTER.scrim.dto.findScrim;
import com.ENTER.scrim.dto.scrimAttach;
import com.ENTER.scrim.repository.ScrimDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ScrimServiceImpl implements ScrimService {
	final ScrimDto ScrimDto;
	private final AppProperties appProperties;
    @Value("${spring.profiles.active}")
    private String activeProfile;
	@Override
	public void scrimReg(scrimForm scrimForm) {
		try {
			MultipartFile files = scrimForm.getFiles();
			if(files != null) {
				File file = new File(appProperties.getUploadDirScrim()+"/"+scrimForm.getScrim_no());
				if(!file.exists()) {
					log.debug("파일 디렉토리 없음");
					if(file.mkdirs()) {
						log.debug("디렉토리 생성 성공");
					}
				}
			}

			//List<AttachFile> reqFiles = new ArrayList<AttachFile>();
			scrimAttach sa = new scrimAttach();
			MultipartFile multipartFile = files;
				if(multipartFile != null && multipartFile.getSize() > 0) {
					String profFileNm = multipartFile.getOriginalFilename();
					String profFileSize = Long.toString(multipartFile.getSize());
					String extName = profFileNm.substring(profFileNm.lastIndexOf("."), profFileNm.length());
					String profSysFileNm = "JOIN" +  UUID.randomUUID().toString()+ extName;
					log.info("FileNm : " + profFileNm);
					log.info("SysFileNm : " + profSysFileNm);
					log.info("extName : " + extName);
					log.info("FileSize : " + profFileSize);

					String targetFilePath=appProperties.getUploadDirScrim() + "/" + String.valueOf(scrimForm.getScrim_no()) +"/" + profSysFileNm;
					multipartFile.transferTo(new File(targetFilePath));


					sa.setBgn_dt((scrimForm.getBgn_dt()));
					sa.setClub_nm(scrimForm.getClub_nm());
					sa.setDel_yn("N");
					sa.setFile_nm(profFileNm);
					sa.setFile_path(targetFilePath);
					sa.setG_type(scrimForm.getG_type());
					sa.setM_type(scrimForm.getM_type());
					sa.setScrim_desc(scrimForm.getScrim_desc());
					sa.setScrim_no(scrimForm.getScrim_no());
					sa.setSys_file_nm(profSysFileNm);
					sa.setCreator(scrimForm.getCreator());
					ScrimDto.scrimReg(sa);
				}


			//if (reqFiles.size() > 0 ) {	boardDto.createFiles(reqFiles);	}

		}catch (Exception e) {
			throw new RuntimeException(e);
		}




	}
	@Override
	public List<scrimAttach> scrimList(findScrim findScrim) {

		return ScrimDto.scrimList(findScrim);
	}
	@Override
	public int totalCount() {

		return ScrimDto.totalCount();
	}
	@Override
	public scrimForm scrimDescView(scrimForm scrimForm) {

		return ScrimDto.scrimDescView(scrimForm);
	}
	@Override
	public ArrayList<scrimForm> findCalendarList(Findcalendar findcalendar) {

		return ScrimDto.findCalendarList(findcalendar);
	}
	@Override
	public void scrimDel(scrimForm scrimForm) {
		ScrimDto.scrimForm(scrimForm);

	}

}
