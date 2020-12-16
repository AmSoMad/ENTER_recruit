package com.ENTER.subscription.domain;



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
public class Account {
	private int brd_no;
	private String nickname;
	private String kakaoname;
	private String gametype;
	private String brddesc;
	private MultipartFile [] files;


}
