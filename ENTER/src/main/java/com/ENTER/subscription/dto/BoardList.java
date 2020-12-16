package com.ENTER.subscription.dto;



import java.util.List;


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
public class BoardList {

	private int brd_no;
	private String cret_dt;
	private String cretr;
	private String nick_nm;
	private String kakao_nm;
	private String game_type;
	private String brd_desc;
	private String file_nm;
	private String sys_file_nm;
	private String sys_file_nm_1;
	private String sys_file_nm_2;
	private String sys_file_nm_3;


}
