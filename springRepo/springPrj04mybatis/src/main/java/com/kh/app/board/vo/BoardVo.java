package com.kh.app.board.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class BoardVo {
	
	private String no;
	private String title;
	private String content;
	private String enrollDate;
	
}
