package com.ENTER.scrim.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;


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
public class scrimAttach {

	private int scrim_no;
	private String del_yn;
	private String club_nm;
	private String g_type;
	private String m_type;
	private String scrim_desc;
	private String crd_dt;
	private LocalDateTime bgn_dt;
	private String file_nm;
	private String file_path;
	private String sys_file_nm;
	private String creator;

}
