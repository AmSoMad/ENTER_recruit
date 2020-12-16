package com.ENTER.scrim.domain;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class scrimForm {

	private int scrim_no;
	private String del_Yn;
	private String creator;
	private String club_nm;
	private String g_type;
	private String m_type;
	private String scrim_desc;
	private MultipartFile files;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime bgn_dt;










}
