package com.ENTER.subscription.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "fileNo")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AttachFile {
	private int fileNo;
	private String fileGb;
	private int refNo;
	private String fileNm;
	private String sysFileNm;
	private String filePath;
	private String fileSize;
	private String fileExt;
	private String fileType;
	private String fileKind;
	private String sysFileNm_1;
	private String sysFileNm_2;
	private String sysFileNm_3;
}
